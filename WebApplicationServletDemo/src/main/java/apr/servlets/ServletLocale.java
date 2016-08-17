package apr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLocale
 */
public class ServletLocale extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLocale() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Get the client's Locale
	Locale newloc = request.getLocale();
	String country = newloc.getCountry();

	// Set response content type
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	// this sets the page title and body content
	String title = "Finding Locale of current user";
	String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
		+ "<body bgcolor=\"#C0C0C0\">\n" + "<h3>" + country + "</h3>\n" + "</body></html>");

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
