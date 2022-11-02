package dao;

import java.sql.Statement;
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
                if (rs.getInt("cpf") == cpf) // caso encontre o cpf, entao o usuario ja foi 
                    if (rs.getBoolean("funcionario")) // caso for um funcionario, retorna um 
                        return new Funcionario(rs.getInt("cpf"), rs.getString("nome"), rs.getString("senha"));
                    return new Voluntario(rs.getInt("cpf"), rs.getString("nome"), rs.getString("senha"));
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void salvaUsuario(Usuario usr, boolean funcionario) {
		try {
            Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
            String func = "false";
            if (funcionario) func = "true";

			stmt.executeUpdate(
                "INSERT INTO usuario (cpf, nome, senha, funcionario)"
                + "VALUES ("
                + usr.getCpf() + ", "
                + "\"" + usr.getNome() + "\", "
                + "\"" + usr.getSenha() + "\", "
                + "\"" + func + "\", "
                + ")"
            );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletaUsuario(int cpf) {
        try {
            Connection conn = ConexaoSingleton.getConnection();
            Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM usuario WHERE cpf="+cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}