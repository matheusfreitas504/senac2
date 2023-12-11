package com.example.sistemacoletas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.sistemacoletas.entities.Cidade;
import com.example.sistemacoletas.service.CidadeService;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> getAllCidades() {
        return ResponseEntity.ok(cidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable Integer id) {
        Optional<Cidade> cidade = cidadeService.findById(id);
        return cidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade) {
        Cidade novaCidade = cidadeService.save(cidade);
        return ResponseEntity.ok(novaCidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> updateCidade(@PathVariable Integer id, @RequestBody Cidade cidade) {
        return cidadeService.findById(id)
                .map(cidadeExistente -> {
                    cidade.setId(id);
                    Cidade cidadeAtualizada = cidadeService.update(cidade);
                    return ResponseEntity.ok(cidadeAtualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
