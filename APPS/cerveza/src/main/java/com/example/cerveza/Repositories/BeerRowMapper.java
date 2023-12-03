package com.example.cerveza.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.AbstractDocument.BranchElement;

//Importamos la libreria de jdbc para poder usar RowMapper
import org.springframework.jdbc.core.RowMapper;

//Importamos el modelo de BeerModel para poder usarlo en el método mapRow
import com.example.cerveza.Models.BeerModel;
import com.example.cerveza.Models.BreweryNewModel;
import com.example.cerveza.Models.BreweryOldModel;


public class BeerRowMapper implements RowMapper<BeerModel>{

    //Override se pone para sobreescribir el método mapRow por defecto
    @Override
    public BeerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        BreweryNewModel breweryNew = new BreweryNewModel();
        BreweryOldModel breweryOld = new BreweryOldModel();

        //Creamos dos objetos de tipo BreweryNewModel y BreweryOldModel para poder acceder a sus atributos desde la vista
        if(rs.getString("Nombre_NEW") != null){
            breweryNew.setId(rs.getInt("brewery_new"));
            breweryNew.setNombre(rs.getString("Nombre_NEW"));
            breweryOld.setId(0);
            breweryOld.setNombre("");
        }
        else{
            breweryOld.setId(rs.getInt("brewery_old")); 
            breweryOld.setNombre(rs.getString("Nombre_OLD"));
            breweryNew.setId(0);
            breweryNew.setNombre("");
        }

        //Se devuelve un nuevo objeto de la clase Beer con los datos de la fila
        BeerModel modeloBeer = new BeerModel();
        modeloBeer.setBreweryNew(breweryNew);
        modeloBeer.setBreweryOld(breweryOld);
        modeloBeer.setId(rs.getInt("id")); //Se usa el nombre en la BD para sacar cada campo
        modeloBeer.setNombre(rs.getString("nombre"));
        modeloBeer.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
        modeloBeer.setCodigoBreweryNew(rs.getInt("brewery_new"));
        modeloBeer.setCodigoBreweryOld(rs.getInt("brewery_old"));

        return modeloBeer;
    }
}