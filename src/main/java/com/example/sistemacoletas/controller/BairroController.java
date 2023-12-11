package com.example.sistemacoletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sistemacoletas.entities.Bairro;
import com.example.sistemacoletas.service.BairroService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bairros")
public class BairroController {

    private final BairroService bairroService;

    @Autowired
    public BairroController(BairroService bairroService) {
        this.bairroService = bairroService;
    }

    @GetMapping
    public ResponseEntity<List<Bairro>> getAllBairros() {
        return ResponseEntity.ok(bairroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bairro> getBairroById(@PathVariable Integer id) {
        Optional<Bairro> bairro = bairroService.findById(id);
        return bairro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bairro> createBairro(@RequestBody Bairro bairro) {
        Bairro novoBairro = bairroService.save(bairro);
        return ResponseEntity.ok(novoBairro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bairro> updateBairro(@PathVariable Integer id, @RequestBody Bairro bairro) {
        return bairroService.findById(id)
                .map(bairroExistente -> {
                    bairro.setId(id);
                    Bairro bairroAtualizado = bairroService.update(bairro);
                    return ResponseEntity.ok(bairroAtualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
