package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Curso;

public class CursoDAO extends GenericDAO{
    
    public List<Curso> listar(){
        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        return em.createQuery(hql).getResultList();
    }
    
    public void insertar(Curso curso){
        try{
            em = getEntityManager();
            em.getTransaction();
            em.persist(curso);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Curso curso){
        try{
            em = getEntityManager();
            em.getTransaction();
            em.merge(curso);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Curso curso){
        try{
            em = getEntityManager();
            em.getTransaction();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Curso buscar(Curso curso){
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
    }
}
