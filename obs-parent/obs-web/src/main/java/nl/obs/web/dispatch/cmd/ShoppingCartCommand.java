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
		
	ShoppingCartModel activeModel = getShoppingCartModelFromSession(request.getSession());
	if(activeModel == null) {
	    activeModel = new ShoppingCartModel();
	    setShoppingCartModelInSession(activeModel, request.getSession());
	}
	//zo, nu zit ie in de sessie en als ie er niet in zit, dan maken we
	//een nieuwe aan en stoppen em in de sessie...
	
	
	return new SimpleResult(request,response, "/shoppingcart.jsp");
    }
    
    private ShoppingCartModel getShoppingCartModelFromSession(HttpSession session) {
	return (ShoppingCartModel)session.getAttribute("shoppingCartModel");
    }
    
    private void setShoppingCartModelInSession(ShoppingCartModel model, HttpSession session) {
	session.setAttribute("shoppingCartModel", model);   
    }
}