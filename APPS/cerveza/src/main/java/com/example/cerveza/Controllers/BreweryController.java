package com.example.cerveza.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cerveza.Models.BreweryOldModel;
import com.example.cerveza.Models.BreweryNewModel;
import com.example.cerveza.Repositories.BreweryNewRepository;
import com.example.cerveza.Repositories.BreweryOldRepository;

@Controller
public class BreweryController {
    @Autowired
    BreweryNewRepository breweryNewRepository;
    @Autowired
    BreweryOldRepository breweryOldRepository;


    @RequestMapping("/formBrewery") //Si en el navegador ponemos localhost:8080/formBrewery, nos lleva a la vista formBrewery.html
    public String formBrewery(Model model){
        model.addAttribute("nuevaBrewery", new BreweryNewModel()); //Creamos un objeto de tipo BreweryNewModel y lo pasamos a la vista
        return "formBrewery";
    }


    @RequestMapping("/insertarBrewery") //Si en el navegador ponemos localhost:8080/insertarBrewery, se ejecuta este método
    public String insertarBrewery(BreweryNewModel nuevaBrewery,
                                    @RequestParam(name = "nueva", required = false, defaultValue = "false") boolean nueva) {
                                    //RequestParam es para obtener el valor de un input que hay en la vista con el mismo nombre
                                    //required = false, significa que no es obligatorio que el valor esté en el input
                                    //defaultValue = "false", significa que si no hay valor en el input, se le asigna el valor false
                                    //Y se guarda en la variable booleana llamada nueva

        if (nueva == true) { //Si hemos marcado el checkbox de nueva, quiere decir que es una nueva brewery y se inserta en la tabla de breweryNew
            breweryNewRepository.insertarBreweryNew(nuevaBrewery);
        } 
        else { //Si no, quiere decir que es una brewery antigua y se inserta en la tabla de breweryOld
            //Creamos un objeto de tipo BreweryOldModel porque por defecto en el formulario creamos un objeto de tipo BreweryNewModel
            BreweryOldModel breweryOld = new BreweryOldModel(); 
            breweryOld.setNombre(nuevaBrewery.getNombre());
            breweryOldRepository.insertarBreweryOld(breweryOld);
        }
        return "index";
    }


}
