package cliente;

import domain.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import servicio.PersonaServiceRemote;

public class ClientePersonaService {
    
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente \n");
        try {
            Context jndi =  new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            for (Persona persona : personas){
                System.out.println(persona);
            }
            
            System.out.println("\n Fin llamada al EJB desde el Cliente");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
