package cliente;

import domain.Persona;
import javax.naming.*;
import org.apache.logging.log4j.*;
import servicio.PersonaServiceRemote;

public class PruebaManejoTranasacciones {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!servicio.PersonaServiceRemote");
            
            log.debug("Iniciando prueba Manejo transaccional PersonaService");
            
            //Buscar un objeto persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));
            
            log.debug("Persona recuperada: " + persona1);
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
        
    }
    
    
    
}
