package nl.obs.web.dispatch.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.RedirectResult;

public class LogoutCommand implements DispatchCommand {

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		return new RedirectResult(request,response, "U bent uitgelogd, een ogenblik geduld a.u.b..." , "/");
	}
}
