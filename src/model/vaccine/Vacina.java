package model.vaccine;

import java.sql.Date;

public class Vacina {

    private String lote;
    private String nomeResponsavel;
    private Date data;
    private Date reaplicacao;
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Date getReaplicacao() {
        return reaplicacao;
    }
    public void setReaplicacao(Date reaplicacao) {
        this.reaplicacao = reaplicacao;
    }
    
}
