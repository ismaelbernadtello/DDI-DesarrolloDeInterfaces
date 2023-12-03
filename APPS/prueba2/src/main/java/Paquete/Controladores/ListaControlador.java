package Paquete.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Paquete.Modelos.BreweryNew;
import Paquete.Repositorios.BreweryNewRepositorio;

@Controller
public class ListaControlador {

    //El autowired instancia y rellena automáticamente la variable con un objeto de esta clase si lo hay en el proyecto
    //esta clase debe estar marcada con @Component o alguno parecido como @Service o @Repository
    @Autowired
    BreweryNewRepositorio  breweryNewRepositorio;
    
    @RequestMapping("/lista")
    public String visitarLista(Model model){
        List<BreweryNew> listaBreweryNew = breweryNewRepositorio.sacarTodasBreweryNew();
        model.addAttribute("lista", listaBreweryNew);
        return "list";
    }

    @RequestMapping("/form")
    public String formularioInserccion(Model model){
        model.addAttribute("nuevoBreweryNew", new BreweryNew());
        return "form";
    }

    @RequestMapping("/insertarBreweryNew")
    public String insertarBreweryNew(BreweryNew breweryNew, Model model){
        breweryNewRepositorio.insertarBreweryNew(breweryNew);
        return visitarLista(model);
    }

    // si queires sacar parámetros de una url que no sean de GET o POST pones entre corchetes la parte de la url que es el parámetro
    @RequestMapping("/eliminarBreweryNew/{id}")
    public String eliminarBreweryNew(@PathVariable int id, Model model){
        BreweryNew breweryNew = breweryNewRepositorio.sacaBreweryNewPorId(id);
        breweryNewRepositorio.eliminarBreweryNew(breweryNew);
        return visitarLista(model);
    }

    @RequestMapping("/modificarBreweryNew/{id}")
    public String modificarBreqeryNew(@PathVariable int id, Model model){
        BreweryNew breweryNew = breweryNewRepositorio.sacaBreweryNewPorId(id);
        model.addAttribute("breweryNewModificar", breweryNew);
        return "formActualizacion";
    }

    @RequestMapping("/actualizarBreweryNew")
    public String actualizarBreweryNew(BreweryNew breweryNew, Model model){
        breweryNewRepositorio.actualizarBreweryNew(breweryNew);
        return visitarLista(model);
    }
}
