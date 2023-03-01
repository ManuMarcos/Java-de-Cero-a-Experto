package cliente.cascade;

import domain.Persona;
import domain.Usuario;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class PersistenciaCascadaJPA {
    
    static Logger log =  LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Hugo", "Hernandez", "hherandez@mail.com", "1478669312");
        
        //Crear objeto usuario(tiene dependencia con el objeto persona)
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);
        
        //Paso 3. Persistimos el objeto usuario unicamente
        em.persist(usuario1);
        
        //Paso 4. Commit transaccion
        tx.commit();
        
        //Objetos en estado detached
        log.debug("Objeto persistido persona: " + persona1);
        log.debug("Objeto persistido usuario: " + usuario1);
        
        em.close();
        
    }
}
