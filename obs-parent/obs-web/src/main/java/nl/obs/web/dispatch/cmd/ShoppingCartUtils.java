package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpSession;

import nl.obs.core.model.ShoppingCartModel;

public class ShoppingCartUtils {
	
	public static ShoppingCartModel getShoppingCartModel(HttpSession session) {
		ShoppingCartModel model = getShoppingCartModelFromSession(session);
		if(model != null)
			return model;
		
		model = new ShoppingCartModel();
		setShoppingCartModelInSession(model, session);
		return model;
	}
	
	public static void removeShoppingCartModel(HttpSession httpSession){
	    httpSession.removeAttribute("shoppingCartModel");
	    ShoppingCartModel model = new ShoppingCartModel();
	    setShoppingCartModelInSession(model, httpSession);
	}
	
	private static ShoppingCartModel getShoppingCartModelFromSession(
			HttpSession session) {
		return (ShoppingCartModel) session.getAttribute("shoppingCartModel");
	}

	private static void setShoppingCartModelInSession(ShoppingCartModel model,
			HttpSession session) {
		session.setAttribute("shoppingCartModel", model);
	}
}
