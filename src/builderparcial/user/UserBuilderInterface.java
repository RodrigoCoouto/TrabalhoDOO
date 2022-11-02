package builderparcial.user;

public interface UserBuilderInterface{
    void setNome(String nome);
    void setCPF(int cpf);
    void setSenha(String senha);
    boolean cpfJaCadastrado(int cpf);
}