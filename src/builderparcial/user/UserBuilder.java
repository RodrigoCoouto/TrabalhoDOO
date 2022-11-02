package builderparcial.user;

import dao.UserDAO;

public class UserBuilder implements UserBuilderInterface{

    UserDAO usrDao = new UserDAO();
    
    @Override
    public void setNome(String nome) {
        System.out.print("Digite o nome do novo Usuario: ");
        // System.out.println("Digite o novo nome para: "+ a.getNome());
        // nome = menu.nextLine();
    }

    @Override
    public void setCPF(int cpf) {
        System.out.print("Digite o CPF do novo Usuario: ");
        
    }

    @Override
    public void setSenha(String senha) {
        System.out.print("Digite a senha do novo Usuario: ");
        
    }

	@Override
	public boolean cpfJaCadastrado(int cpf) {
		if (usrDao.buscaUsuario(cpf) != null)
            return true;
		return false;
	}
    
}
