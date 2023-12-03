package com.example.cerveza.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.cerveza.Models.BreweryOldModel;

@Repository
public class BreweryOldRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertarBreweryOld(BreweryOldModel breweryO){ //Este método recibe un objeto de la clase BeerModel y lo inserta en la BD
        jdbcTemplate.update("INSERT INTO brewery_old (nombre) VALUES (?)", breweryO.getNombre());
    }

    public void borrarBreweryOld(BreweryOldModel breweryO){
        jdbcTemplate.update("DELETE FROM brewery_old WHERE id = ?", breweryO.getId());
    }
    
    public BreweryOldModel buscarBreweryOldPorId(int id){
        BreweryOldModel breweryO = jdbcTemplate.queryForObject("SELECT * FROM brewery_old WHERE id = ?", new BreweryOldRowMapper(), id);
        return breweryO;
    }

    public void actualizarBreweryOld(BreweryOldModel breweryO){
        jdbcTemplate.update("UPDATE brewery_old SET nombre = ? WHERE id = ?", breweryO.getNombre(), breweryO.getId());
    }


}
