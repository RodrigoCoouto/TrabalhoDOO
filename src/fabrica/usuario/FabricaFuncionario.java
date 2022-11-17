package fabrica.usuario;

import java.util.Scanner;

import dao.UserDAO;
import model.user.Funcionario;

public class FabricaFuncionario implements UsuarioAbstrato{

    @Override
    public void cadastraUsuario() {
        int cpf;
        String nome, senha;
        Scanner menu = new Scanner (System.in);
        UserDAO usrDAO = new UserDAO();

        System.out.println("Digite o CPF do Funcionario a ser cadastrado:");
        cpf = menu.nextInt();menu.nextLine();
        System.out.println("Digite o nome do Funcionario a ser cadastrado:");
        nome = menu.nextLine();
        System.out.println("Digite a senha do Funcionario a ser cadastrado:");
        senha = menu.nextLine(); 

        Funcionario usr = new Funcionario(cpf, senha, nome);
        usrDAO.salvaUsuario(usr, true);
    }
    
}
