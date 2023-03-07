package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Definimos la variable
        Contacto contacto = null;
        
        //Recuperamos el objeto
        //1. Transitivo
        contacto = em.find(Contacto.class, 3);
        
        //Modificamos el objeto
        contacto.setEmail("clara@mail.com");
        
        //Iniciamos la transaccion
        em.getTransaction().begin();
        
        //2.Persistente
        //em.persist(contacto);
        em.merge(contacto);
        
        em.getTransaction().commit();
        
        //3. Detached
        System.out.println("contacto = " + contacto);
        
    }
    
    
    
    
}
