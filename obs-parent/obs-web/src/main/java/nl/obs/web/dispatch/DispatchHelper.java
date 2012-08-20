package nl.obs.web.dispatch;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class DispatchHelper {
	
	private HashMap<String, DispatchCommand> mapping = new HashMap<String, DispatchCommand>();
	
	
	/**
	 * Gets the command.
	 *
	 * @param request the request
	 * @return the command
	 */
	public DispatchCommand getCommand(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
					
		DispatchCommand command =  getDispatchCommand(pathInfo);
		if(command == null)
			
			throw new IllegalArgumentException("Command was not found for key: "+pathInfo);
		
		return command;
	}

	/**
	 * Register.
	 *
	 * @param string the string
	 * @param command the command
	 */
	public void register(String string, DispatchCommand command) {
		mapping.put(string, command);
	}
	
	/**
	 * Forward.
	 *
	 * @param result the result
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void forward(DispatchResult result) throws ServletException, IOException {
		HttpServletRequest request = result.getRequest();		
		RequestDispatcher dispatcher = request.getRequestDispatcher(result.getViewLocation()); //give appropriate view
		dispatcher.forward(request, result.getResponse());
	}
	
	/**
	 * Gets the dispatch command.
	 *
	 * @param id the id
	 * @return the dispatch command
	 */
	private DispatchCommand getDispatchCommand(String id) {
		id = id.trim();
		DispatchCommand command =  mapping.get(id);
		if(command == null) {
			if(id.endsWith("/"))
				command = mapping.get(id.substring(0, id.length()-2));
			else
				command = mapping.get(id+"/");
		}
		
		return command;
	}
}
