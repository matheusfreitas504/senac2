package com.example.sistemacoletas.controller;

import com.example.sistemacoletas.entities.UsuarioEndereco;
import com.example.sistemacoletas.service.UsuarioEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuariosEnderecos")
public class UsuarioEnderecoController {

    private final UsuarioEnderecoService usuarioEnderecoService;

    @Autowired
    public UsuarioEnderecoController(UsuarioEnderecoService usuarioEnderecoService) {
        this.usuarioEnderecoService = usuarioEnderecoService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEndereco>> getAllUsuariosEnderecos() {
        List<UsuarioEndereco> usuariosEnderecos = usuarioEnderecoService.findAll();
        return ResponseEntity.ok(usuariosEnderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> getUsuarioEnderecoById(@PathVariable Long id) {
        return usuarioEnderecoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioEndereco> createUsuarioEndereco(@RequestBody UsuarioEndereco usuarioEndereco) {
        UsuarioEndereco novoUsuarioEndereco = usuarioEnderecoService.save(usuarioEndereco);
        return ResponseEntity.ok(novoUsuarioEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> updateUsuarioEndereco(@PathVariable Long id, @RequestBody UsuarioEndereco usuarioEnderecoDetails) {
        return usuarioEnderecoService.findById(id).map(usuarioEndereco -> {
            usuarioEndereco.setUsuario(usuarioEnderecoDetails.getUsuario());
            usuarioEndereco.setEndereco(usuarioEnderecoDetails.getEndereco());
            UsuarioEndereco updatedUsuarioEndereco = usuarioEnderecoService.update(usuarioEndereco);
            return ResponseEntity.ok(updatedUsuarioEndereco);
        }).orElse(ResponseEntity.notFound().build());
    }
}
