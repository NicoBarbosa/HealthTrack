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

import healthtrack.bean.Peso;
import healthtrack.exception.DBException;
import healthtrack.implement.OraclePesoDAO;

@WebServlet("/peso")
public class PesoServlet {
	OraclePesoDAO dao = new OraclePesoDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigo"));
			Peso peso = dao.buscar(id);
			request.setAttribute("peso", peso);
			request.getRequestDispatcher("peso-edicao.jsp").forward(request, response);
		}	
	}
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peso> lista = dao.listar();
		request.setAttribute("peso", lista);
		request.getRequestDispatcher("peso.jsp").forward(request, response);
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
			double vlPeso = Double.parseDouble(request.getParameter("peso"));
			
			Peso peso = new Peso(0,0,vlPeso, Calendar.getInstance());
			
			dao.cadastrar(peso);
			
			request.setAttribute("msg", "Peso cadastrado");
			
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar alimento");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro",  "Por favor, valide os dados");
		}
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			double vlPeso = Double.parseDouble(request.getParameter("peso"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data-ali")));
			
			Peso peso = new Peso(codigo,vlPeso,data);
			
			dao.atualizar(peso);

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

