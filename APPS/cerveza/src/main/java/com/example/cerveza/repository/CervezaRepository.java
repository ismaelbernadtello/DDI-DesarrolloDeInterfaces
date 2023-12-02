package com.example.cerveza.repository;

import com.example.cerveza.domain.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz hereda de JpaRepository, que contiene métodos para realizar operaciones CRUD sobre la base de datos
// El primer parámetro es el tipo de la entidad (Cerveza) y el segundo es el tipo de la clave primaria (Long)
//Las operaciones CRUD son: Create, Read, Update, Delete
public interface CervezaRepository extends JpaRepository<Cerveza, Long> {

}
