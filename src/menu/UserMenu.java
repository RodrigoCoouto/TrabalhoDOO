package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.user.Funcionario;
import model.user.Voluntario;

public class UserMenu {
    private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private static List<Voluntario> voluntarios = new ArrayList<Voluntario>();

    public static void cadastroUsuario() throws IOException, InterruptedException{
        Scanner menu = new Scanner (System.in);
        int opcao = 0;
        int aux;

        int cpf;
        String senha;
        String nome;
        Boolean encontrado;

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
            case 1:
                System.out.println("Digite o CPF do Usuario a ser cadastrado:");
                cpf = menu.nextInt();menu.nextLine();

                encontrado = false;
                for (Funcionario f : funcionarios){
                    if (f.getCpf() == cpf){
                        encontrado = true;
                        System.out.println("Este CPF ja se encontra cadastrado como Funcionario.");
                        break;
                    }
                }
                for (Voluntario v : voluntarios){
                    if (v.getCpf() == cpf){
                        encontrado = true;
                        System.out.println("Este CPF ja se encontra cadastrado como Voluntario.");
                        break;
                    }
                }
                if (!encontrado){
                    // caso chegue aqui, entao o CPF nao esta cadastrado, e o cadastro sera prosseguido
                    System.out.println("Digite a senha do Usuario a ser cadastrado:");
                    senha = menu.nextLine();
                    System.out.println("Digite o nome do Usuario a ser cadastrado:");
                    nome = menu.nextLine();

                    System.out.println("Qual tipo de Usuario deseja criar?");
                    System.out.println("1 - Funcionario");
                    System.out.println("2 - Voluntario");
                    aux = menu.nextInt();menu.nextLine();

                    if (aux == 1){ // funcionario
                        funcionarios.add(new Funcionario(cpf, senha, nome));
                        System.out.println("Novo Funcionario cadastrado.");
                    }else if (aux == 2){ // voluntario
                        voluntarios.add(new Voluntario(cpf, senha, nome));
                        System.out.println("Novo Voluntario cadastrado.");
                    } else{
                        System.out.println("Opcao invalida. O usuario nao foi cadastrado.");
                    }
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 2:
                System.out.print("Digite o CPF que deseja deletar: ");
                cpf = menu.nextInt();menu.nextLine();

                for (Funcionario f : funcionarios){
                    if (f.getCpf() == cpf){ 
                        System.out.println("Funcionario removido: "+ f.getNome());
                        funcionarios.remove(f);
                        break;
                    }
                }
                for (Voluntario v : voluntarios){
                    if (v.getCpf() == cpf){ 
                        System.out.println("Funcionario removido: "+ v.getNome());
                        voluntarios.remove(v);
                        break;
                    }
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 3:
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

            case 4:
                System.out.print("Digite o CPF que deseja editar: ");
                cpf = menu.nextInt();menu.nextLine();

                for (Funcionario f : funcionarios){
                    if (f.getCpf() == cpf){ 
                        System.out.println("Digite o novo nome para: "+ f.getNome());
                        nome = menu.nextLine();
                        f.setNome(nome);
                        break;
                    }
                }
                for (Voluntario v : voluntarios){
                    if (v.getCpf() == cpf){ 
                        System.out.println("Digite o novo nome para: "+ v.getNome());
                        nome = menu.nextLine();
                        v.setNome(nome);
                        break;
                    }
                }
                System.out.println("Pressione Enter para continuar.");
                menu.nextLine();
                break;

            case 5:

                return;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
        }
    }
}
