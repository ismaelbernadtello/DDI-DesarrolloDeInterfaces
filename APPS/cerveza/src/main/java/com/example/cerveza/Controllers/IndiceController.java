package com.example.cerveza.Controllers;

//Se importa la clase de springboot que nos permite crear un controlador
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Indica que esta clase es un controlador
public class IndiceController {
    
    @RequestMapping("/") //Al llamar a: localhost:8080/ se ejecuta este metodo y nos devuelve el index.html
    public String index(Model model){
        return "index"; //Retorna el index.html
    }


}
