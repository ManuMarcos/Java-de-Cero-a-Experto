package com.arg.ecommerce.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Controlador {

    @GetMapping("/")
    public String inicio(Model model){
        //TODO: Productos service para listar todos los productos disponibles

        log.info("Ejecutando el controlador Spring MVC");
        return "home";
    }
}
