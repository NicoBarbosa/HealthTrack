package healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/autenticar")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
			
			int codigo = Integer.parseInt(request.getParameter("cd_usuario"));
			Usuario usuario = dao.buscarPorEmail(email);
		
			if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
				request.getSession().setAttribute("usuario", usuario);
				request.setAttribute("msg",  "Login realizado com sucesso");
			}else {
				request.setAttribute("msg",  "Não foi possível realizar o login");
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro",  "Por favor, valide os dados");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
