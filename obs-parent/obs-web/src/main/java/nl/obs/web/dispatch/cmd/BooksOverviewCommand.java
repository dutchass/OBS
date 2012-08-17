package nl.obs.web.dispatch.cmd;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.core.db.entity.Book;
import nl.obs.core.db.manager.BookManager;
import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleResult;

public class BooksOverviewCommand implements DispatchCommand {

    @Override
    public DispatchResult execute(HttpServletRequest request,
	    HttpServletResponse response) {
		
	List<Book> bookList = BookManager.getAllBooks();
	request.setAttribute("bookList", bookList);
	
	return new SimpleResult(request,response, "/productoverviewbooks.jsp");
    }

}
