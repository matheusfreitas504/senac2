package com.example.sistemacoletas.service;

import com.example.sistemacoletas.entities.UsuarioEndereco;
import com.example.sistemacoletas.repository.UsuarioEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEnderecoService {

    private final UsuarioEnderecoRepository usuarioEnderecoRepository;

    @Autowired
    public UsuarioEnderecoService(UsuarioEnderecoRepository usuarioEnderecoRepository) {
        this.usuarioEnderecoRepository = usuarioEnderecoRepository;
    }

    public List<UsuarioEndereco> findAll() {
        return usuarioEnderecoRepository.findAll();
    }

    public Optional<UsuarioEndereco> findById(Long id) {
        return usuarioEnderecoRepository.findById(id);
    }

    public UsuarioEndereco save(UsuarioEndereco usuarioEndereco) {
        return usuarioEnderecoRepository.save(usuarioEndereco);
    }

    public UsuarioEndereco update(UsuarioEndereco usuarioEndereco) {
        return usuarioEnderecoRepository.save(usuarioEndereco);
    }

}
