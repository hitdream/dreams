package jenkin.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class IPFilter
 */
/**
 * @author jenkin
 *
 */
public class IPFilter implements Filter {

 private String filterIP ,error;
 public FilterConfig config;
 
    public IPFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp");
	String remoteIP=request.getRemoteAddr();
//	System.out.println(remoteIP);
	if(remoteIP.equals(filterIP))
	{
		dispatcher.forward(request, response);
	}
	else
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
		filterIP=config.getInitParameter("IP");
		if(filterIP==null)
		{
			filterIP="";
		}
		error=config.getInitParameter("error");
		if(error==null)
		{
			error="error.jsp";
		}
	}

}
