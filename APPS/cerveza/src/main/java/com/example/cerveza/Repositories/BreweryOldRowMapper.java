package com.example.cerveza.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

//Importamos el modelo de Brewery0ld para poder usarlo en el método mapRow
import com.example.cerveza.Models.BreweryOldModel;


public class BreweryOldRowMapper implements RowMapper<BreweryOldModel>{

    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public BreweryOldModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Se devuelve un nuevo objeto de la clase BreweryOldModel con los datos de la fila
        BreweryOldModel modeloBreweryOld = new BreweryOldModel();
        modeloBreweryOld.setId(rs.getInt("id")); //Se usa el nombre en la BD para sacar cada campo
        modeloBreweryOld.setNombre(rs.getString("nombre"));

        return modeloBreweryOld;
    }
}