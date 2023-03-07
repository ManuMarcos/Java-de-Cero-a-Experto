package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class ContactoDAO extends GenericDAO{
    
    public List<Contacto> listar(){
        String hql = "SELECT c FROM Contacto c";
        em = getEntityManager();
        return em.createQuery(hql).getResultList();
    }
    
    public void insertar(Contacto contacto){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Contacto contacto){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Contacto contacto){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Contacto buscar(Contacto contacto){
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());
    }
}

