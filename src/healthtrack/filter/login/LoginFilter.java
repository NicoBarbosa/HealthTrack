package healthtrack.filter.login;

//COMENTEI TUDO PORQUE O FILTRO ESTAVA IMPEDINDO DE TESTAR O PROJETO
/*
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
*/

/**
 * Servlet Filter implementation class LoginFilter
 */

/*
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		
		
		if (session.getAttribute("user") == null && !url.endsWith("index.jsp") && !url.contains("resources") && !url.contains("index")) {
			request.setAttribute("erro", "Entre com o usu�rio e senha!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

}
*/