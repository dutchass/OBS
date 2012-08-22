package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectResult implements DispatchResult {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Type type;
		
	public RedirectResult(DispatchResult result, String redirectMessage) {
		this(result.getRequest(),result.getResponse(),redirectMessage);
	}
	
	public RedirectResult(HttpServletRequest request,
			HttpServletResponse response, String redirectMessage) {
		super();
		this.request = request;
		this.response = response;
		this.type = type;
		
		this.request.setAttribute("redirectMessage",redirectMessage);

		
		this.response.setHeader("Refresh", "3;url="+request.getHeader("referer"));		
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
