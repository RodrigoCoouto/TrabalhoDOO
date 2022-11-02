package menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.vaccine.TipoVacina;
import model.vaccine.Vacina;

public class VacinaMenu {
    private static ArrayList<TipoVacina> tipoVacina = new ArrayList<TipoVacina>();


    /**
     * @throws IOException
     * @throws InterruptedException
     */
    public static void cadastroTipoVacina() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        int opcao = 0;
        int aux;

        
        String nome;
        String tipo;


        while (opcao!=5) {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print(" ##---------------------Menu-------------------##\n\n");
            System.out.print("|-------------------------------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Vacina                      |\n");
            System.out.print("| Opção 2 - Deletar Vacina                        |\n");
            System.out.print("| Opção 3 - Listar Vacina                         |\n");
            System.out.print("| Opção 4 - Editar Vacina                         |\n");
            System.out.print("| Opção 5 - Voltar ao Menu Principal              |\n");
            System.out.print("|-------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();
            menu.nextLine();

            switch (opcao) {
            case 1:

                    System.out.println("Digite a nome da vacina a ser cadastrada:");
                    nome = menu.nextLine();
                    for (TipoVacina tv : tipoVacina){
                        while(tv.getNome().equals(nome)){
                            System.out.println("Digite a nome da vacina a ser cadastrada:");
                            nome = menu.nextLine();
                        }
                    }
                    System.out.println("Digite o tipo da vacina a ser cadastrada:");
                    tipo = menu.nextLine();
                    tipoVacina.add(new TipoVacina(nome, tipo));
                    System.out.println("Nova Vacina cadastrada.");
                    
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;
        
            case 2:

                System.out.print("Digite o nome da vacina que deseja deletar: ");
                nome = menu.nextLine();

                for (TipoVacina tv : tipoVacina){
                    if (tv.getNome().equals(nome)){ 
                        System.out.println("Vacina removida: "+ tv.getNome());
                        tipoVacina.remove(tv);
                        break;
                    }
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 3:
                for (TipoVacina tv : tipoVacina){
                    System.out.print("Nome: "); System.out.println(tv.getNome());
                    System.out.print("Tipo: "); System.out.println(tv.getTipo());
                    System.out.print("\n");
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 4:
                System.out.print("Digite o nome da vacina que deseja editar: ");
                nome = menu.nextLine();

                for (TipoVacina tv : tipoVacina){
                    if (tv.getNome().equals(nome)){ 
                        System.out.println("Digite o novo nome para: "+ tv.getNome());
                        nome = menu.nextLine();
                        tv.setNome(nome);
                        break;
                    }
                }

                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;
            case 5:
                Menu.mainMenu();
                break;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
        }
    }
}