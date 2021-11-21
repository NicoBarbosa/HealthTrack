package healthtrack.teste;

import java.util.Calendar;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {

	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		//Cadastrar um usu√°rio
		Usuario usuario = new Usuario();
		
		
		usuario.setNome("Zoe Zandonadi");
		usuario.setEmail("eusouzoe@gmail.com");
		usuario.setSenha("123456oi");
		usuario.setDtNascimento(Calendar.getInstance());
		usuario.setSexo("F");
		usuario.setAltura(1.60);
		usuario.setDtInclusao(Calendar.getInstance());
		try {
			dao.cadastrar(usuario);
			System.out.println("Usu·rio Cadastrado");
		} catch(DBException e) {
			e.printStackTrace();
		}

	}

}
