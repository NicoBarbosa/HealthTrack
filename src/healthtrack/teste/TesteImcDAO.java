package healthtrack.teste;

import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Imc;
import healthtrack.dao.ImcDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class TesteImcDAO {
	
	public static void main(String[] args) {
		ImcDAO dao = DAOFactory.getImcDAO();
		
		//Cadastrar Imc
		Imc imc = new Imc();
		
		imc.setCodigo(2);
		imc.setCodPeso(2);
		imc.setTempo(Calendar.getInstance());
		
		try {
			dao.cadastrar(imc);
			System.out.println("Imc cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		//Listar imc
		List<Imc> lista = dao.listar();
		for (Imc item : lista) {
			System.out.println (
				"COD USUÁRIO: " + item.getCodigo() + " | "
			  + "COD PESO: " + item.getCodPeso() + " | "
			  + "DT_MEDICAO: " + item.getTempo()	
			);
		}	
		
		
		
		//Remover imc
		try {
			dao.remover(1);
			System.out.println("Imc removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
