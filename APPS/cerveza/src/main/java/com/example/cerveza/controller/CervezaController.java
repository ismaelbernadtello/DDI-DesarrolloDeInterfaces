package com.example.cerveza.controller;

import com.example.cerveza.domain.Cerveza;
import com.example.cerveza.domain.CerveceriaAntigua;
import com.example.cerveza.domain.CerveceriaNueva;
import com.example.cerveza.repository.CervezaRepository;
import com.example.cerveza.repository.CerveceriaAntiguaRepository;
import com.example.cerveza.repository.CerveceriaNuevaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Indica que esta clase es un controlador de Spring MVC
@RequestMapping("/cervezas") // Todas las rutas de este controlador empiezan con /cervezas (ej: /cervezas/listar)
public class CervezaController {

    private final CervezaRepository cervezaRepository;
    private final CerveceriaAntiguaRepository cerveceriaAntiguaRepository;
    private final CerveceriaNuevaRepository cerveceriaNuevaRepository;

    @Autowired
    public CervezaController(CervezaRepository cervezaRepository,
                            CerveceriaAntiguaRepository cerveceriaAntiguaRepository,
                            CerveceriaNuevaRepository cerveceriaNuevaRepository) {
        this.cervezaRepository = cervezaRepository;
        this.cerveceriaAntiguaRepository = cerveceriaAntiguaRepository;
        this.cerveceriaNuevaRepository = cerveceriaNuevaRepository;
    }

    @GetMapping("/listar")
    public String listarCervezas(Model model) {
        Iterable<Cerveza> cervezas = cervezaRepository.findAll();
        model.addAttribute("cervezas", cervezas);
        return "cerveza/listar";  // Nombre de la plantilla Thymeleaf (listar.html)
    }

    @GetMapping("/agregar")
    public String mostrarFormulario(Model model) {
        Iterable<CerveceriaAntigua> cerveceriasAntiguas = cerveceriaAntiguaRepository.findAll();
        Iterable<CerveceriaNueva> cerveceriasNuevas = cerveceriaNuevaRepository.findAll();
        
        model.addAttribute("cerveceriasAntiguas", cerveceriasAntiguas);
        model.addAttribute("cerveceriasNuevas", cerveceriasNuevas);
        model.addAttribute("cerveza", new Cerveza());
        
        return "cerveza/agregar";  // Nombre de la plantilla Thymeleaf (agregar.html)
    }

    @PostMapping("/agregar")
    public String agregarCerveza(@ModelAttribute Cerveza cerveza) {
        // Lógica para agregar una nueva cerveza
        cervezaRepository.save(cerveza);
        return "redirect:/cervezas/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCerveza(@PathVariable Long id) {
        // Lógica para eliminar una cerveza por su ID
        cervezaRepository.deleteById(id);
        return "redirect:/cervezas/listar";
    }
}
