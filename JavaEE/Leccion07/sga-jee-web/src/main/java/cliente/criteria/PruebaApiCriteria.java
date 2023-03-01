package cliente.criteria;

import domain.Persona;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;

public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el API de Criteria
        //1. Consulta de todas las personas
        
        //Paso 1. El objeto EntityManager crea una instancia CriteriaBuilder;
        cb = em.getCriteriaBuilder();
        
        //Paso 2. Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Paso 3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Paso 4. Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //Paso 5. Creamos el query typeSafe
        query = em.createQuery(criteriaQuery);
        
        //Paso 6. Ejecutamos la consulta
        personas = query.getResultList();
        mostrarPersonas(personas);
        
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona persona : personas){
            log.debug(persona);
        }
    }
    
    
}
