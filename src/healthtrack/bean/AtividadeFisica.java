package healthtrack.bean;

import java.util.Calendar;

/** 
 * Classe para registrar uma Atividade F�sica realizada pelo usu�rio
 * @author Nicolas Barbosa Penante
 * @version 1.0
 * */
public class AtividadeFisica extends BaseFuncoes{
	
	/** 
	 * Declara qual Atividade foi realizada!
	 * */
	private String tipoAtividade;
	
	/** 
	 * Declara a quantidade de tempo que a atividade foi realizada!
	 * */
	private Calendar tempo;
	
	/** 
	 * Quantidade de calorias que foram perdidas!
	 * */
	private int calorias;
	
	/** 
	 * M�todo construtor vazio! 
	 * */
	public AtividadeFisica() {}
 
	public AtividadeFisica(String tipoAtividade, Calendar tempo, int calorias) {
		this.setTipoAtividade(tipoAtividade);
		this.setTempo(tempo);
		this.setCalorias(calorias);
	}
	
	public AtividadeFisica(int codigoAf, String tipoAtividade, Calendar tempo, int calorias) {
		this.setCodigo(codigoAf);
		this.setTipoAtividade(tipoAtividade);
		this.setTempo(tempo);
		this.setCalorias(calorias);
	}
	
	/**
	 * M�todo Get C�digo
	 * @return o c�digo do alimento
	 */
	public int getCodigo() {
		return super.getCodigo();
	}

	/**
	 * M�todo Set C�digo
	 * @param codigo setado
	 */
	public void setCodigo(int codigo) {
		super.setCodigo(codigo);
	}
	
	/** 
	 * Declara o tipo da Atividade
	 * @param Tipo da atividade
	 * */
	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	/** 
	 * Retorna o tipo da atividade
	 * */
	public String getTipoAtividade() {
		return tipoAtividade;
	}
	
	/** 
	 * Declara o tempo que o usu�rio ficou fazendo a atividade
	 * @param Tempo da atividade
	 * */
	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	
	/** 
	 * Retorna o tempo
	 * */
	public Calendar getTempo() {
		return tempo;
	}
	
	/** 
	 * Declara as calorias que foram perdidas
	 * @param calorias perdidas
	 * */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	/** 
	 * Retorna as calorias perdidas
	 * */
	public int getCalorias() {
		return calorias;
	}
	
	/** 
	 * Retorna a data atual do sistema!
	 * */
	public Calendar getDateOfToday() {
		return super.getData();
	}

}
