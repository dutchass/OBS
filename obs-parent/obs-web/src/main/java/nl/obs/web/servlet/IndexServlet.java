package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.web.command.Command;
import nl.obs.web.command.CommandProvider;
import nl.obs.web.command.Result;
import nl.obs.web.command.SimpleCommand;
import nl.obs.web.command.impl.LoginCommand;

@WebServlet(
        name = "IndexServlet", 
        urlPatterns = {"","/login"}
    )
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 3364224964287966977L;
	
	private CommandProvider provider = null;
	
	

	@Override
	public void init() throws ServletException {
		provider = new CommandProvider();		
		provider.register("/login",new LoginCommand());
		provider.register("/",new SimpleCommand("/homepage.jsp"));
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Command command = provider.getCommand(req);
		Result result = command.execute(req, resp);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(result.getLocation()); //give appropriate view
		dispatcher.forward(req, resp);
		return;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	
	
}
