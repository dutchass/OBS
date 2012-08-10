package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleResult;

public class LoginCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {

		String username, password;

		username = request.getParameter("username");
		password = request.getParameter("password");

		SimpleResult result = new SimpleResult(request, response);
		result.setLocation("/login.jsp"); // give login view

		// get the model from the session if it exits
		AuthenticationModel authenticationModel = (AuthenticationModel) request
				.getSession().getAttribute("auth");
		// check if we have a model and if it's authenticated, if not we use the
		// DB
		if ((authenticationModel == null || !authenticationModel
				.isAuthenticated()) && username != null) {
			UserManager userManager = new UserManager(); // get the usermanager
			authenticationModel = userManager.authenticate(username, password); // do
																				// db
																				// work
		}
		if (authenticationModel != null) {
			request.getSession().setAttribute("auth", authenticationModel);

			if (authenticationModel.isAuthenticated()) {
				request.setAttribute("redirectMessage",
						"You are logged in. Redirecting you, please wait...");
				response.setHeader("Refresh", "5;url=/");
				result.setLocation("/redirect.jsp"); // set the
														// authenticated
														// view
			}

		}
		return result;
	}
}
