package com.example.cerveza.domain;

import javax.persistence.*;

import lombok.Data;
import java.util.Date;

@Entity //Indica que esta clase es una entidad JPA (se almacenará en la base de datos)
@Table(name = "CERVEZA") // Indica el nombre de la tabla en la base de datos
@Data // Esta anotación de Lombok genera automáticamente getters, setters, toString, equals y hashCode

public class Cerveza {// Clase que representa una cerveza

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @ManyToOne
    @JoinColumn(name = "cerveceria_antigua_id")
    private CerveceriaAntigua cerveceriaAntigua;

    @ManyToOne
    @JoinColumn(name = "cerveceria_nueva_id")
    private CerveceriaNueva cerveceriaNueva;

    
    // Constructores
    public Cerveza() {
        // Constructor vacío necesario para JPA
    }

    public Cerveza(String nombre, Date fechaLanzamiento, CerveceriaAntigua cerveceriaAntigua, CerveceriaNueva cerveceriaNueva) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cerveceriaAntigua = cerveceriaAntigua;
        this.cerveceriaNueva = cerveceriaNueva;
    }

    
}
