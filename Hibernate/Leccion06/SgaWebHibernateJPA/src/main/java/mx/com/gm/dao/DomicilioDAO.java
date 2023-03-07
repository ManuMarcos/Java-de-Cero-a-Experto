package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO{
 
    
    public List<Domicilio> listar(){
        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        return em.createQuery(hql).getResultList();
    }
    
    public void insertar(Domicilio domicilio){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Domicilio domicilio){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Domicilio domicilio){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Domicilio buscar(Domicilio domicilio){
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
    
    
}
