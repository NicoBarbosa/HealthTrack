package healthtrack.bean;

import java.util.Calendar;

public class Peso extends BaseFuncoes{
	
	/** 
	 * Armazena o peso que o usuário declarou
	 * */
	private double peso;
	private int fk;
	private Calendar tempo;
	
	public Peso() {}
	
	public Peso(int codigo, double peso, Calendar data) {
		this.setCodigo(codigo);
		this.setPeso(peso);
		this.setTempo(data);
	}
	
	public Peso(int codigo, int fk, double peso, Calendar data) {
		this.setCodigo(codigo);
		this.setFk(fk);
		this.setPeso(peso);
		this.setTempo(data);
	}
	
	public void setFk(int fk) {
		this.fk = fk;
	}
	
	public int getFk() {
		return fk;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return peso;
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

