package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Imc;
import healthtrack.dao.ImcDAO;
import healthtrack.exception.DBException;
import healthtrack.connection.bd.ConnectionManager;

public class OracleImcDAO implements ImcDAO{
	
    private Connection conexao;
	
	@Override
	public void cadastrar(Imc imc) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getConnection();
			String sql = "INSERT INTO T_HTK_IMC (CD_IMC, T_HTK_USER_CD_USUARIO, T_HTK_PESO_CD_PESO, DT_MEDICAO) VALUES (SQ_IMC.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, imc.getCodigo());
			stmt.setDouble(2, imc.getCodPeso());
			java.sql.Date data = new java.sql.Date(imc.getTempo().getTimeInMillis());
			stmt.setDate(3, data);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void remover(int codigo) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getConnection();
				String sql = "DELETE FROM T_HTK_IMC WHERE CD_IMC = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao remover.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	@Override
	public List<Imc> listar() {
		List<Imc> lista = new ArrayList<Imc>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_IMC");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int user = rs.getInt("T_HTK_USER_CD_USUARIO");
				int nrPeso = rs.getInt("T_HTK_PESO_CD_PESO");
				java.sql.Date data = rs.getDate("DT_MEDICAO");
				Calendar dataMedicao = Calendar.getInstance();
				dataMedicao.setTimeInMillis(data.getTime());
				
				Imc imc = new Imc( user, nrPeso, dataMedicao);
				lista.add(imc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
}
