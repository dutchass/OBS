package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.entity.Book;
import nl.obs.core.db.manager.BookManager;

@WebServlet(
        name = "HelloServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 6663501646932303333L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        
        BookManager  manager = new BookManager();
        
        Book b = new Book();
		b.setTitle("Suske en Wiske en het geheim van de JP API");
		b.setISBNnumber(76430868);
        manager.saveBook(b);
        
        out.write("hello world!".getBytes());
        out.flush();
        out.close();
    }

}
