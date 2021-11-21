package healthtrack.teste;

import java.util.Calendar;

import healthtrack.bean.AtividadeFisica;
import healthtrack.dao.AtvFisicaDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class CadastrarAtvFisicaDAOTeste {

	public static void main(String[] args) {
		AtvFisicaDAO dao = DAOFactory.getAtvFisicaDAO();
		
		AtividadeFisica atv = new AtividadeFisica();
		//CADASTRAR ATIVIDADE FISICA
		atv.setCodigo(1);
		atv.setTipoAtividade("Abdominais");
		atv.setTempo(Calendar.getInstance());
		atv.setCalorias(147);

		try {
			dao.cadastrar(atv);
			System.out.println("Atividade Cadastrada!");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
