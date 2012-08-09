package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleCommand implements DispatchCommand {

	private String location;
	
	public SimpleCommand(String location) {
		this.location = location;
	}

	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		return new SimpleResult(location,request);
	}

	
}
