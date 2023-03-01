package cliente.asociaciones;

import domain.Persona;
import domain.Usuario;
import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class ClienteAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //Cerramos la conexion
        em.clear();
        
        //Imprimir los objetos de tipo persona
        for(Persona persona : personas){
            log.debug("Persona:" + persona);
            //Recuperamos los usuarios de cada persona
            for(Usuario usuario : persona.getUsuarioList()){
                log.debug("Usuario: " + usuario);
            }
        }
        
    }
    
}
