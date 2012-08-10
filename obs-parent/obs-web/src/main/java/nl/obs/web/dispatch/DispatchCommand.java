package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface DispatchCommand.
 */
public interface DispatchCommand {

	/**
	 * Execute.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the dispatch result
	 */
	public DispatchResult execute(HttpServletRequest request, HttpServletResponse response);
}
