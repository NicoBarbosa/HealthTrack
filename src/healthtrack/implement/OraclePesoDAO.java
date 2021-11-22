package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Peso;
import healthtrack.dao.PesoDAO;
import healthtrack.exception.DBException;
import healthtrack.connection.bd.ConnectionManager;


public class OraclePesoDAO implements PesoDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getConnection();
			String sql = "INSERT INTO T_HTK_PESO (CD_PESO, T_HTK_USER_CD_USUARIO, VL_PESO, DT_MEDICAO) VALUES (SQ_PESO.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getFk());
			stmt.setDouble(2, peso.getPeso());
			java.sql.Date data = new java.sql.Date(peso.getTempo().getTimeInMillis());
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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getConnection();
			String sql = "UPDATE T_HTK_PESO SET VL_PESO = ?, DT_MEDICAO = ? WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, peso.getPeso());
			java.sql.Date data = new java.sql.Date(peso.getTempo().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setInt(3, peso.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
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
				String sql = "DELETE FROM T_HTK_PESO WHERE CD_PESO = ?";
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
	public List<Peso> listar() {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_PESO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_PESO");
				double valor = rs.getDouble("VL_PESO");
				java.sql.Date data = rs.getDate("DT_MEDICAO");
				Calendar dataMedicao = Calendar.getInstance();
				dataMedicao.setTimeInMillis(data.getTime());
				
				Peso peso = new Peso(codigo, valor, dataMedicao);
				lista.add(peso);
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
