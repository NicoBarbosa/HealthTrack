package healthtrack.bean;

import java.util.Calendar;

public class Alimento extends BaseFuncoes {
	private int chave_user;
	private String alimento;
	private double qt_caloria;
	private int qt_ingerida;
	
	public Alimento() {}
	public Alimento(int codigo_user, String tipo, double caloria, int quantidade, Calendar data) {
		this.setChaveUser(codigo_user);
		this.setAlimento(tipo);
		this.setCaloria(caloria);
		this.setQuantidade(quantidade);
		this.setData(data);
	}

	public Alimento(int codigo, int codigo_user, String tipo, double caloria, int quantidade, Calendar data) {
		this.setCodigo(codigo);
		this.setChaveUser(codigo_user);
		this.setAlimento(tipo);
		this.setCaloria(caloria);
		this.setQuantidade(quantidade);
		this.setData(data);
	}

	public void setChaveUser(int chave_user) {
		this.chave_user = chave_user;
	}
	public int getChaveUser() {
		return chave_user;
	}
	
	public void setAlimento( String alimento) {
		this.alimento = alimento;
	}
	public String getAlimento() {
		return alimento;
	}
	
	public void setCaloria(double qt_caloria) {
		this.qt_caloria = qt_caloria;
	}
	public double getCaloria() {
		return qt_caloria;
	}
	
	public void setQuantidade(int qt_ingerida) {
		this.qt_ingerida = qt_ingerida;
	}
	public int getQuantidade() {
		return qt_ingerida;
	}
	
	public void setCodigo(int codigoA) {
		super.setCodigo(codigoA);
	}
	public int getCodigo() {
		return super.getCodigo();
	}
	
	public void setData(Calendar data) {
		super.setData(data);
	}
	public Calendar getData() {
		return super.getData();
	}
	
}
