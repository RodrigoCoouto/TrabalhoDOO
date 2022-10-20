package model.user;
public class Usuario {
    private int cpf;
    private String senha;
    private String nome;
    
    public Usuario(int cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
