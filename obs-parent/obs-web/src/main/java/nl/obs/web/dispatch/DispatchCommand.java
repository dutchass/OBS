package nl.obs.web.dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DispatchCommand {

	public DispatchResult execute(HttpServletRequest request, HttpServletResponse response);
}
