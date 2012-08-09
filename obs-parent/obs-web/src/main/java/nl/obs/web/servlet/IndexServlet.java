package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.web.command.impl.LoginCommand;
import nl.obs.web.command.impl.LogoutCommand;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchHelper;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleCommand;

@WebServlet(
        name = "IndexServlet", 
        urlPatterns = {"/pages/*"}
    )
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 3364224964287966977L;
	
	private DispatchHelper provider = null;
	
	

	@Override
	public void init() throws ServletException {
		provider = new DispatchHelper();		
		provider.register("/login/",new LoginCommand());
		provider.register("/logout/",new LogoutCommand());
		provider.register("/",new SimpleCommand("/homepage.jsp"));
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DispatchCommand command = provider.getCommand(req);
		DispatchResult result = command.execute(req, resp);
		
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
