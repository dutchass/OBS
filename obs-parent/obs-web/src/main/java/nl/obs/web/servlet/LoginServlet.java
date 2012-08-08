package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.AuthenticationModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		name="LoginServlet",
		urlPatterns={"/login"}
)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username, password;
		
		username= request.getParameter("username");
		password= request.getParameter("password");
		
		UserManager userManager = new UserManager();
		AuthenticationModel authenticationModel = userManager.authenticate(username, password);
		
		//set the attr in the session, since we want this accross all pages.
		request.getSession().setAttribute("auth",authenticationModel);
		
				
		if (authenticationModel.isAuthenticated()) {			
			response.sendRedirect("homepage.jsp");
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}		
	}
}
