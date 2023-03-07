package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //No es necesario iniciar una transaccion para recuperar el objeto
        
        //Definimos la variable
        Contacto contacto = null;
        
        //Recuperamos el objeto
        contacto = em.find(Contacto.class, 3);
        
        //Detached
        System.out.println("contacto = " + contacto);
    }
    
}
