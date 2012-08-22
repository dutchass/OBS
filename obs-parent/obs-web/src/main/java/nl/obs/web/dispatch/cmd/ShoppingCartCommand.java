package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.obs.core.model.ShoppingCartModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleResult;

public class ShoppingCartCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {

		ShoppingCartModel activeModel = ShoppingCartUtils.getShoppingCartModel(request.getSession());
		
		
		return new SimpleResult(request, response, "/shoppingcart.jsp");
	}

	
}