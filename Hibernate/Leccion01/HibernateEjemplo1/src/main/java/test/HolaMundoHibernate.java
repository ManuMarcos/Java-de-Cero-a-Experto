package test;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona.Persona;

public class HolaMundoHibernate {
    
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for(Persona persona : personas){
            System.out.println("Persona: " + persona);
        }
    }
}
