package menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import model.user.Funcionario;
import model.user.Voluntario;

public class UserMenu {

    public static void cadastroUsuario() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        int opcao = 0;
        int aux;

        int cpf;
        String senha;
        String nome;

        UserDAO usrDAO = new UserDAO();

        List<Funcionario> funcionarios;
        List<Voluntario> voluntarios;

        while (opcao!=5) {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print(" ##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Usuario                    |\n");
            System.out.print("| Opção 2 - Deletar Usuario                      |\n");
            System.out.print("| Opção 3 - Listar Usuarios                      |\n");
            System.out.print("| Opção 4 - Editar Usuario                       |\n");
            System.out.print("| Opção 5 - Voltar ao Menu Principal             |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();
            menu.nextLine();

            switch (opcao) {
            case 1: // adicionar
                System.out.println("Digite o CPF do Usuario a ser cadastrado:");
                cpf = menu.nextInt();menu.nextLine();
                System.out.println("Digite o nome do Usuario a ser cadastrado:");
                nome = menu.nextLine();
                System.out.println("Digite a senha do Usuario a ser cadastrado:");
                senha = menu.nextLine();
                System.out.println("Qual tipo de Usuario deseja criar?");
                System.out.println("1 - Funcionario");
                System.out.println("2 - Voluntario");
                aux = menu.nextInt();menu.nextLine();

                if (aux == 1){ // funcionario
                    Funcionario usr = new Funcionario(cpf, senha, nome);
                    usrDAO.salvaUsuario(usr, true);
                }else if (aux == 2){ // voluntario
                    Voluntario usr = new Voluntario(cpf, senha, nome);
                    usrDAO.salvaUsuario(usr, false);
                } else{
                    System.out.println("Opcao invalida. O usuario nao foi cadastrado.");
                }

                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 2: // deletar
                System.out.print("Digite o CPF que deseja deletar: ");
                cpf = menu.nextInt();menu.nextLine();

                usrDAO.deletaUsuario(cpf);

                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 3: // listar
                funcionarios = usrDAO.getAllFuncionario();
                voluntarios = usrDAO.getAllVoluntario();

                for (Funcionario f : funcionarios){
                    System.out.print("Nome: "); System.out.println(f.getNome());
                    System.out.print("CPF: "); System.out.println(f.getCpf());
                }
                for (Voluntario v : voluntarios){
                    System.out.print("Nome: "); System.out.println(v.getNome());
                    System.out.print("CPF: "); System.out.println(v.getCpf());
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 4: // editar
                System.out.println("Digite o CPF do Usuario a ser editado:");
                cpf = menu.nextInt();menu.nextLine();
                System.out.println("Digite o novo nome para o Usuario:");
                nome = menu.nextLine();

                usrDAO.editaUsuario(cpf, nome);
                
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 5: // finaliza menu
                return;
            default:
                System.out.print("\nOpção Inválida!");
                break;
            }
        }
    }
}
