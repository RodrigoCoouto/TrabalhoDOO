package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton{
    private static ConexaoSingleton instancia = null;

    static private Connection c;

    private static final String driv = "jdbc";
    private static final String banc = "postgresql";
    private static final String host = "ec2-44-209-24-62.compute-1.amazonaws.com"; // hospedagem gratis disponibilizada pelo Heroku
    private static final String port = "5432";
    private static final String dtbs = "ddhplpckge094m";
    private static final String user = "qeojheydmosjdv";
    private static final String pass = "8e54b33254bd329f49a2a261081acbccb9f46d5037b952b542220afb0e954328";

    private ConexaoSingleton() throws SQLException{
        c = DriverManager.getConnection(
            driv + ":" + banc + "://" + host + ":" + port + "/" + dtbs,
            user,
            pass
            );
    }

    public static Connection getConnection() throws SQLException{ 
        if (instancia == null) // caso a instancia global ainda nao tenha sido iniciado
            instancia = new ConexaoSingleton(); // entao inicia o Singleton, abrindo a conexao com o BD
        return c; // retorna a conexao com o banco de dados
    }

    public void closeConnection() throws SQLException{
        c.close();
    }
}