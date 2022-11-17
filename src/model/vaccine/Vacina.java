package model.vaccine;

import java.sql.Date;

public class Vacina {

    private String lote;
    private String nomeResponsavel;
    private String data;
    private String reaplicacao;
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
    public String getReaplicacao() {
        return reaplicacao;
    }
    public void setReaplicacao(String reaplicacao) {
        this.reaplicacao = reaplicacao;
    }
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    
    
}
