package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Alumno;

public class AlumnoDAO extends GenericDAO {
    
    public List<Alumno> listar(){
        String hql = "SELECT a FROM Alumno a";
        em =  getEntityManager();
        return em.createQuery(hql).getResultList();
    }
    
    public void insertar(Alumno alumno){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Alumno alumno){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Alumno alumno){
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Alumno buscar(Alumno alumno){
        em =  getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
    
}
