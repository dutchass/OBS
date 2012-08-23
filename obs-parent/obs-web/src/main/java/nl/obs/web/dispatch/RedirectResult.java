package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectResult implements DispatchResult {

	private HttpServletRequest request;
	private HttpServletResponse response;
			
	public RedirectResult(DispatchResult result, String redirectMessage, String redirectTo) {
		this(result.getRequest(),result.getResponse(),redirectMessage, redirectTo);
	}
	
	public RedirectResult(HttpServletRequest request,
			HttpServletResponse response, String redirectMessage, String redirectTo) {
		super();
		this.request = request;
		this.response = response;
		
		if(redirectTo == null)
			redirectTo = request.getHeader("referer");
		
		this.request.setAttribute("redirectMessage",redirectMessage);		
		this.response.setHeader("Refresh", "3;url="+redirectTo);		
	}

	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public String getLocation() {
		return "/redirect.jsp";
	}
}
