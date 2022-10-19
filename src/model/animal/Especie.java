package model.animal;

import java.util.List;

import model.medicine.TipoMedicamento;
import model.vaccine.TipoVacina;

public class Especie {
    private String nome;

    private List<TipoMedicamento> lstMedicamentos;
    private List<TipoVacina> lstVacinas;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TipoMedicamento> getMedicamentos() {
        return lstMedicamentos;
    }
    public void setMedicamentos(List<TipoMedicamento> lstMedicamentos) {
        this.lstMedicamentos = lstMedicamentos;
    }

    public List<TipoVacina> getVacinas() {
        return lstVacinas;
    }
    public void setVacinas(List<TipoVacina> lstVacinas) {
        this.lstVacinas = lstVacinas;
    }
}
