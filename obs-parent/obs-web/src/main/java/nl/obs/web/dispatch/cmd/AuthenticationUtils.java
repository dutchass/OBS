package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpSession;

import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.core.model.CustomerAuthenticationModel;

public class AuthenticationUtils {

	public static AuthenticationModel getAuthenticationModel(HttpSession session) {
		AuthenticationModel model = (AuthenticationModel) session
				.getAttribute("auth");
		if (model == null) {
			model = new CustomerAuthenticationModel();
			session.setAttribute("auth", model);
		}
		return model;
	}

	public static void removeAuthenticationModel(HttpSession session) {
		session.removeAttribute("auth");
	}

	public static AuthenticationModel authenticate(String username,
			String password, HttpSession session) {
		AuthenticationModel authenticationModel = UserManager
				.authenticateCustomer(username, password);
		session.setAttribute("auth", authenticationModel);
		return authenticationModel;
	}
}
