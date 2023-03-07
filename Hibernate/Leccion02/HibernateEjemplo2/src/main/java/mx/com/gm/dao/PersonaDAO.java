package mx.com.gm.dao;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona.Persona;

public class PersonaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonaDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public void listar(){
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for(Persona persona : personas){
            System.out.println("persona = " + persona);
        }
    }
    
    public void insertar(Persona persona){
        try{
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modificar(Persona persona){
        try{
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void eliminar(Persona persona){
        try{
            em.getTransaction().begin();
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public Persona buscar(Persona persona){
        return em.find(Persona.class, persona.getIdPersona());
    }
    
}
