package com.example.sistemacoletas.controller;

import com.example.sistemacoletas.entities.Selo;
import com.example.sistemacoletas.service.SeloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selos")
public class SeloController {

    @Autowired
    private SeloService seloService;

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok(seloService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(seloService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Selo selo){
        return ResponseEntity.ok(seloService.salvar(selo));
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody Selo selo){
        return ResponseEntity.ok(seloService.atualizar(selo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        seloService.deletar(id);
        return ResponseEntity.ok().build();
    }

}