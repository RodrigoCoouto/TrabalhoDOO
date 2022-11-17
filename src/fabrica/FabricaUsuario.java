package fabrica;

import fabrica.usuario.FabricaFuncionario;
import fabrica.usuario.FabricaVoluntario;
import fabrica.usuario.UsuarioAbstrato;

public class FabricaUsuario {
    public static UsuarioAbstrato getFactory(int nivel){
        if(nivel == 0){
            return null;
        }

        if(nivel==2){ // voluntario
            return new FabricaVoluntario();  
        } else if(nivel==1){ // funcionario
            return new FabricaFuncionario();
        }

        System.out.println("Opcao invalida. O usuario nao foi cadastrado.");
        return null;
    }
}
