package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCommand implements DispatchCommand {

	private String location;

	/**
	 * Instantiates a new simple command.
	 *
	 * @param location the location
	 */
	public SimpleCommand(String location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see nl.obs.web.dispatch.DispatchCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public DispatchResult execute(HttpServletRequest request,
			HttpServletResponse response) {
		return new SimpleResult(request, response, location);
	}

}
