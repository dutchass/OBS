package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DispatchResult {
	
	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public HttpServletRequest getRequest();

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public HttpServletResponse getResponse();

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation();

}
