package healthtrack.factory;

import healthtrack.dao.AlimentoDAO;
import healthtrack.dao.AtvFisicaDAO;
import healthtrack.dao.ImcDAO;
import healthtrack.dao.PerfilDAO;
import healthtrack.dao.PesoDAO;
import healthtrack.dao.UsuarioDAO;
import healthtrack.implement.OracleAlimentoDAO;
import healthtrack.implement.OracleAtvFisicaDAO;
import healthtrack.implement.OracleImcDAO;
import healthtrack.implement.OraclePerfilDAO;
import healthtrack.implement.OraclePesoDAO;
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
	
	//Amanda
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	public static ImcDAO getImcDAO() {
		return new OracleImcDAO();
	}
	//Felipe
	public static PerfilDAO getPerfilDAO() {
		return new OraclePerfilDAO();
	}
}
