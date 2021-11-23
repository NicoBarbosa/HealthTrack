package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import healthtrack.bean.Usuario;
import healthtrack.connection.bd.ConnectionManager;
import healthtrack.dao.UsuarioDAO;
import healthtrack.exception.DBException;

public class OracleUsuarioDAO implements UsuarioDAO {
	private Connection conexao;

	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection(); 
			String sql = "INSERT INTO T_HTK_USER (CD_USUARIO, NM_USUARIO, DS_EMAIL, DS_SENHA, DT_NASCIMENTO, DS_SEXO, VL_ALTURA, DT_INCLUSAO) VALUES (SQ_USER.NEXTVAL, ?,?,?,?,?,?,?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			java.sql.Date dtNascimento = new java.sql.Date(usuario.getDtNascimento().getTimeInMillis());
			stmt.setDate(4, dtNascimento);
			stmt.setString(5, usuario.getSexo());
			stmt.setDouble(6, usuario.getAltura());
			java.sql.Date data = new java.sql.Date(usuario.getDtInclusao().getTimeInMillis());
			stmt.setDate(7, data);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar");
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
	public void atualizar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "UPDATE INTO T_HTK_USER SET NM_USUARIO = ?, DS_EMAIL = ?, DS_SENHA = ?, DT_NASCIMENTO = ?, DS_SEXO = ?, VL_ALTURA = ?, DT_INCLUSAO = ? WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			java.sql.Date dtNascimento = new java.sql.Date(usuario.getDtNascimento().getTimeInMillis());
			stmt.setDate(4, dtNascimento);
			stmt.setString(5, usuario.getSexo());
			stmt.setDouble(6, usuario.getAltura());
			java.sql.Date data = new java.sql.Date(usuario.getDtInclusao().getTimeInMillis());
			stmt.setDate(7, data);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o usuário");
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
	public void remover(int cd_usuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "DELETE FROM T_HTK_USER WHERE CD_USUARIO = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_usuario);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover o usuário");
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
	public Usuario buscar(int cd_usuario) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "SELECT * FROM T_HTK_USER WHERE CD_USUARIO = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_usuario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigo = rs.getInt("CD_USUARIO");
		        String nome = rs.getString("NM_USUARIO");
		        String email = rs.getString("DS_EMAIL");
		        String senha = rs.getString("DS_SENHA"); 
		        java.sql.Date dtNasc = rs.getDate("DT_NASCIMENTO");
		        Calendar dtNascimento = Calendar.getInstance();
		        dtNascimento.setTimeInMillis(dtNasc.getTime());
		        String sexo = rs.getString("DS_SEXO");
		        double altura = rs.getDouble("VL_ALTURA");
		        java.sql.Date dtInclu = rs.getDate("DT_INCLUSAO");
		        Calendar dtInclusao = Calendar.getInstance();
		        dtInclusao.setTimeInMillis(dtInclu.getTime());
		        
		        
		        usuario = new Usuario(codigo, nome, email, senha, dtNascimento, sexo, altura, dtInclusao);
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
	
	@Override
	public Usuario buscarPorEmail(String busca_email) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "SELECT * FROM T_HTK_USER WHERE DS_EMAIL = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, busca_email);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigo = rs.getInt("CD_USUARIO");
		        String nome = rs.getString("NM_USUARIO");
		        String email = rs.getString("DS_EMAIL");
		        String senha = rs.getString("DS_SENHA"); 
		        java.sql.Date dtNasc = rs.getDate("DT_NASCIMENTO");
		        Calendar dtNascimento = Calendar.getInstance();
		        dtNascimento.setTimeInMillis(dtNasc.getTime());
		        String sexo = rs.getString("DS_SEXO");
		        double altura = rs.getDouble("VL_ALTURA");
		        java.sql.Date dtInclu = rs.getDate("DT_INCLUSAO");
		        Calendar dtInclusao = Calendar.getInstance();
		        dtInclusao.setTimeInMillis(dtInclu.getTime());
		        
		        
		        usuario = new Usuario(codigo, nome, email, senha, dtNascimento, sexo, altura, dtInclusao);
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

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_USER");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codigo = rs.getInt("CD_USUARIO");
		        String nome = rs.getString("NM_USUARIO");
		        String email = rs.getString("DS_EMAIL");
		        String senha = rs.getString("DS_SENHA"); 
		        java.sql.Date dtNasc = rs.getDate("DT_NASCIMENTO");
		        Calendar dtNascimento = Calendar.getInstance();
		        dtNascimento.setTimeInMillis(dtNasc.getTime());
		        String sexo = rs.getString("DS_SEXO");
		        double altura = rs.getDouble("VL_ALTURA");
		        java.sql.Date dtInclu = rs.getDate("DT_INCLUSAO");
		        Calendar dtInclusao = Calendar.getInstance();
		        dtInclusao.setTimeInMillis(dtInclu.getTime());
		        
		        Usuario usuario = new Usuario(codigo, nome, email, senha, dtNascimento, sexo, altura, dtInclusao);
		        lista.add(usuario);
		        
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
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HTK_USER DS_EMAIL = ? AND DS_SENHA = ?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			/*rs = stmt.executeQuery();
			
			while (rs.next()) {
				return true;
			}*/
			
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
		return false;
	}

}
