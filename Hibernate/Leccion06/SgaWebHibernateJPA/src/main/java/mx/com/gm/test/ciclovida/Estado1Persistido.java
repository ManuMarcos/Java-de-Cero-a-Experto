package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Estado Transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("11223344");
        
        //2. Persistimos el objeto
        em.getTransaction().begin();
        
        em.persist(contacto);
        
        em.getTransaction().commit();
        
        //3. Detached (separado)
        System.out.println("Contacto = " + contacto);
        
    }
}
