package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import healthtrack.bean.Perfil;
import healthtrack.connection.bd.ConnectionManager;
import healthtrack.dao.PerfilDAO;
import healthtrack.exception.DBException;

public class OraclePerfilDAO implements PerfilDAO {
    private Connection conexao;

	@Override
	public void atualizar(Perfil perfil) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "BEGIN TRANSACTION UPDATE INTO T_HTK_USER SET NM_USUARIO = ?, DS_EMAIL = ?, DT_NASCIMENTO = ?, DS_SEXO = ?, VL_ALTURA = ?, DT_INCLUSAO = ? WHERE CD_USUARIO = ? UPDATE INTO T_HTK_PESO SET VL_PESO = ? WHERE T_HTK_USER = ? UPDATE INTO T_HTK_ATIV_FIS SET DS_TIPO_ATIVIDADE = ?, DS_TEMPO_DATA = ? VL_CALORIAS = ? WHERE T_HTK_USER = ? COMMIT";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, perfil.getNome());
			stmt.setString(2, perfil.getEmail());
			java.sql.Date dtNascimento = new java.sql.Date(perfil.getDtNascimento().getTimeInMillis());
			stmt.setDate(3, dtNascimento);
			stmt.setString(4, perfil.getSexo());
			stmt.setDouble(5, perfil.getAltura());
			java.sql.Date dataInclusao = new java.sql.Date(perfil.getDtInclusao().getTimeInMillis());
			stmt.setDate(6, perfil.getDtInclusao());
		    stmt.setDouble peso = (7, perfil.getPeso());
		    stmt.setString tipoAtividade = (8, perfil.getTipoAtividade()); 
		    stmt.setDouble calorias = (9, perfil.getCalorias());
			java.sql.Date tempo = new java.sql.Date(perfil.getTempo().getTimeInMillis());
			stmt.setDate(10, tempo);

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o perfil do usuário");
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
	public Perfil buscar(int cd_usuario) {
		Perfil perfil = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "SELECT * FROM T_HTK_USER WHERE CD_USUARIO = ? INNER JOIN T_HTK_PESO WHERE T_HTK_USER = ?INNER JOIN T_HTK_ATIV_FIS WHERE T_HTK_USER = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_usuario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
		        String nome = rs.getString("NM_USUARIO");
		        String senha = rs.getString("CD_SENHA");
		        String email = rs.getString("DS_EMAIL");
		        java.sql.Date dtNasc = rs.getDate("DT_NASCIMENTO");
		        Calendar dtNascimento = Calendar.getInstance();
		        dtNascimento.setTimeInMillis(dtNasc.getTime());
		        String sexo = rs.getString("DS_SEXO");
		        double altura = rs.getDouble("VL_ALTURA");
		        java.sql.Date dtInclu = rs.getDate("DT_INCLUSAO");
		        Calendar dtInclusao = Calendar.getInstance();
		        dtInclusao.setTimeInMillis(dtInclu.getTime());
				int codigo = rs.getInt("CD_PESO");
		        double peso = rs.getDouble("VL_PESO");
				int codigoAf = rs.getInt("CD_ATIVIDADE");
		        String tipoAtividade = rs.getString("DS_TIPO_ATIVIDADE"); 
		        int calorias = rs.getInt("VL_CALORIAS");
		        java.sql.Date tmp = rs.getDate("DS_TEMPO_DATA");
		        Calendar tempo = Calendar.getInstance();
		        tempo.setTimeInMillis(tmp.getTime());
		        
		        perfil = new Perfil(nome,senha,email, dtNascimento,sexo,altura,dtInclusao,peso,tipoAtividade,tempo,calorias);
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
		return usuario;
	}

}
