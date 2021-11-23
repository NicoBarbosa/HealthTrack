package healthtrack.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.AtividadeFisica;
import healthtrack.implement.OracleAtvFisicaDAO;

@WebServlet("/exercicios")
public class AtvFisicaServlet extends HttpServlet {
	OracleAtvFisicaDAO dao = new OracleAtvFisicaDAO();
	
	private static final long serialVersionUID = 1L;
       
    public AtvFisicaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AtividadeFisica> lista = dao.getAll();
		request.setAttribute("atividades", lista);
		request.getRequestDispatcher("exercicios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String atividade = request.getParameter("atividade");
			int calorias = Integer.parseInt(request.getParameter("calorias"));
			
			AtividadeFisica atividadeFisica = new AtividadeFisica(0, atividade, Calendar.getInstance(), calorias);
			
			dao.cadastrar(atividadeFisica);
			
			request.setAttribute("msg", "Atividade fisica cadastrada");
		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao cadastrar atividade");
		}
		
		doGet(request, response);
		}
	
}