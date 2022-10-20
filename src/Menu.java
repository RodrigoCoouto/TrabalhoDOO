import java.io.IOException;
import java.util.Scanner;

public class Menu {
    
    public Menu() {
    }
    public static void Menu() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        Scanner aux = new Scanner (System.in);
        int opcao = 0;
        String lixo;
        while (opcao!=5) {            
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print("##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Usuario                    |\n");
            System.out.print("| Opção 2 - Cadastrar Animal                     |\n");
            System.out.print("| Opção 3 - Buscar animal                        |\n");
            System.out.print("| Opção 4 -                                      |\n");
            System.out.print("| Opção 5 - Sair                                 |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();

             if (opcao == 5) {
                 menu.close();
                 aux.close();
             }

            switch (opcao) {
            case 1:
                opcao1();
                break;

            case 2:
                opcao2();
                break;

            case 3:
                
                break;

            case 4:
                
                break;

            case 5:
                
                break;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
            if(opcao!=5){
                System.out.print("\nPressione Enter para continuar...");
                lixo=aux.nextLine();
            }
        }
    }
    protected static void opcao1() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        Scanner aux = new Scanner (System.in);
        int opcao = 0;
        String lixo;
        while (opcao!=5) {            
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print("##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Usuario                    |\n");
            System.out.print("| Opção 2 - Cadastrar Animal                     |\n");
            System.out.print("| Opção 3 - Buscar animal                        |\n");
            System.out.print("| Opção 4 -                                      |\n");
            System.out.print("| Opção 5 - Sair                                 |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();

             if (opcao == 5) {
                 menu.close();
                 aux.close();
             }

            switch (opcao) {
            case 1:
                
                break;

            case 2:
                
                break;

            case 3:
                
                break;

            case 4:
                
                break;

            case 5:
                
                break;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
            if(opcao!=5){
                System.out.print("\nPressione Enter para continuar...");
                lixo=aux.nextLine();
            }
        }
    } 
    

    protected static void opcao2() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        int opcao = 0;
        //VARIAVEIS A SEREM UTILIZADAS NO MENU 

        String nome;
        int idade;
        float peso;
        float altura;
        String especie;
        String raca;


        while (opcao!=5) {            
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print("##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Criar Animal                         |\n");
            System.out.print("| Opção 2 - Editar Animal                        |\n");
            System.out.print("| Opção 3 - Remover Animal                       |\n");
            System.out.print("| Opção 4 - Listar animais                       |\n");
            System.out.print("| Opção 5 - Voltar                               |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();

             if (opcao == 4) {
                 menu.close();
             }

            switch (opcao) {
            case 1:
                //Criar animal
                System.out.println("Informe o NOME do Animal: "); 
                nome=menu.nextLine();
                //pede idade;
                System.out.println("Informe a IDADE: ");
                idade =menu.nextInt();
                //pede peso;
                System.out.println("Informe o PESO: ");
                peso=menu.nextFloat();
                //pede altura;
                System.out.println("Informe a ALTURA: ");
                altura=menu.nextFloat();
                //pede especie;
                System.out.println("Informe a ESPECIE: ");
                especie=menu.nextLine(); 
                //pede raca;
                System.out.println("Informe a RACA: ");
                raca=menu.nextLine();


                break;

            case 2:
                System.out.println("Informe o nome do Animal: "); //DUVIDA, que atributo usar para buscar

                //CHAMA METODO DE BUSCA

                //CHAMA MENU DE OPCOES EDITAR ANIMAL

                break;

            case 3:
                System.out.println("Informe o nome do Animal: "); //DUVIDA, que atributo usar para buscar

                //CHAMA METODO DE BUSCA

                // CHAMA METODO DE RECOMOCAO
                
                break;
            case 4:
                return;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
            if(opcao!=5){
                System.out.print("\nPressione Enter para continuar...");
                menu.nextLine();
            }
        }
    }

}
