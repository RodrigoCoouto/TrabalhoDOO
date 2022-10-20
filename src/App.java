// import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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
}
