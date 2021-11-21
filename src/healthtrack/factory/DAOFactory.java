package healthtrack.factory;

import healthtrack.dao.AtvFisicaDAO;
import healthtrack.dao.UsuarioDAO;
import healthtrack.implement.OracleAtvFisicaDAO;
import healthtrack.implement.OracleUsuarioDAO;

public class DAOFactory {
	//Rodrigo
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	//Nicolas
	public static AtvFisicaDAO getAtvFisicaDAO() {
		return new OracleAtvFisicaDAO();
	}
}