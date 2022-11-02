package menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.animal.Alimentacao;
import model.animal.Animal;
import model.animal.Especie;
import model.animal.Raca;


public class AnimalMenu {
    private static List<Animal> animais = new ArrayList<Animal>();
    private static List<Especie> especies = new ArrayList<Especie>();
    private static List<Raca> racas = new ArrayList<Raca>();


    public static void cadastroAnimal() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        int opcao = 0;
        int aux;

        String nome;
        float idade;
        float peso;
        float altura;
        Boolean racaJaExiste;
        int i=0;
        int j=0;
        boolean especieInexistente;
        String nomeEspecie;
        String nomeRaca;
        Boolean especieJaExiste;
        Especie especie;
        Raca raca;
        boolean animalJaExiste;

        while (opcao!=6) {
            clear();
            System.out.print(" ##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Animal                     |\n");
            System.out.print("| Opção 2 - Deletar Animal                       |\n");
            System.out.print("| Opção 3 - Listar Animal                        |\n");
            System.out.print("| Opção 4 - Editar Animal                        |\n");
            System.out.print("| Opção 5 - Adicionar Raça/Especie               |\n");
            System.out.print("| Opção 6 - Voltar ao Menu Principal             |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();
            menu.nextLine();

            switch (opcao) {
            case 1:
                clear();
                //selecionar especie
                especieInexistente=false;
                if (especies.size()==0){
                    System.out.println("Não existem especies cadastradas, cadastre uma primeiro.");
                    System.out.println("\nPressione Enter para continuar.");
                    menu.nextLine();
                    especieInexistente=true;
                }
                if (especieInexistente) break;
                
                i=0;
                j=0;
                for (Especie e : especies){ 
                    System.out.println("Codigo: "+i+" Nome: "+e.getNome());
                    i++;
                }
                System.out.println("\nSelecione a especie desejada para cadastrar o animal: ");
                j= menu.nextInt();menu.nextLine();
                while (i<0 || j>i){
                    System.out.println("Informe um valor válido. ");
                    System.out.println("Selecione a especie desejada para cadastrar o animal: ");
                    j= menu.nextInt();menu.nextLine();
                }
                clear();
                System.out.println("Especie: "+especies.get(j).getNome());
                especie = especies.get(j);
                //buscar racas possiveis por especies
                especieInexistente=false;
                if (racas.size()==0){
                    System.out.println("Não existem racas cadastradas, cadastre uma primeiro.");
                    System.out.println("\nPressione Enter para continuar.");
                    menu.nextLine();
                    especieInexistente=true;
                }
                if (especieInexistente) break;

                //selecionar racas
                i=0;
                j=0;
                for (Raca r : racas){ 
                    if(r.getEspecie().equals(especie)){
                        System.out.println("\nCodigo: "+i+" Nome: "+r.getNome());
                    }
                    i++;
                }
                System.out.println("\nSelecione a raca desejada para cadastrar o animal: ");
                j= menu.nextInt();menu.nextLine();
                while (i<0 || j>i){
                    System.out.println("Informe um valor válido. ");
                    System.out.println("Selecione a raca desejada para cadastrar o animal: ");
                    j= menu.nextInt();menu.nextLine();
                }
                System.out.println("Racas: "+racas.get(j).getNome());
                raca = racas.get(j);
                clear();


                System.out.println("Especie: "+especie.getNome());
                System.out.println("Raca: "+raca.getNome());

                 System.out.print("Digite o nome do animal: ");
                nome = menu.nextLine();

                animalJaExiste = false;
                for (Animal a : animais){
                    if (a.getNome() == nome){ 
                        System.out.println("Animal ja existente com o nome: "+ a.getNome()+ ". Favor cadastre o animal com outro nome.");
                        animalJaExiste = true;
                        break;
                    }
                }
                if (animalJaExiste) break;

                System.out.print("Digite a idade do animal: ");
                idade = menu.nextFloat();
                System.out.print("Digite o peso do animal: ");
                peso = menu.nextFloat();
                System.out.print("Digite a altura do animal: ");
                altura = menu.nextFloat();menu.nextLine();
            
                animais.add(new Animal(raca,nome, idade, peso, altura, false));
                    
                System.out.println("Novo Animal cadastrado.");
                
                
                System.out.println("\nPressione Enter para continuar.");
                menu.nextLine();
                break;

            case 2:
                System.out.print("Digite o nome do animal que deseja deletar: ");
                nome = menu.nextLine();

                for (Animal a : animais){
                    System.out.println(""+ a.getNome()+"    "+nome);
                    if (a.getNome().equals(nome)){ 
                        System.out.println("Animal removido: "+ a.getNome());
                        animais.remove(a);
                        break;
                    }
                }
                System.out.println("\nPressione Enter para continuar.");
                menu.nextLine();
                break;

                

            case 3:
                for (Animal a : animais){
                    System.out.print("Nome: "); System.out.println(a.getNome());
                    
                }
                System.out.println("---------------------------------");
                System.out.println("\nPressione Enter para continuar.");
                menu.nextLine();
                break;

            case 4:
            System.out.print("Digite o nome do animal que deseja editar: ");
                nome = menu.nextLine();

                for (Animal a : animais){
                    if (a.getNome().equals(nome)){ 
                        System.out.println("Digite o novo nome para: "+ a.getNome());
                        nome = menu.nextLine();
                        a.setNome(nome);
                        System.out.println("Digite o nova idade: ");
                        idade = menu.nextFloat();
                        a.setIdade(idade);
                        System.out.println("Digite o nova altura: ");
                        altura = menu.nextFloat();menu.nextLine();
                        a.setAltura(altura);
                        break;
                    }
                }
                
                System.out.println("\nPressione Enter para continuar.");
                menu.nextLine();
                break;

            case 5:
                //CADASTRAR ESPECIE OU RACA?
                clear();
                System.out.println("Deseja cadastrar especie ou raca: ");
                System.out.println("1 - Especie");
                System.out.println("2 - Raca\n");
                
                aux = menu.nextInt();
                menu.nextLine();
                while (aux!=1 && aux!=2) {
                    clear();
                    System.out.println("Informe um valor existente.");
                    System.out.println("Deseja cadastrar especie ou raca: ");
                    System.out.println("1 - Especie");
                    System.out.println("2 - Raca\n");
                    aux = menu.nextInt();
                    menu.nextLine();
                }
                if (aux==1){ //CADASTRAR ESPECIE
                    clear();
                    System.out.println("Informe o nome da especie que deseja cadastar (Ex: Cachorro): ");
                    nomeEspecie = menu.nextLine();
                    //VERIFICAR SE JA EXISTE ESPECIE
                    especieJaExiste = false;
                    for (Especie e : especies){
                        if (e.getNome().equals(nomeEspecie)){
                            System.out.println("Especie ja existente com o nome: "+ nomeEspecie+ ". Favor cadastre a especie com outro nome.");
                            especieJaExiste = true;
                            System.out.println("\nPressione Enter para continuar.");
                            menu.nextLine();
                            break;
                        }
                    }
                    if (especieJaExiste) break;
                    especies.add(new Especie(nomeEspecie));
                    System.out.println("\nEspecie cadastrada com sucesso!");
                }

                else if (aux==2){ //CADASTRAR RACA
                    //ESCOLHE ESPECIE
                    especieInexistente=false;
                    if (especies.size()==0){
                        System.out.println("Não existem especies cadastradas, cadastre uma primeiro.");
                        System.out.println("\nPressione Enter para continuar.");
                        menu.nextLine();
                        especieInexistente=true;
                    }
                    if (especieInexistente) break;
                    clear();
                    i=0;
                    j=0;
                    for (Especie e : especies){ 
                        System.out.println("Codigo: "+i+" Nome: "+e.getNome());
                        i++;
                    }
                    System.out.println("\nSelecione a especie desejada para cadastrar a raca: ");
                    j= menu.nextInt();menu.nextLine();
                    while (i<0 || j>i){
                        System.out.println("Informe um valor válido. ");
                        System.out.println("Selecione a especie desejada para cadastrar a raca: ");
                        j= menu.nextInt();menu.nextLine();
                    }
                    clear();
                    System.out.println("Especie: "+especies.get(j).getNome());

                    System.out.println("Informe o nome da raca: ");
                    nomeRaca=menu.nextLine();
                    //INFORMA NOME RACA E VERIFICA EXISTENCIA
                    racaJaExiste=false;
                    for (Raca r : racas){
                        if (r.getNome().equals(nomeRaca)){
                            System.out.println("Raca ja existente com o nome: "+ nomeRaca+ ". Favor cadastre a Raca com outro nome.");
                            racaJaExiste = true;
                            System.out.println("\nPressione Enter para continuar.");
                            menu.nextLine();
                            break;
                        }
                    }
                    if (racaJaExiste) break;
                    // CRIA RACA COM A ESPECIE
                    racas.add(new Raca(nomeRaca, especies.get(j)));
                }
               
                

               
                
                System.out.println("\nPressione Enter para continuar.");
                menu.nextLine();
                break;
            case 6:
                return;
                
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
        }
    }
    public static void clear() throws InterruptedException, IOException{
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{
            Runtime.getRuntime().exec("clear");
        }
    }
}







