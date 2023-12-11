package com.example.sistemacoletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.example.sistemacoletas.entities.Estado;
import com.example.sistemacoletas.service.EstadoService;


@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estado> getEstadoById(@PathVariable Integer id) {
        return estadoService.findById(id);
    }

    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoService.save(estado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Integer id, @RequestBody Estado estado) {
        Optional<Estado> estadoExistente = estadoService.findById(id);
        if (estadoExistente.isPresent()) {
            estado.setId(id);
            Estado estadoAtualizado = estadoService.save(estado);
            return ResponseEntity.ok(estadoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
