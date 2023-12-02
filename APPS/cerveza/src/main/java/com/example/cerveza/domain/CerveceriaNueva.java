package com.example.cerveza.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity //Indica que esta clase es una entidad JPA (se almacenará en la base de datos)
@Table(name = "CERVECERIA_NUEVA") // Indica el nombre de la tabla en la base de datos
@Data // Esta anotación de Lombok genera automáticamente getters, setters, toString, equals y hashCode
public class CerveceriaNueva {

    @Id // Indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de la clave primaria se genera automáticamente
    private Long id; // Atributo que representa la clave primaria

    @Column(name = "nombre") // Indica el nombre de la columna en la base de datos
    private String nombre; 

    // Indica que este atributo es una relación uno a muchos con la entidad Cerveza (un cervecero puede tener muchas cervezas)
    // mappedBy indica que el atributo cerveceriaNueva en la clase Cerveza es el dueño de la relación
    // cascade indica que cuando se elimine una cerveceriaNueva, se eliminarán todas las cervezas asociadas
    @OneToMany(mappedBy = "cerveceriaNueva", cascade = CascadeType.ALL) 
    private List<Cerveza> cervezas;

    
}
