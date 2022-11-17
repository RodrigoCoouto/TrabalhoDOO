package buildervac;

import model.animal.*;
import model.vaccine.*;
import java.util.List;
import java.sql.Date;


public class BuilderVacina {
    private Animal animal;
    private TipoVacina tipoVacina;
    private Vacina vacina;


    private String lote;
    private String nomeResponsavel;
   
    // private Date data;
    // private Date reaplicacao;


    public BuilderVacina(Animal animal, TipoVacina tipoVacina,Vacina vacina){
        this.animal = animal;
        this.tipoVacina = tipoVacina;
        this.vacina= vacina;
    }

    //metodos


    //verifica especie X vacina
    public void verificaVacinaEspecie()throws Exception{
        Raca raca;
        raca=animal.getRaca();
        Especie especie = raca.getEspecie();
        List<TipoVacina> listaVacinas= especie.getVacinas();
        if (listaVacinas.contains(tipoVacina)){
            
        }
        else{
            throw new Exception("Esta vacina não pode ser aplicada para esta especie");
        }


    }

    //lote
    public void adicionarLote(){
        


    }
    //nomeResponsavel
    public void adicionarResponsavel(){
            
    }
    //data 

    //reaplicacao



}
