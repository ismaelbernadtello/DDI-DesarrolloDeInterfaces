package com.example.cerveza.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cerveza.Models.BreweryOldModel;
import com.example.cerveza.Models.BreweryNewModel;
import com.example.cerveza.Models.BeerModel;
import com.example.cerveza.Repositories.BeerRepository;
import com.example.cerveza.Repositories.BreweryNewRepository;
import com.example.cerveza.Repositories.BreweryOldRepository;



@Controller
public class BeerController {
    @Autowired
    BeerRepository beerRepository;


    @RequestMapping("/listarBeer") //Si en el navegador ponemos localhost:8080/listaBeer, nos lleva a la vista listaBeer.html
    public String listaBeer(Model model){
        List<BeerModel> listaBeer = beerRepository.sacarTodasBeer();
        model.addAttribute("listaBeer", listaBeer); //Creamos un objeto de tipo BreweryNewModel y lo pasamos a la vista
        return "listaBeer";
    }





}
