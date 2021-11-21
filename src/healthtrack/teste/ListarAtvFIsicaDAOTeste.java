package healthtrack.teste;

import java.util.List;

import healthtrack.bean.AtividadeFisica;
import healthtrack.implement.OracleAtvFisicaDAO;

public class ListarAtvFIsicaDAOTeste {

public static void main(String[] args) {
		
		OracleAtvFisicaDAO dao = new OracleAtvFisicaDAO();
		
		List<AtividadeFisica> lista = dao.getAll();
		for(AtividadeFisica atv: lista) {
			System.out.println(
					 "CÓDIGO: " +atv.getCodigo() + " | " 
					+"TIPO: " +atv.getTipoAtividade() + " | " 
					+"KCAL: " +atv.getCalorias() + " | "
					+"DATA: " +atv.getTempo());
					
		}
	}
}
