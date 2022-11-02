import menu.Menu;

import java.sql.Connection;

import singleton.ConexaoSingleton;

public class App {
    public static void main(String[] args) throws Exception {
        
        // testar singleton
        Connection c = ConexaoSingleton.getConnection();
        c.close();

        // chama menu
        // Menu.mainMenu();

    }
}
