package healthtrack.dao;

import healthtrack.bean.Perfil;
import healthtrack.exception.DBException;

public interface PerfilDAO {
	void atualizar (Perfil perfil) throws DBException;
	Perfil buscar(int cd_usuario);
}
