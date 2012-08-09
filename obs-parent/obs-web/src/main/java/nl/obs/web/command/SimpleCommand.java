package nl.obs.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleCommand implements Command {

	private String location;
	
	public SimpleCommand(String location) {
		this.location = location;
	}

	@Override
	public Result execute(HttpServletRequest request,
			HttpServletResponse response) {
		return new SimpleResult(location,request);
	}

	
}
