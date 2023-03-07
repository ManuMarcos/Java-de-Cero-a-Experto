package mx.com.gm.test;

import javax.persistence.*;
import mx.com.gm.domain.Alumno;

public class MyTests {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Alumno alumno = em.find(Alumno.class, 3);
        System.out.println("alumno = " + alumno);
        
    }
    
    
}
