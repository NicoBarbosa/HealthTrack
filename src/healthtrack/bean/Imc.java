package healthtrack.bean;

import java.util.Calendar;

public class Imc extends BaseFuncoes{
	
	/** 
	 * Armazena o IMC que o usuário declarou
	 * */
	
	private int codPeso;
	private Calendar tempo;
	
	public Imc() {}
	
	public Imc(int codigo_usuario, int codigo_peso, Calendar data) {
		this.setCodigo(codigo_usuario);
		this.setCodPeso(codigo_peso);
		this.setTempo(data);
	}
	
	public int getCodPeso() {
		return codPeso;
	}

	public void setCodPeso(int codPeso) {
		this.codPeso = codPeso;
	}

	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	
	public Calendar getTempo() {
		return tempo;
	}
	
	public Calendar getDateOfToday() {
		return super.getData();
	}

}


