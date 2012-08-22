package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectResult implements DispatchResult {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String redirectLocation;
		
	public RedirectResult(DispatchResult result, String redirectMessage) {
		this(result.getRequest(),result.getResponse(),redirectMessage,null);
	}
	
	public RedirectResult(HttpServletRequest request,
			HttpServletResponse response, String redirectMessage, String redirectTo) {
		super();
		this.request = request;
		this.response = response;
		this.redirectLocation = redirectTo;
		
		this.request.setAttribute("redirectMessage",redirectMessage);
		
		if(redirectTo == null)
			redirectTo = request.getParameter("referer");
		if(redirectTo == null)
			redirectTo = "";
			
		
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
	public String getViewLocation() {
		return "/redirect.jsp";
	}

	@Override
	public String getRedirectLocation() {		
		return redirectLocation;
	}
	
	
}
