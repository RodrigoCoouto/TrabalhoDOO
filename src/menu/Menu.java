package menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void mainMenu() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        Scanner auxS = new Scanner (System.in);
        int opcao = 0;
        
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
            System.out.print("| Opção 3 - Cadastrar Raca                       |\n");
            System.out.print("| Opção 4 -                                      |\n");
            System.out.print("| Opção 5 - Sair                                 |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();menu.nextLine();

            if (opcao == 5) {
                menu.close();
                auxS.close();
            }

        switch (opcao) {
            case 1:
                UserMenu.cadastroUsuario();

                break;

            case 2:
                AnimalMenu.cadastroAnimal();
                break;

            case 3:
                
                break;

            case 4:
                VacinaMenu.cadastroTipoVacina();
                break;

            case 5:
                
                break;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
            if(opcao!=5){
                System.out.print("\nPressione Enter para continuar...");
                auxS.nextLine();
            }
        }
    }
 
}
