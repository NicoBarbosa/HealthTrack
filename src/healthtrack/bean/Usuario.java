package healthtrack.bean;

import java.util.Calendar;

public class Usuario {
    private int cd_usuario;
    private String nome;
    private String email;
    private String senha; 
    private Calendar dtNascimento;
    private String sexo;
    private double altura;
    private Calendar dtInclusao;

    public Usuario() { 
    	super(); 
	}

    public Usuario(
        int cd_usuario,
        String nome,
        String email,
        String senha, 
        Calendar dtNascimento,
        String sexo,
        double altura,
        Calendar dtInclusao
    ) {
        this.cd_usuario = cd_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.altura = altura;
        this.dtInclusao = dtInclusao;
    }

	public int getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

    
}