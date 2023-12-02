package com.example.cerveza.service;

import com.example.cerveza.domain.Cerveza;
import com.example.cerveza.repository.CervezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio de Spring
public class CervezaService {

    private final CervezaRepository cervezaRepository;

    @Autowired // Inyección de dependencias por constructor (constructor injection) de Spring (no es necesario el constructor)
    public CervezaService(CervezaRepository cervezaRepository) {
        this.cervezaRepository = cervezaRepository;
    }

    public List<Cerveza> getAllCervezas() { // Método que devuelve todas las cervezas
        return cervezaRepository.findAll();
    }

    public Optional<Cerveza> getCervezaById(Long id) { // Método que devuelve una cerveza por su ID (si existe)
        return cervezaRepository.findById(id);
    }

    public Cerveza saveCerveza(Cerveza cerveza) { // Método que guarda una cerveza en la base de datos
        return cervezaRepository.save(cerveza);
    }

    public void deleteCerveza(Long id) { // Método que elimina una cerveza por su ID de la base de datos
        cervezaRepository.deleteById(id);
    }
}
