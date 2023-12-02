package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.HolaRowMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller //Hace que la clase sea un controlador
@Data //Con lombok se creean automaticamtente los getter, setter, toString, etc
public class HolaController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //Esto hace que cuando se llame a la url / se ejecute el método Hola y este nos lleve a la vista form.html
    @RequestMapping("/") // localhost:8080/ hace que se llame a este método
    // Método que devuelve un String con el nombre de la vista a mostrar
    public String Hola(Model model) { //Model es un objeto que se usa para pasar datos a la vista
        // PASO 2:
        model.addAttribute("hola", new com.example.demo.model.Hola());
        //model.addAttribute 
        //hola es la variable que queremos relleñar en la vista
        //new com.example.demo.model.Hola() es el objeto que queremos pasar a la vista
        return "form";
    }

    // Método que recibe el id del registro a eliminar y lo elimina de la base de datos
    @RequestMapping("/deleteHola/{id}")
    public String deleteHola(@PathVariable Integer id, Model model) {
        jdbcTemplate.update("DELETE FROM hola WHERE id=?", new Object[] { id });
        List<com.example.demo.model.Hola> holaLista = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM hola", new HolaRowMapper())
                .forEach(hola1 -> holaLista.add(hola1));
        model.addAttribute("holaLista", holaLista);
        return "result";
    }

    // PASO 4: recibe los datos del formulario y los inserta en la base de datos
    @RequestMapping("/insertHola")
    public String insertHola(com.example.demo.model.Hola hola, Model model) {
        if (hola.getId() != null) {
            jdbcTemplate.update("UPDATE hola SET nombre=?, email=?, contracena=?, rol=? WHERE id=?", hola.getNombre(),
                    hola.getEmail(), hola.getContracena(), hola.getRol(), hola.getId());
            return "result";
        } else {
            jdbcTemplate.update("INSERT INTO hola (nombre, email, contracena, rol) VALUES (?, ?, ?, ?)",
                    hola.getNombre(),
                    hola.getEmail(), hola.getContracena(), hola.getRol());
            model.addAttribute("hola", hola);
            System.out.println(hola.toString());
            List<com.example.demo.model.Hola> holaLista = new ArrayList<>();
            jdbcTemplate.query("SELECT * FROM hola", new HolaRowMapper())
                    .forEach(hola1 -> holaLista.add(hola1));
            model.addAttribute("holaLista", holaLista);
            return "result";
        }
    }
    // Método que recibe el id del registro a modificar y lo busca en la base de datos
    @RequestMapping("/updateHola/{id}")
    public String updateHola(@PathVariable Integer id, Model model) {
        com.example.demo.model.Hola hola = jdbcTemplate.queryForObject("SELECT * FROM hola WHERE id=?",
                new Object[] { id }, new HolaRowMapper());
        model.addAttribute("hola", hola);
        return "form";
    }
}
