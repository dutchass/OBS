package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;

public class SimpleResult implements DispatchResult {

	private String location;
	private HttpServletRequest request;
	
	public SimpleResult(HttpServletRequest request) {
		this.request = request;
	}
	
	public SimpleResult(String location, HttpServletRequest request) {
		this.location = location;
		this.request = request;
	}
	
	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}	
}
