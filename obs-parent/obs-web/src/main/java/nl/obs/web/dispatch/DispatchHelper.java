package nl.obs.web.dispatch;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class DispatchHelper {
	
	private HashMap<String, DispatchCommand> mapping = new HashMap<String, DispatchCommand>();
	
	
	public DispatchCommand getCommand(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
					
		DispatchCommand command =  getDispatchCommand(pathInfo);
		if(command == null)
			
			throw new IllegalArgumentException("Command was not found for key: "+pathInfo);
		
		return command;
	}

	public void register(String string, DispatchCommand command) {
		mapping.put(string, command);
	}
	
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
