package healthtrack.bean;

import java.util.Calendar;

public class Usuario {
    private int cd_usuario;
    private String nome;
    private String email;
    private String senha; 
    private Calendar dtNascimento;
    private char sexo;
    private double altura;
    private Calendar dtInclusao;

    public Usuario() { super(); }

    public Usuario(
        int cd_usuario,
        String nome,
        String email,
        String senha, 
        Calendar dtNascimento,
        char sexo,
        double altura,
        Calendar dtInclusao,
    ) {
        this.cd_usuario = cd_usuario;
        this.nome = nome;
        this.email = email;
        this.senha, = senha;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
        this.altura = altura;
        this.dtInclusao = dtInclusao;
    }

    
}