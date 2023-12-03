package com.example.cerveza.Models;
import java.util.Date;

//Importamos las librerias de lombok para no tener que escribir getters y setters
import lombok.Setter;
import lombok.Getter;

//Usamos las anotaciones de lombok para que nos genere los getters y setters
@Getter
@Setter

public class BeerModel { //Creamos la clase BeerModel con sus atributos, que son los mismos que los de la tabla de la base de datos
    private int id;
    private String nombre;
    private Date fechaLanzamiento;
    private int codigoBreweryNew;
    private int codigoBreweryOld;

}