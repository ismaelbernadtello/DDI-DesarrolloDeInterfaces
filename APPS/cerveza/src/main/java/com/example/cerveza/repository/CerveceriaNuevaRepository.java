package com.example.cerveza.repository;

import com.example.cerveza.domain.CerveceriaNueva;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz hereda de JpaRepository, que contiene métodos para realizar operaciones CRUD sobre la base de datos
// El primer parámetro es el tipo de la entidad (CerveceriaNueva) y el segundo es el tipo de la clave primaria (Long)
//Las operaciones CRUD son: Create, Read, Update, Delete
public interface CerveceriaNuevaRepository extends JpaRepository<CerveceriaNueva, Long> {
    
}
