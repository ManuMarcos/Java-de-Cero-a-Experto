package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Hola Mundo con Thymeleaf";
        log.info("ejecutando el controlador Spring MVC");
        
        
        var persona =  new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("4455661332");
        
        var persona2 = new Persona();
        persona2.setNombre("Manuel");
        persona2.setApellido("Marcos");
        persona2.setEmail("mmarcos@mail.com");
        persona2.setTelefono("1169691006");
        
        /*
        var personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2)
        */
        var personas = Arrays.asList(persona, persona2);
        
        
        model.addAttribute("persona", persona);
        model.addAttribute("mensaje", mensaje);
        //model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        return "index";
    }
    
    
    
    
}
