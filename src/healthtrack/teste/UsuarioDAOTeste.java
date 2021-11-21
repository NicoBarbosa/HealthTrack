package healthtrack.teste;

import java.util.Calendar;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {

	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAo();
		
		//Cadastrar um usuário
		Usuario usuario = new Usuario(0, "Zoe Zandonadi", "eusouzoe_gmail.com", "123456oi", "12/05/2000", "M", 1.60, Calendar.getInstance());
		
		try {
			dao.cadastrar(usuario);
			System.out.println("Produto Cadastrado");
		} catch(DBException e) {
			e.printStackTrace();
		}

	}

}
