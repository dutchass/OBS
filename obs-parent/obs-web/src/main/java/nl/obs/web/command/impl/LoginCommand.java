package nl.obs.web.command.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.AuthenticationModel;
import nl.obs.web.command.Command;
import nl.obs.web.command.Result;
import nl.obs.web.command.SimpleResult;

public class LoginCommand implements Command {

	@Override
	public Result execute(HttpServletRequest request,
			HttpServletResponse response) {

		String username, password;

		username = request.getParameter("username");
		password = request.getParameter("password");

		UserManager userManager = new UserManager();
		AuthenticationModel authenticationModel = userManager.authenticate(
				username, password);

		// set the attr in the session, since we want this accross all pages.
		request.getSession().setAttribute("auth", authenticationModel);

		SimpleResult result = new SimpleResult(request);
		if (authenticationModel.isAuthenticated()) {
			result.setLocation("/homepage.jsp");
			return result;
		}

		result.setLocation("login.jsp"); // give login view
		return result;

	}

}
