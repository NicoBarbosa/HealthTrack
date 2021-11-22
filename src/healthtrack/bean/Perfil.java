package healthtrack.bean;

import java.util.Calendar;

public class Perfil extends BaseFuncoes{
	
    private String nome;
    private String email;
    private Calendar dtNascimento;
    private String sexo;
    private double altura;
    private Calendar dtInclusao;
    private String senha;
    private double peso;

   	private String tipoAtividade;
    private Calendar tempo;
    private int calorias;

    public Perfil() { 
    	super(); 
	}

    public Perfil(
        String nome,
        String email,
        String senha, 
        Calendar dtNascimento,
        String sexo,
        double altura,
        Calendar dtInclusao,
        double peso,
        String tipoAtividade,
        Calendar tempo,
        int calorias
    ) {
    	super();
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setDtNascimento(dtNascimento);
        this.setSexo(sexo);
        this.setAltura(altura);
        this.setDtInclusao(dtInclusao);
        this.setPeso(peso);
        this.setTipoAtividade(tipoAtividade);
		this.setTempo(tempo);
		this.setCalorias(calorias);
    }
    
    
    public void setCdUsuario(int cd_usuario) {
		super.setCodigo(cd_usuario);
	}
	public int getCdUsuario() {
		return super.getCodigo();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha (String senha) {
    	this.senha = senha;
    }
    public String getSenha () {
    	return senha;
    }
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Calendar getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Calendar dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPeso() {
		return peso;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	public String getTipoAtividade() {
		return tipoAtividade;
	}
	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	public Calendar getTempo() {
		return tempo;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public int getCalorias() {
		return calorias;
	}    
}