package model.animal;

import java.util.List;

import model.Alimentacao;

public class Raca {
    private String nome;

    private Especie especie;
    private List<Alimentacao> lstAlimentacao;

    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(Especie e) {
        this.especie = e;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Alimentacao> getAlimentos(){
        return lstAlimentacao;
    }
    public void setAlimentacao (List<Alimentacao> lstAlimentacao){
        this.lstAlimentacao = lstAlimentacao;
    }
}
