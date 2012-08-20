package nl.obs.web.dispatch.cmd;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.entity.Customer;
import nl.obs.core.db.entity.User;
import nl.obs.core.db.manager.OrderManager;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.core.model.PlacedOrderModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleResult;

public class OrderOverviewCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {

		DispatchResult result = new SimpleResult(request, response,
				"/orderoverview.jsp");

		AuthenticationModel authenticationModel = (AuthenticationModel) request
				.getSession().getAttribute("auth");
		if (authenticationModel == null)
			return result;
		

		User user = authenticationModel.getUser();
		if(!(user instanceof Customer))
			return result;
		
		Customer customer = (Customer)user;
		List<PlacedOrderModel> placedOrders = OrderManager.getPlacedOrders(customer);
				
		request.setAttribute("orderList", placedOrders);
		
		return result;
	}
}
