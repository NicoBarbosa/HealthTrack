package healthtrack.factory;

import healthtrack.dao.UsuarioDAO;
import healthtrack.implement.OracleUsuarioDAO;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}