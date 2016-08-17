package apr.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterDemo
 */
public class FilterDemo implements Filter {

    /**
     * Default constructor.
     */
    public FilterDemo() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	// TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	// IP address of the client machine.
	String remoteAddress = request.getRemoteAddr();

	// Returns the remote address
	System.out.println("Remote Internet Protocl Address: " + remoteAddress);

	chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	// init parameter
	String value = fConfig.getInitParameter("newParam");

	// displaying init parameter value
	System.out.println("The Parameter value: " + value);
    }

}
