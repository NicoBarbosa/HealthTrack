package healthtrack.teste;

import java.util.Calendar;

import healthtrack.bean.Alimento;
import healthtrack.dao.AlimentoDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class AlimentoDAOTeste {

	public static void main(String[] args) {
		AlimentoDAO dao = DAOFactory.getAlimentoDAO();
		
		Alimento alimento = new Alimento();
		
		alimento.setChaveUser(0);
		alimento.setAlimento("banana");
		alimento.setCaloria(20);
		alimento.setQuantidade(2);
		alimento.setData(Calendar.getInstance());
		
		try {
			dao.cadastrar(alimento);
			System.out.println("Usuário Cadastrado");
		} catch(DBException e) {
			e.printStackTrace();
		}

	}

}
