package test;

import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestManejoUsuarios {
    
    public static void main(String[] args){
        UsuarioDao usuarioDao = new UsuarioDaoJDBC();
        
        //Insertar un nuevo usuario en la BDD
        
        UsuarioDTO nuevoUsuario = new UsuarioDTO("lmessi", "lio123");
        
        try {
            usuarioDao.insert(nuevoUsuario);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        
        
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
        List<UsuarioDTO> usuarios;
        try {
            usuarios = usuarioDao.select();
            for (UsuarioDTO ui : usuarios){
                System.out.println("Usuario = " + ui);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestManejoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }

}
