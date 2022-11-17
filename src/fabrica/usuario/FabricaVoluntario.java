package fabrica.usuario;

import java.util.Scanner;

import dao.UserDAO;
import model.user.Voluntario;

public class FabricaVoluntario implements UsuarioAbstrato{

    @Override
    public void cadastraUsuario() {
        int cpf;
        String nome, senha;
        Scanner menu = new Scanner (System.in);
        UserDAO usrDAO = new UserDAO();

        System.out.println("Digite o CPF do Voluntario a ser cadastrado:");
        cpf = menu.nextInt();menu.nextLine();
        System.out.println("Digite o nome do Voluntario a ser cadastrado:");
        nome = menu.nextLine();
        System.out.println("Digite a senha do Voluntario a ser cadastrado:");
        senha = menu.nextLine(); 

        Voluntario usr = new Voluntario(cpf, senha, nome);
        usrDAO.salvaUsuario(usr, false);
    }
    
}
