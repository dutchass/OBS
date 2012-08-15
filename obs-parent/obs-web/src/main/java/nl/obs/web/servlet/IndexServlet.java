package nl.obs.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.obs.web.dispatch.DispatchCommand;
import nl.obs.web.dispatch.DispatchHelper;
import nl.obs.web.dispatch.DispatchResult;
import nl.obs.web.dispatch.SimpleCommand;
import nl.obs.web.dispatch.cmd.BooksOverviewCommand;
import nl.obs.web.dispatch.cmd.LoginCommand;
import nl.obs.web.dispatch.cmd.LogoutCommand;

/**
 * The Class IndexServlet.
 */
@WebServlet(name = "IndexServlet", urlPatterns = { "/pages/*" })
public class IndexServlet extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3364224964287966977L;

    /** The dispatch helper. */
    private DispatchHelper dispatchHelper = null;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
	dispatchHelper = new DispatchHelper();
	dispatchHelper.register("/login/", new LoginCommand()); // register the
								// login command
	dispatchHelper.register("/logout/", new LogoutCommand()); // register
								  // the logout
								  // command
	dispatchHelper.register("/", new SimpleCommand("/homepage.jsp")); // register
									  // the
									  // command
	dispatchHelper.register("/books/", new BooksOverviewCommand());
	}

    /**
     * Process.
     * 
     * @param req
     *            the req
     * @param resp
     *            the resp
     * @throws ServletException
     *             the servlet exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * 
     *             Voorbeeld aannemer en huis, req is het eisen pakket van de
     *             klant, response is leeg huis, (gebaseerd op het chain model
     *             voorbeeld met de verschillende fasen) Req object is gevuld
     *             met data, response object is leeg huis wat ingericht moet
     *             gaan worden. Dipatchcommand is de aannemer die gevonden moet
     *             worden. Command is de process (req,resp)
     * 
     */
    private void process(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	DispatchCommand command;
	try {
	    // fetch the command from the register based on the request
	    //DispatchHelper zoekt de aannemer
	    command = dispatchHelper.getCommand(req);

	} catch (Exception e) {
	    throw new ServletException(e);
	}
	// execute the fetched command and retrieve the resulting dispatch
	// (view)
	DispatchResult result = command.execute(req, resp);
	// forward to the dispatch result (view)
	// result is gelijk aan het resultaat van een fase, hoeft geen eindresultaat te zijn
	DispatchHelper.forward(result);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// forward to process, let the command structure figure out what
	// happens next
	// doGet is (URL)
	process(req, resp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// forward to process, let the command structure figure out what
	// happens next
	//(doPost is bijvoorbeeld (URL, args)
	process(req, resp);
    }
}
