package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    
    public static void main(String[] args){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        //Insertar un nuevo usuario en la BDD
        
        Usuario nuevoUsuario = new Usuario("lmessi", "lio123");
        usuarioDao.insertar(nuevoUsuario);
        
        
        //Eliminar un usuario de la BDD
        /*
        Usuario usuarioAEliminar = new Usuario(2);
        usuarioDao.eliminar(usuarioAEliminar);
        */
        
        //Modificar un usuario de la BDD
        /*
        Usuario usuarioModificado = new Usuario(1, "Carlos", "Suarez");
        usuarioDao.actualizar(usuarioModificado);
        */
        
        
        
        //Seleccionamos todos los usuarios
        List<Usuario> usuarios = usuarioDao.seleccionar();
        for (Usuario ui : usuarios){
            System.out.println("Usuario = " + ui);
        }
        
        
        
        
        
    }

}
