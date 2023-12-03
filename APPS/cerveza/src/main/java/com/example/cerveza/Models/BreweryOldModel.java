package com.example.cerveza.Models;

//Importamos las librerias de lombok para no tener que escribir getters y setters
import lombok.Setter;
import lombok.Getter;

//Usamos las anotaciones de lombok para que nos genere los getters y setters
@Getter
@Setter

public class BreweryOldModel { // Creamos la clase BreweryOldModel con sus atributos, que son los mismos que los de la tabla de la base de datos
    private int id;
    private String nombre;

}
