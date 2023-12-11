package com.example.sistemacoletas.controller;

import com.example.sistemacoletas.entities.UsuarioSelo;
import com.example.sistemacoletas.service.UsuarioSeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarioselos")
public class UsuarioSeloController {

    private final UsuarioSeloService usuarioSeloService;

    @Autowired
    public UsuarioSeloController(UsuarioSeloService usuarioSeloService) {
        this.usuarioSeloService = usuarioSeloService;
    }

    @GetMapping
    public List<UsuarioSelo> getAll() {
        return usuarioSeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSelo> getById(@PathVariable Long id) {
        return usuarioSeloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioSelo create(@RequestBody UsuarioSelo usuarioSelo) {
        return usuarioSeloService.save(usuarioSelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSelo> update(@PathVariable Long id, @RequestBody UsuarioSelo usuarioSelo) {
        return usuarioSeloService.findById(id)
                .map(existingUsuarioSelo -> {
                    usuarioSelo.setId(id);
                    return ResponseEntity.ok(usuarioSeloService.save(usuarioSelo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!usuarioSeloService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioSeloService.delete(id);
        return ResponseEntity.ok().build();
    }
}
