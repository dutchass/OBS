package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;

public interface DispatchResult {

	public HttpServletRequest getRequest();
	public String getLocation();
	
}
