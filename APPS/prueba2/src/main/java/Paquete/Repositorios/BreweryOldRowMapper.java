package Paquete.Repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Paquete.Modelos.BreweryOld;

public class BreweryOldRowMapper implements RowMapper<BreweryOld>{

    @Override
    public BreweryOld mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BreweryOld(rs.getInt("id"), rs.getString("nombre"));
    }
    
}
