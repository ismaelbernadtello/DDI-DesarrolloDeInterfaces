
package Paquete.Repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Paquete.Modelos.Beer;

class BeerRowMapper implements RowMapper<Beer>{

    @Override
    public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
        //creamos un nuevo objeto de la clase beer en el que descargar los datos de la fila
        Beer beer = new Beer();
        // los datos se sacan de una fila con el ResultSet (rs) usando los métodos getInt, getString...
        // se usa el nombre en la BD para sacar cada campo
        beer.setId(rs.getInt("id"));
        beer.setNombre(rs.getString("nombre"));
        beer.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
        beer.setCodigoBreweryNew(rs.getInt("brewery_new"));
        beer.setCodigoBreweryOld(rs.getInt("brewery_old"));
        return beer;new BeerModel()
    }
    

}