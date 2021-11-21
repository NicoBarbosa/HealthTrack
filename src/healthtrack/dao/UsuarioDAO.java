package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Usuario;
import healthtrack.exception.DBException;

public interface UsuarioDAO {
	void cadastrar (Usuario usuario) throws DBException;
	void atualizar (Usuario usuario) throws DBException;
	void remover (int cd_usuario) throws DBException;
	Usuario buscar(int cd_usuario);
	List<Usuario> listar();
}
