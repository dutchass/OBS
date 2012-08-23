package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.model.CustomerAuthenticationModel;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.RedirectResult;

public class LogoutCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().setAttribute("auth", new CustomerAuthenticationModel());
		
		String redirect= request.getHeader("referer");
		if(redirect == null || redirect.isEmpty())
			redirect = "/";		
		
		return new RedirectResult(request,response, "U bent uitgelogd, een ogenblik geduld a.u.b...",redirect);
	}
}
