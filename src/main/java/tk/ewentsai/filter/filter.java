package tk.ewentsai.filter;

import javax.servlet.*;
import java.io.IOException;

public class filter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
