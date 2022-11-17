package buildervac;
import model.vaccine.*;
import model.animal.*;

public class DiretorVacina {

    public DiretorVacina(){

    }





    public Vacina builder(Animal animal, TipoVacina tipoVacina) throws Exception{

        Vacina vacina = new Vacina();
        BuilderVacina builderVacina = new BuilderVacina(animal,tipoVacina,vacina);
        //verifica se pode aplicar a vacina
        builderVacina.verificaVacinaEspecie();
        //adiciona o lote na vacina
        builderVacina.adicionarLote();
        //adiciona o responsavel na vacina
        builderVacina.adicionarResponsavel();

        return vacina;
    }
}
