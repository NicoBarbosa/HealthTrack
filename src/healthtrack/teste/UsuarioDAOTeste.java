package healthtrack.teste;

import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Usuario;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {

	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		//Cadastrar um usuário
		Usuario usuario = new Usuario();
		
		usuario.setNome("JP Zandonadi");
		usuario.setEmail("jp@gmail.com");
		usuario.setSenha("123456oi");
		usuario.setDtNascimento(Calendar.getInstance());
		usuario.setSexo("M");
		usuario.setAltura(1.65);
		usuario.setDtInclusao(Calendar.getInstance());
		
		try {
			dao.cadastrar(usuario);
			System.out.println("Usuário Cadastrado");
		} catch(DBException e) {
			e.printStackTrace();
		}
		
		//Buscar um usuário pelo código e atualizar
		usuario = dao.buscar(2);
		usuario.setNome("Lucca Zandonadi");
		usuario.setEmail("luccazan@gmail.com");
		
		try {
			dao.atualizar(usuario);
			System.out.println("Usuário Atualizado");
		} catch(DBException e) {
			e.printStackTrace();
		}
		
		//Listar os usuários
		List<Usuario> lista = dao.listar();
		for(Usuario item: lista) {
			System.out.println("Nome: " + item.getNome() + "; Email: " + item.getEmail() + "; Data de Nascimento: " + item.getData());
		}
		
		//Remover um usuário
		try {
			dao.remover(1);
			System.out.println("Usuário Deletado");
		} catch(DBException e) {
			e.printStackTrace();
		}

	}

}
