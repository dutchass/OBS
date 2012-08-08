package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "IndexServlet", 
        urlPatterns = {"/"}
    )
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 3364224964287966977L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp"); //give login view
		dispatcher.forward(req, resp);
		return;
	}

	
}
