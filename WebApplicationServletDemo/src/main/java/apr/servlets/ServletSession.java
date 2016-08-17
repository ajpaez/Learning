package apr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSession
 */
public class ServletSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSession() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// session object creation
	HttpSession newSession = request.getSession(true);
	// Session creation time.
	Date cTime = new Date(newSession.getCreationTime());
	// The last time the client sent a request.
	Date lTime = new Date(newSession.getLastAccessedTime());

	/*
	 * sets the time, in seconds, between client requests before the servlet
	 * container invalidates this session
	 */
	newSession.setMaxInactiveInterval(1 * 60 * 60);
	String str = "Website | Session";

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	String document = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	out.println(document + "<html>\n" + "<head><title>" + str + "</title></head>\n" + "<body bgcolor=\"#bbf5f0\">\n"
		+ "<h2>Website: Displaying Session Information</h2>\n" + "<table border=\"2\">\n" + "<tr>\n"
		+ "  <td>Unique identifier assigned to this session</td>\n" + "  <td>" + newSession.getId() + "</td>"
		+ "</tr>\n" + "<tr>\n" + "  <td>The time when this session was created</td>\n" + "  <td>" + cTime
		+ "  </td>" + "</tr>\n" + "<tr>\n"
		+ "  <td>The last time the client sent a request associated with this session</td>\n" + "  <td>" + lTime
		+ "  </td>" + "</tr>\n" + "</tr>\n" + "<tr>\n"
		+ "  <td> the maximum time interval, in seconds that the servlet container will keep this session open between client accesses.</td>\n"
		+ "  <td>" + newSession.getMaxInactiveInterval() + "  </td>" + "</tr>\n" + "</table>\n"
		+ "</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
