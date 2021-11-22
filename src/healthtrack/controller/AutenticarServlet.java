package healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/login")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarServlet() {
        super();
        dao = DAOFactory.getUsuarioDAO();
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
		String email = request.getParameter("email");
        String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(email, senha);
		
		if(dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
		}else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
