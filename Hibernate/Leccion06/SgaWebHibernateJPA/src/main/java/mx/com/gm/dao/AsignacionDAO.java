package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Asignacion;

public class AsignacionDAO extends GenericDAO{
    
    public List<Asignacion> listar(){
        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        return em.createQuery(hql).getResultList();
    }
    
    public void insertar(Asignacion asignacion){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Asignacion asignacion){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Asignacion asignacion){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Asignacion buscar(Asignacion asignacion){
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }
    
}
