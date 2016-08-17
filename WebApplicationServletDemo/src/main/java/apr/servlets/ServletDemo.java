package apr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 * 
 * http://localhost:8080/WebApplicationServletDemo/index.jsp
 * http://localhost:8080/WebApplicationServletDemo/ServletDemo
 * 
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	try {
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlets</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println(
		    "<br /><p><h2>First Demo Servlet application</h2><br />Here, the URL-pattern is ServletDemo in web.xml. So, the address is <i>WebApplicationServletDemo/ServletDemo</i>.</p>");
	    out.println("<br /><br /><a href=\"index.jsp\">Previous Page</a>");
	    out.println("</body>");
	    out.println("</html>");
	} finally {
	    out.close();
	}
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
