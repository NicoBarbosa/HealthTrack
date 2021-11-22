package healthtrack.bean;

import java.util.Calendar;

public class Usuario extends BaseFuncoes{
	
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
        String nome,
        String email,
        String senha, 
        Calendar dtNascimento,
        String sexo,
        double altura,
        Calendar dtInclusao
    ) {
    	super();
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setDtNascimento(dtNascimento);
        this.setSexo(sexo);
        this.setAltura(altura);
        this.setDtInclusao(dtInclusao);
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
        	super();
        	this.setCodigo(cd_usuario);
        	 this.setNome(nome);
             this.setEmail(email);
             this.setSenha(senha);
             this.setDtNascimento(dtNascimento);
             this.setSexo(sexo);
             this.setAltura(altura);
             this.setDtInclusao(dtInclusao);
        }
    
    public Usuario(String email2, String senha2) {
    	this.setEmail(email2);
    	this.setSenha(senha2);
	}

	public void setCodigo(int cd_usuario) {
		super.setCodigo(cd_usuario);
	}
	public int getCodigo() {
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