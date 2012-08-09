package nl.obs.web.command.impl;

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
		
		SimpleResult result = new SimpleResult(request);
		result.setLocation("/login.jsp"); // give login view
		
		if (username != null) {
			UserManager userManager = new UserManager();
			AuthenticationModel authenticationModel = userManager.authenticate(
					username, password);

			// set the attr in the session, since we want this accross all
			// pages.
			request.getSession().setAttribute("auth", authenticationModel);
			
			if (authenticationModel.isAuthenticated()) {
				result.setLocation("/homepage.jsp"); //set the authenticated view
			}
		}		
		return result;

	}

}
