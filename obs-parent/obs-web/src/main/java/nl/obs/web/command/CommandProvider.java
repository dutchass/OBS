package nl.obs.web.command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class CommandProvider {
	
	private HashMap<String, Command> mapping = new HashMap<String, Command>();

	public Command getCommand(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		
		Command command =  mapping.get(pathInfo);
		if(command == null)
			throw new IllegalArgumentException("Command was not found for key: "+pathInfo);
		
		return command;
	}

	public void register(String string, Command command) {
		mapping.put(string, command);
	}
}
