package healthtrack.dao;
import java.util.List;
import healthtrack.bean.Alimento;
import healthtrack.exception.DBException;
public interface AlimentoDAO {
	void cadastrar (Alimento alimento) throws DBException;
	void atualizar (Alimento alimento) throws DBException;
	void remover (int cd_alimento) throws DBException;
	Alimento buscar(int cd_alimento);
	List<Alimento> listar();
}
