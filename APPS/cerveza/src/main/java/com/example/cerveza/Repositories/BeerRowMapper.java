package com.example.cerveza.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

//Importamos el modelo de BeerModel para poder usarlo en el método mapRow
import com.example.cerveza.Models.BeerModel;
import com.example.cerveza.Models.BreweryNewModel;


public class BeerRowMapper implements RowMapper<BeerModel>{

    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public BeerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Se devuelve un nuevo objeto de la clase Beer con los datos de la fila
        BeerModel modeloBeer = new BeerModel();
        modeloBeer.setId(rs.getInt("id")); //Se usa el nombre en la BD para sacar cada campo
        modeloBeer.setNombre(rs.getString("nombre"));
        modeloBeer.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
        modeloBeer.setCodigoBreweryNew(rs.getInt("brewery_new"));
        modeloBeer.setCodigoBreweryOld(rs.getInt("brewery_old"));

        return modeloBeer;
    }
}