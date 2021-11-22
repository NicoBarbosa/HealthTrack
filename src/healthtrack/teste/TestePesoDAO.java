package healthtrack.teste;

import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Peso;
import healthtrack.dao.PesoDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class TestePesoDAO {
	
	public static void main(String[] args) {
		PesoDAO dao = DAOFactory.getPesoDAO();
		
		//Cadastrar peso
		Peso peso = new Peso();
		
		peso.setFk(1);
		peso.setPeso(69);
		peso.setTempo(Calendar.getInstance());
		
		try {
			dao.cadastrar(peso);
			System.out.println("Peso cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		
		//Listar os pesos
		
		List<Peso> lista = dao.listar();
		for (Peso item : lista) {
			System.out.println(item.getPeso());
		}
		
		
		//Remover um peso
		
		try {
			dao.remover(1);
			System.out.println("Peso removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}	

}


