package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HolaRowMapper implements RowMapper<Hola> {

    @Override // lo que hace esto es mapear la estructura de la tabla para que luego podamos
              // trabajar con ella
    public Hola mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hola Hola = new Hola();
        Hola.setId(rs.getInt("id"));
        Hola.setNombre(rs.getString("nombre"));
        Hola.setEmail(rs.getString("email"));
        Hola.setContracena(rs.getString("contracena"));
        Hola.setRol(rs.getString("rol"));
        return Hola;
    }

}
