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

import healthtrack.bean.Imc;
import healthtrack.dao.ImcDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/alimento")
public class ImcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private ImcDAO dao;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.getImcDAO();
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
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Imc> lista = dao.listar();
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
		case "excluir":
			excluir(request,response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codUser = Integer.parseInt(request.getParameter("codUser"));
			String strDate = request.getParameter("dt");
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    Calendar dataMedicao = Calendar.getInstance();     
		    dataMedicao.setTime(sdf.parse(strDate));
			
			Imc imc = new Imc(codUser, dataMedicao);
			
			dao.cadastrar(imc);
			
			request.setAttribute("msg", "IMC cadastrado");
			
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar imc");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro",  "Por favor, valide os dados");
		}
		request.getRequestDispatcher("imc.jsp").forward(request, response);
	}
	

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "IMC removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao deletar imc");
		}
		listar(request,response);
	}

}
