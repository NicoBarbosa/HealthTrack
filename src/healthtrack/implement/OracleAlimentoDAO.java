package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List; 

import healthtrack.bean.Alimento;
import healthtrack.connection.bd.ConnectionManager;
import healthtrack.dao.AlimentoDAO;
import healthtrack.exception.DBException;

public class OracleAlimentoDAO implements AlimentoDAO {
	private Connection conexao;
	@Override
	public void cadastrar(Alimento alimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "INSERT INTO T_HTK_ALIMENTO (CD_ALIMENTO, T_HTK_USER_CD_USUARIO, DS_TIPO, QT_CALORIA, QT_INGERIDA, DT_INGERIDO) VALUES (SQ_ALIMENTO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, 1);
			stmt.setString(2, alimento.getAlimento());
			stmt.setDouble(3, alimento.getCaloria());
			stmt.setInt(4, alimento.getQuantidade());
			java.sql.Date data = new java.sql.Date(alimento.getData().getTimeInMillis());
			stmt.setDate(5, data);
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
	public void atualizar(Alimento alimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "UPDATE INTO T_HTK_ALIMENTO SET DS_TIPO = ?, QT_CALORIA = ?, QT_INGERIDA = ?, DT_INGERIDO = ? WHERE CD_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, alimento.getAlimento());
			stmt.setDouble(2, alimento.getCaloria());
			stmt.setInt(3, alimento.getQuantidade());
			java.sql.Date data = new java.sql.Date(alimento.getData().getTimeInMillis());
			stmt.setDate(4, data);
			
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
	public void remover(int cd_alimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "DELETE FROM T_HTK_ALIMENTO WHERE cd_alimento = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_alimento);
			
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
	public Alimento buscar(int cd_alimento) {
		Alimento alimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "SELECT * FROM T_HTK_ALIMENTO WHERE cd_alimento = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_alimento);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigo = rs.getInt("cd_alimento");
    	    	int codigo_user = rs.getInt("t_htk_user_cd_usuario");
    	    	String tipo = rs.getString("ds_tipo");
    	    	double caloria = rs.getDouble("qt_caloria");
    	    	int quantidade = rs.getInt("qt_ingerida");
    	    	java.sql.Date data = rs.getDate("dt_ingerido");
    	    	
    	    	Calendar tempo = Calendar.getInstance();
    	        tempo.setTimeInMillis(data.getTime());
    	        
    	        alimento = new Alimento(codigo,codigo_user,tipo,caloria,quantidade,tempo);
			}
			
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
		return alimento;
	}

	@Override
	public List<Alimento> listar() {
		List<Alimento> lista = new ArrayList<Alimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ALIMENTO");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("cd_alimento");
    	    	int codigo_user = rs.getInt("t_htk_user_cd_usuario");
    	    	String tipo = rs.getString("ds_tipo");
    	    	double caloria = rs.getDouble("qt_caloria");
    	    	int quantidade = rs.getInt("qt_ingerida");
    	    	java.sql.Date data = rs.getDate("dt_ingerido");
    	    	
    	    	Calendar tempo = Calendar.getInstance();
    	        tempo.setTimeInMillis(data.getTime());
    	        
    	        Alimento alimentoo = new Alimento(codigo,codigo_user,tipo,caloria,quantidade,tempo);
    	        lista.add(alimentoo);
		        
			}
			
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
		return lista;
	}

	
}
