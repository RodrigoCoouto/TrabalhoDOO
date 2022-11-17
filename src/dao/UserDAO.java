package dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.user.Funcionario;
import model.user.Usuario;
import model.user.Voluntario;
import singleton.ConexaoSingleton;

public class UserDAO{

	public Usuario buscaUsuario(int cpf) {
		try {
			Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario");

            while (rs.next()){
                if (rs.getInt("cpf") != cpf)
                    continue;
                // caso encontre o cpf, entao o usuario ja foi cadastrado
                if (rs.getBoolean("funcionario")) // caso for um funcionario, retorna um 
                    return new Funcionario(rs.getInt("cpf"), rs.getString("senha"), rs.getString("nome"));
                return new Voluntario(rs.getInt("cpf"), rs.getString("senha"), rs.getString("nome"));
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void salvaUsuario(Usuario usr, boolean funcionario) {
		if (this.buscaUsuario(usr.getCpf()) != null) {
            System.out.print("Ja existe um Usuario cadastrado com este cpf.\n");
            return;
        }

        try {
            Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            String func = "false";
            if (funcionario) func = "true";

			stmt.executeUpdate(
                "INSERT INTO usuario (cpf, nome, senha, funcionario)"
                + "VALUES ("
                + String.valueOf(usr.getCpf()) + ", "
                + "'" + usr.getNome() + "', "
                + "'" + usr.getSenha() + "', "
                + func
                + ");"
            );
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("Usuario cadastrado.");
	}

	public void deletaUsuario(int cpf) {
        Usuario u = this.buscaUsuario(cpf);
        if ( u == null) {
            System.out.print("Nao existe um Usuario cadastrado com este cpf.\n");
            return;
        }
        try {
            Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM usuario WHERE cpf="+cpf);
            System.out.println("Usuario deletado: "+ u.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void editaUsuario(int cpf, String nome){
        if (this.buscaUsuario(cpf) == null) {
            System.out.print("Nao existe um Usuario cadastrado com este cpf.\n");
            return;
        }

        Connection conn;
        String sql = "UPDATE usuario "
                    + "SET "
                    + "nome = '" + nome + "' "
                    + "WHERE cpf = "
                    + String.valueOf(cpf);

        try {
            conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.print("Usuario editado.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Funcionario> getAllFuncionario(){
        List<Funcionario> fList = new ArrayList<Funcionario>();

        try {
			Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE funcionario = true");

            while (rs.next())
                fList.add(new Funcionario(
                            rs.getInt("cpf"),
                            rs.getString("senha"),
                            rs.getString("nome")
                    )
                );
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return fList;
    }

    public List<Voluntario> getAllVoluntario(){
        List<Voluntario> vList = new ArrayList<Voluntario>();

        try {
			Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE funcionario = false");

            while (rs.next())
                vList.add(new Voluntario(
                            rs.getInt("cpf"),
                            rs.getString("senha"),
                            rs.getString("nome")
                    )
                );
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return vList;
    }
}