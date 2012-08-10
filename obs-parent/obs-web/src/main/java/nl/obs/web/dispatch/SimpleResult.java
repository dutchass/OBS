package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleResult implements DispatchResult {

	private String location;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * Instantiates a new simple result.
	 *
	 * @param request the request
	 * @param response the response
	 */
	public SimpleResult(HttpServletRequest request, HttpServletResponse response) {
		this(request,response,null);
	}
	
	/**
	 * Instantiates a new simple result.
	 *
	 * @param request the request
	 * @param response the response
	 * @param location the location
	 */
	public SimpleResult(HttpServletRequest request, HttpServletResponse response, String location) {
		if(request == null)
			throw new IllegalArgumentException("request can not be null");
		if(response == null)
			throw new IllegalArgumentException("response can not be null");
		
		this.location = location;
		this.request = request;
		this.response = response;
	}
	
	/* (non-Javadoc)
	 * @see nl.obs.web.dispatch.DispatchResult#getRequest()
	 */
	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	/* (non-Javadoc)
	 * @see nl.obs.web.dispatch.DispatchResult#getLocation()
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see nl.obs.web.dispatch.DispatchResult#getResponse()
	 */
	@Override
	public HttpServletResponse getResponse() {
		return this.response;
	}	
	
	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}	
	
}
