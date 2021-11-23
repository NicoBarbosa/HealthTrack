package healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Alimento;
import healthtrack.dao.AlimentoDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/alimento")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private AlimentoDAO dao;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.getAlimentoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigo"));
			Alimento alimento = dao.buscar(id);
			request.setAttribute("alimento", alimento);
			request.getRequestDispatcher("alimento-edicao.jsp").forward(request, response);
		}	
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alimento> lista = dao.listar();
		request.setAttribute("alimento", lista);
		request.getRequestDispatcher("alimentos.jsp").forward(request, response);
	}
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
		case "excluir":
			excluir(request,response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipo = request.getParameter("tipo-ali");
			double caloria = Double.parseDouble(request.getParameter("caloria-ali"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade-ali"));
			
			Alimento alimento = new Alimento(0,0,tipo,caloria,quantidade, Calendar.getInstance());
			
			dao.cadastrar(alimento);
			
			request.setAttribute("msg", "Alimento cadastrado");
			
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar alimento");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro",  "Por favor, valide os dados");
		}
		request.getRequestDispatcher("alimentos.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String tipo = request.getParameter("tipo-ali");
			double caloria = Double.parseDouble(request.getParameter("caloria-ali"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade-ali"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data-ali")));
			
			Alimento alimento = new Alimento(codigo,tipo,caloria,quantidade,data);
			
			dao.atualizar(alimento);

			request.setAttribute("msg", "Alimento atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}
	

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Alimento removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request,response);
	}

}
