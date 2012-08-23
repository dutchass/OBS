package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.entity.Order;
import nl.obs.core.db.manager.OrderManager;
import nl.obs.core.model.CustomerAuthenticationModel;
import nl.obs.core.model.ShoppingCartModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.RedirectResult;
import nl.obs.web.dispatch.SimpleResult;

public class OrderConfirmationCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {

		DispatchResult result = new SimpleResult(request, response,
				"/orderConfirmation.jsp");

		String action = request.getParameter("action");
		if (action != null && action.equals("finalize")) {
			ShoppingCartModel model = ShoppingCartUtils
					.getShoppingCartModel(request.getSession());
			CustomerAuthenticationModel customerAuthenticationModel = (CustomerAuthenticationModel) AuthenticationUtils
					.getAuthenticationModel(request.getSession());
			if (customerAuthenticationModel.isAuthenticated()) {

				Order order = OrderManager.createOrder(
						customerAuthenticationModel.getCustomer(), model);
				OrderManager.persistOrder(order);
				result = new RedirectResult(
						request,
						response,
						"Uw bestelling is geplaatst, een ogenblik geduld a.u.b...",
						"/orders/");

				ShoppingCartUtils.removeShoppingCartModel(request.getSession());
			}
		}

		return result;
	}
}
