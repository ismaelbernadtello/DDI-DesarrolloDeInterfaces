package com.example.cerveza.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

//Importamos el modelo de BreweryNew para poder usarlo en el método mapRow
import com.example.cerveza.Models.BreweryNewModel;


public class BreweryNewRowMapper implements RowMapper<BreweryNewModel>{

    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public BreweryNewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Se devuelve un nuevo objeto de la clase BreweryNewModel con los datos de la fila
        BreweryNewModel modeloBreweryNew = new BreweryNewModel();
        modeloBreweryNew.setId(rs.getInt("id")); //Se usa el nombre en la BD para sacar cada campo
        modeloBreweryNew.setNombre(rs.getString("nombre"));

        return modeloBreweryNew;
    }
}