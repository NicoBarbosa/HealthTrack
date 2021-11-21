package healthtrack.dao;

import java.util.List;

import healthtrack.bean.AtividadeFisica;
import healthtrack.exception.DBException;

public interface AtvFisicaDAO {
	void cadastrar (AtividadeFisica atvFis) throws DBException;
	List<AtividadeFisica> getAll();
}
