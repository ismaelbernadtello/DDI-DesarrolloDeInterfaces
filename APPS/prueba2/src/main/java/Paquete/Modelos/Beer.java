package Paquete.Modelos;

import java.util.Date;

public class Beer {
    private int id;
    private String nombre;
    private Date fechaLanzamiento;
    private BreweryNew breweryNew;
    private BreweryOld breweryOld;
    private int codigoBreweryNew;
    private int codigoBreweryOld;
    public int getCodigoBreweryNew() {
        return codigoBreweryNew;
    }
    public void setCodigoBreweryNew(int codigoBreweryNew) {
        this.codigoBreweryNew = codigoBreweryNew;
    }
    public int getCodigoBreweryOld() {
        return codigoBreweryOld;
    }
    public void setCodigoBreweryOld(int codigoBreweryOld) {
        this.codigoBreweryOld = codigoBreweryOld;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public BreweryNew getBreweryNew() {
        return breweryNew;
    }
    public void setBreweryNew(BreweryNew breweryNew) {
        this.breweryNew = breweryNew;
    }
    public BreweryOld getBreweryOld() {
        return breweryOld;
    }
    public void setBreweryOld(BreweryOld breweryOld) {
        this.breweryOld = breweryOld;
    }

    
}
