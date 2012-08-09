package nl.obs.web.command;

import javax.servlet.http.HttpServletRequest;

public interface Result {

	public HttpServletRequest getRequest();
	public String getLocation();
	
}
