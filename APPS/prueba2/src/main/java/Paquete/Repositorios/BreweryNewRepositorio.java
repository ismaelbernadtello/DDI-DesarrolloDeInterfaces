package Paquete.Repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Paquete.Modelos.BreweryNew;

@Repository
public class BreweryNewRepositorio {
    
    // en los repositorioes esto entra siempre, es la forma de conectarse a la BD
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BreweryNew> sacarTodasBreweryNew(){
        List<BreweryNew> listaBreweryNew = jdbcTemplate.query("SELECT * FROM brewery_new", new BreweryNewRowMapper());
        return listaBreweryNew;
    }

    public BreweryNew sacaBreweryNewPorId(int id){
        // para rellenar un prepared statement con datos para una query pon los datos al final del método en orden y separados por comas
        List<BreweryNew> listaBreweryNew = jdbcTemplate.query("SELECT * FROM brewery_new b WHERE b.id = ?", new BreweryNewRowMapper(), id);
        // if comprimido si la lista sale vacía devolver null, si tiene una o más ocurrencias (no debería) devuelve la primera
        return (listaBreweryNew.isEmpty())?null: listaBreweryNew.get(0);
    }

    public void insertarBreweryNew(BreweryNew breweryNew){
        jdbcTemplate.update("INSERT INTO brewery_new (nombre) VALUES (?)", breweryNew.getNombre());
    }

    public void eliminarBreweryNew(BreweryNew breweryNew){
        jdbcTemplate.update("DELETE FROM brewery_new WHERE id = ?", breweryNew.getId());
    }

    public void actualizarBreweryNew(BreweryNew breweryNew){
        jdbcTemplate.update("UPDATE brewery_new SET nombre = ? WHERE id = ?", breweryNew.getNombre(), breweryNew.getId());
    }
}
