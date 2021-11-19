package healthtrack.filter.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		
		
		if (session.getAttribute("user") == null && !url.endsWith("login") && !url.contains("resources") && !url.contains("home")) {
			request.setAttribute("erro", "Entre com o usuário e senha!");
			request.getRequestDispatcher("colocar-o-nome-da-jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

}
