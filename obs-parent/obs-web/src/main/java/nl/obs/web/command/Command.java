package nl.obs.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	public Result execute(HttpServletRequest request, HttpServletResponse response);
}
