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
        String query = "SELECT b.*, brn.nombre as Nombre_NEW,bro.nombre as Nombre_OLD FROM BEER AS b LEFT JOIN BREWERY_NEW AS brn on b.BREWERY_NEW = brn.ID LEFT JOIN BREWERY_OLD AS bro on b.BREWERY_OLD = bro.ID;";
        List<BeerModel> listaBeer = jdbcTemplate.query(query, new BeerRowMapper());
        return listaBeer;
    }

    public void insertarBeer(BeerModel beer){ //Este método recibe un objeto de la clase BeerModel y lo inserta en la BD
        jdbcTemplate.update("INSERT INTO beer (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES (?, ?, ?, ?)", beer.getNombre(), beer.getFechaLanzamiento(), beer.getCodigoBreweryNew(), beer.getCodigoBreweryOld());
    }



    
}
