package healthtrack.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
=======
>>>>>>> 8a41c7ab7bba0960ecf28fd7eb23906694112793

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private UsuarioDAO dao;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*List<Usuario> lista = dao.listar();
		request.setAttribute("usuarios", lista);
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);*/
		
		int codigo = Integer.parseInt(request.getParameter("cd_usuario"));
		Usuario usuario = dao.buscar(codigo);
		request.getRequestDispatcher("perfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String strDate = request.getParameter("dtNascimento");
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    Calendar dtNascimento = Calendar.getInstance();     
		    dtNascimento.setTime(sdf.parse(strDate));
			String sexo = request.getParameter("sexo");
			double altura = Double.parseDouble(request.getParameter("altura"));
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setDtNascimento(dtNascimento);
			usuario.setSexo(sexo);
			usuario.setAltura(altura);
			
			dao.cadastrar(usuario);
			request.setAttribute("msg", "Usuário cadastrado");
			
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar o usuário");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro",  "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

}
