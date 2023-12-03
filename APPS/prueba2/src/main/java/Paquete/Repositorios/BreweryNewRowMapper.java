package Paquete.Repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Paquete.Modelos.BreweryNew;

public class BreweryNewRowMapper implements RowMapper<BreweryNew>{

    @Override
    public BreweryNew mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BreweryNew(rs.getInt("id"), rs.getString("nombre"));
    }
    
}
