package com.example.cerveza.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cerveza.Models.BeerModel;


@Repository //Indica que esta clase es un repositorio
public class BeerRepository {
    
    // en los repositorioes esto entra siempre, es la forma de conectarse a la BD
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BeerModel> sacarTodasBeer(){ //Este método saca todas las cervezas de la BD usando el rowmapper
        List<BeerModel> listaBeer = jdbcTemplate.query("SELECT * FROM beer", new BeerRowMapper());
        return listaBeer;
    }

    public void insertarBeer(BeerModel beer){ //Este método recibe un objeto de la clase BeerModel y lo inserta en la BD
        jdbcTemplate.update("INSERT INTO beer (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES (?, ?, ?, ?)", beer.getNombre(), beer.getFechaLanzamiento(), beer.getCodigoBreweryNew(), beer.getCodigoBreweryOld());
    }



    
}
