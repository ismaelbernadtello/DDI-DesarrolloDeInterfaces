package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class objetoExamenRowMapper implements RowMapper<objetoExamen> {

    @Override
    public objetoExamen mapRow(ResultSet rs, int rowNum) throws SQLException {
        objetoExamen objetoExamen = new objetoExamen();
        objetoExamen.setNombre(rs.getString("nombre"));
        objetoExamen.setNumero1(rs.getInt("numero1"));
        objetoExamen.setNumero2(rs.getInt("numero2"));
        objetoExamen.setFecha(rs.getDate("fecha"));
        return objetoExamen;
    }
}