package medicine;

import java.sql.Date;

public class Medicamento {

    private Date data;
    private String lote;
    private float dose;
    private int qntDose;
    private String motivo;
    private boolean reacaoAlergica;
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public float getDose() {
        return dose;
    }
    public void setDose(float dose) {
        this.dose = dose;
    }
    public int getQntDose() {
        return qntDose;
    }
    public void setQntDose(int qntDose) {
        this.qntDose = qntDose;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public boolean isReacaoAlergica() {
        return reacaoAlergica;
    }
    public void setReacaoAlergica(boolean reacaoAlergica) {
        this.reacaoAlergica = reacaoAlergica;
    }
    
}
