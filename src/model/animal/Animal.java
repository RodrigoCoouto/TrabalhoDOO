package model.animal;
public class Animal {

    private String nome;
    private float idade;
    private float peso;
    private float altura;
    private boolean adotado;

    private Raca raca;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getIdade() {
        return idade;
    }
    public void setIdade(float idade) {
        this.idade = idade;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public boolean isAdotado() {
        return adotado;
    }
    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public Raca getRaca(){
        return raca;
    }
    public void setRaca(Raca r){
        this.raca = r;
    }
}
