package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.entity.User;
import nl.obs.core.db.manager.UserManager;
import nl.obs.core.model.LoginService;

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
		
		//aanmaken van een business service (nieuwe java class) om te kijken of de username overeen komt met het password
		//		LoginService loginService = new LoginService();
		//		boolean result = loginService.authenticate(username, password);
		
		UserManager userManager = new UserManager();
		boolean result = userManager.authenticate(username, password);
		
		
		if (result) {
			User user = loginService.getUserDetails(username);
			request.setAttribute("user",	user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
			dispatcher.forward(request, response);
			//			request.getSession().setAttribute("user", user);
			//			response.sendRedirect("homepage.jsp");
			return;
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
