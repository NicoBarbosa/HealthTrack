package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Imc;
import healthtrack.exception.DBException;

public interface ImcDAO {
	void cadastrar(Imc imc) throws DBException;
	void remover(int codigo) throws DBException;
	List<Imc> listar();
}
