package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.RedirectResult;
import nl.obs.web.dispatch.SimpleResult;

public class LoginCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {

		String username, password;

		username = request.getParameter("username");
		password = request.getParameter("password");

		SimpleResult result = new SimpleResult(request, response);
		result.setViewLocation("/login.jsp"); // give login view
		
		// get the model from the session if it exits
		AuthenticationModel authenticationModel = AuthenticationUtils.getAuthenticationModel(request.getSession());
		// check if we have a model and if it's authenticated, if not we use the
		// DB
		if ((authenticationModel == null || !authenticationModel
				.isAuthenticated()) && username != null) {			
			authenticationModel = AuthenticationUtils.authenticate(username, password, request.getSession());
		}
		if (authenticationModel != null) {
			if (authenticationModel.isAuthenticated()) {
				String redirect = request.getHeader("referer");
				if(redirect == null || redirect.isEmpty())
					redirect = "/";
				return new RedirectResult(result, "U bent succesvol ingelogd, een ogenblik geduld a.u.b...",redirect);
			}

		}
		return result;
	}
}
