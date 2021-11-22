package healthtrack.factory;

import healthtrack.dao.AlimentoDAO;
import healthtrack.dao.AtvFisicaDAO;
import healthtrack.dao.UsuarioDAO;
import healthtrack.implement.OracleAlimentoDAO;
import healthtrack.implement.OracleAtvFisicaDAO;
import healthtrack.implement.OracleUsuarioDAO;

public class DAOFactory {
	//Mizack
	public static AlimentoDAO getAlimentoDAO() {
		return new OracleAlimentoDAO();
	}
	
	//Rodrigo
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	//Nicolas
	public static AtvFisicaDAO getAtvFisicaDAO() {
		return new OracleAtvFisicaDAO();
	}
}
