package Paquete.Modelos;

public class BreweryOld {
    private int id;
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
    private String nombre;

    
    public BreweryOld(){

    }
    public BreweryOld(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
}
