package cliente.ciclovida;

import domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;



public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1. Creo un nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", "pluna@mail.com", "14875693");
        
        //Paso 2. Inicia la transaccion
        tx.begin();
        
        //Paso 3. Ejectutamos SQL
        em.persist(persona1);
        log.debug("objeto persistido - aun sin commit: " + persona1);
        
        //Paso 4. commit/rollback
        tx.commit();
        
        //Objeto en estado detached
        log.debug("objeto persistido - estado detached: " + persona1);
        
        //Cerramos el entity manager
        em.close();
    }
}
