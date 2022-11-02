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
                System.out.print("Digite o nome do animal: ");
                nome = menu.nextLine();

                boolean animalJaExiste = false;
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
                altura = menu.nextFloat();
            
                animais.add(new Animal(nome, idade, peso, altura, false));
                    
                System.out.println("Novo Animal cadastrado.");
                
                
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 2:
                System.out.print("Digite o nome do animal que deseja deletar: ");
                nome = menu.nextLine();

                for (Animal a : animais){
                    if (a.getNome() == nome){ 
                        System.out.println("Animal removido: "+ a.getNome());
                        animais.remove(a);
                        break;
                    }
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

                

            case 3:
                for (Animal a : animais){
                    System.out.print("Nome: "); System.out.println(a.getNome());
                    System.out.print("---------------------------------: ");
                    
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 4:
            System.out.print("Digite o nome do animal que deseja editar: ");
                nome = menu.nextLine();

                for (Animal a : animais){
                    if (a.getNome() == nome){ 
                        System.out.println("Digite o novo nome para: "+ a.getNome());
                        nome = menu.nextLine();
                        a.setNome(nome);
                        System.out.println("Digite o nova idade: ");
                        idade = menu.nextFloat();
                        a.setIdade(idade);
                        System.out.println("Digite o nova altura: ");
                        altura = menu.nextFloat();
                        a.setAltura(altura);
                        break;
                    }
                }
                
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 5:
                //CADASTRAR ESPECIE OU RACA?
                System.out.println("Deseja cadastrar especie ou raca: ");
                System.out.println("1 - Especie");
                System.out.println("2 - Raca");
                
                aux = menu.nextInt();
                menu.nextLine();
                while (aux!=1 && aux!=2) {
                    clear();
                    System.out.println("Informe um valor existente.");
                    System.out.println("Deseja cadastrar especie ou raca: ");
                    System.out.println("1 - Especie");
                    System.out.println("2 - Raca");
                    aux = menu.nextInt();
                    menu.nextLine();
                }
                if (aux==1){ //CADASTRAR ESPECIE
                    System.out.println("Informe o nome da especie que deseja cadastar (Ex: Cachorro): ");
                    String nomeEspecie = menu.nextLine();
                    //VERIFICAR SE JA EXISTE ESPECIE
                    Boolean especieJaExiste = false;
                    for (Especie e : especies){
                        if (e.getNome() == nomeEspecie){
                            System.out.println("Especie ja existente com o nome: "+ nomeEspecie+ ". Favor cadastre a especie com outro nome.");
                            especieJaExiste = true;
                            break;
                        }
                    }
                    if (especieJaExiste) break;
                    especies.add(new Especie(nomeEspecie));
                    System.out.println("Especie cadastrada com sucesso!");
                }

                else if (aux==2){ //CADASTRAR RACA
                    //ESCOLHE ESPECIE
                    int i=0;
                    int j=0;
                    for (Especie e : especies){ 
                        System.out.println("Codigo: "+i+" Nome: "+e.getNome());

                    }
                    System.out.println("");
                    System.out.println("Selecione a especie desejada para cadastrar a raca: ");
                    j= menu.nextInt();menu.nextLine();
                    while (i<0 || j>i){
                        System.out.println("Informe um valor válido. ");
                        System.out.println("Selecione a especie desejada para cadastrar a raca: ");
                        j= menu.nextInt();menu.nextLine();
                    }
                    System.out.println("Especie: "+especies.get(j).getNome());

                    System.out.println("Informe o nome da raca: ");
                    String nomeRaca=menu.nextLine();menu.nextLine();
                    //INFORMA NOME RACA E VERIFICA EXISTENCIA
                    Boolean racaJaExiste=false;
                    for (Raca r : racas){
                        if (r.getNome() == nomeRaca){
                            System.out.println("Raca ja existente com o nome: "+ nomeRaca+ ". Favor cadastre a Raca com outro nome.");
                            racaJaExiste = true;
                            break;
                        }
                    }
                    if (racaJaExiste) break;
                    // CRIA RACA COM A ESPECIE
                    racas.add(new Raca(nomeRaca, especies.get(j)));
                }
               
                

               
                
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;
            case 6:
                Menu.mainMenu();
                break;
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







