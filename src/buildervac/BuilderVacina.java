package buildervac;

import model.animal.*;
import model.vaccine.*;
import java.util.List;
import java.util.Scanner;


public class BuilderVacina {
    private Animal animal;
    private TipoVacina tipoVacina;
    private Vacina vacina;
    private String lote;
    private String nomeResponsavel;
    private String data;
    private String reaplicacao;


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
        Scanner scan = new Scanner (System.in);
        System.out.println("Digite o lote da vacina:");
        lote = scan.next();scan.nextLine();
        vacina.setLote(lote);
        scan.close();
        

    }
    //nomeResponsavel
    public void adicionarResponsavel(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Digite o nome do responsavel:");
        nomeResponsavel = scan.next();scan.nextLine();
        vacina.setNomeResponsavel(nomeResponsavel);
        scan.close();

    }
    //data 
    public void adicionarData(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Digite o nome do responsavel:");
        data = scan.next();scan.nextLine();
        vacina.setData(data);
        scan.close();

    }
    //reaplicacao
    public void adicionarReaplicacao(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Digite o nome do responsavel:");
        reaplicacao = scan.next();scan.nextLine();
        vacina.setReaplicacao(reaplicacao);
        scan.close();

    }


}
