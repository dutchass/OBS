package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleResult;

public class LogoutCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().removeAttribute("auth");	
		request.setAttribute("redirectMessage", "You are logged out. Redirecting you, please wait...");
		response.setHeader("Refresh", "5;url=/");
		return new SimpleResult(request,response, "/redirect.jsp");
	}
}
