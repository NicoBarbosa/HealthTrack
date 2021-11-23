package healthtrack.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import healthtrack.bean.AtividadeFisica;
import healthtrack.connection.bd.ConnectionManager;
import healthtrack.dao.AtvFisicaDAO;
import healthtrack.exception.DBException;

public class OracleAtvFisicaDAO implements AtvFisicaDAO {

	private Connection conexao;
	
	public List<AtividadeFisica> getAll() {
		
		List<AtividadeFisica> listar = new ArrayList<AtividadeFisica>();
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	conexao = ConnectionManager.getConnection();
    	    stmt = conexao.prepareStatement("SELECT * FROM T_HTK_ATIV_FIS");
    	    rs = stmt.executeQuery();
    	    
    	    while (rs.next()) {
        	    String tipoAtv = rs.getString("DS_TIPO_ATIVIDADE");
        	    java.sql.Date data = rs.getDate("DS_TEMPO_DATA");
    	        int vlCalorias = rs.getInt("VL_CALORIAS");
    	        
    	        Calendar tempo = Calendar.getInstance();
    	        tempo.setTimeInMillis(data.getTime());
    	        
    	        AtividadeFisica atividadeFisica = new AtividadeFisica(tipoAtv, tempo, vlCalorias);
    	        
    	        listar.add(atividadeFisica);
    	    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
  	      try {
  	        stmt.close();
  	        rs.close();
  	        conexao.close();
  	      } catch (SQLException e) {
  	        e.printStackTrace();
  	      }
  	    }
		
		
		return listar;
	}
	
	//CADASTRAR
	public void cadastrar(AtividadeFisica atvFis) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getConnection();
			String sql = "INSERT INTO T_HTK_ATIV_FIS(CD_ATIVIDADE, T_HTK_USER_CD_USUARIO, DS_TIPO_ATIVIDADE, DS_TEMPO_DATA, VL_CALORIAS) VALUES (SQ_ATV_FIS.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, 1); //Dar atenção a essa linha
            stmt.setString(2, atvFis.getTipoAtividade());
            java.sql.Date data = new java.sql.Date(atvFis.getTempo().getTimeInMillis());
            stmt.setDate(3, data);
            stmt.setDouble(4, atvFis.getCalorias());
    
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
	
}
