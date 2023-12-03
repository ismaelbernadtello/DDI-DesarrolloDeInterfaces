package com.example.cerveza.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cerveza.Models.BreweryNewModel;

@Repository
public class BreweryNewRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertarBreweryNew(BreweryNewModel breweryN){ //Este método recibe un objeto de la clase BeerModel y lo inserta en la BD
        jdbcTemplate.update("INSERT INTO brewery_new (nombre) VALUES (?)", breweryN.getNombre());
    }

    public void borrarBreweryNew(BreweryNewModel breweryN){
        jdbcTemplate.update("DELETE FROM brewery_new WHERE id = ?", breweryN.getId());
    }

    public void actualizarBreweryNew(BreweryNewModel breweryN){
        jdbcTemplate.update("UPDATE brewery_new SET nombre = ? WHERE id = ?", breweryN.getNombre(), breweryN.getId());
    }

    public BreweryNewModel buscarBreweryNewPorId(int id){
        BreweryNewModel breweryN = jdbcTemplate.queryForObject("SELECT * FROM brewery_new WHERE id = ?", new BreweryNewRowMapper(), id);
        return breweryN;
    }

    public List<BreweryNewModel> sacarTodasBreweryNew(){ //Este método saca todas las cervezas de la BD usando el rowmapper
        String query = "SELECT * FROM brewery_new";
        List<BreweryNewModel> listaBreweryNew = jdbcTemplate.query(query, new BreweryNewRowMapper());
        return listaBreweryNew;
    } 
}
