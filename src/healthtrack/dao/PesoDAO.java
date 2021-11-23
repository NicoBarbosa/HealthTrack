package healthtrack.dao;

import java.util.List;

import healthtrack.bean.Peso;
import healthtrack.exception.DBException;

public interface PesoDAO {
	void cadastrar(Peso peso) throws DBException;
	void atualizar(Peso peso) throws DBException;
	void remover(int codigo) throws DBException;
	Alimento buscar(int cd_alimento);
	List<Peso> listar();
}
