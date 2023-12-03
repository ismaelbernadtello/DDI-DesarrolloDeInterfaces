package Paquete.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// a todo controlador se le indica con @Controller
@Controller
public class IndexControlador {
    
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
