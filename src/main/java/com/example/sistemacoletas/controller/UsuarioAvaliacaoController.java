package com.example.sistemacoletas.controller;

import com.example.sistemacoletas.entities.UsuarioAvaliacao;
import com.example.sistemacoletas.service.UsuarioAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/usuarioAvaliacao")
public class UsuarioAvaliacaoController {

    private final UsuarioAvaliacaoService service;

    @Autowired
    public UsuarioAvaliacaoController(UsuarioAvaliacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioAvaliacao> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAvaliacao> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioAvaliacao create(@RequestBody UsuarioAvaliacao usuarioAvaliacao) {
        return service.save(usuarioAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAvaliacao> update(@PathVariable Long id, @RequestBody UsuarioAvaliacao usuarioAvaliacao) {
        return service.findById(id)
                .map(existingUser -> {
                    usuarioAvaliacao.setId(id);
                    return ResponseEntity.ok(service.save(usuarioAvaliacao));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(usuarioAvaliacao -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}