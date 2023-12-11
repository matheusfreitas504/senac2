package com.example.sistemacoletas.service;

import com.example.sistemacoletas.entities.UsuarioSelo;
import com.example.sistemacoletas.repository.UsuarioSeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSeloService {

    private final UsuarioSeloRepository usuarioSeloRepository;

    @Autowired
    public UsuarioSeloService(UsuarioSeloRepository usuarioSeloRepository) {
        this.usuarioSeloRepository = usuarioSeloRepository;
    }

    public List<UsuarioSelo> findAll() {
        return usuarioSeloRepository.findAll();
    }

    public Optional<UsuarioSelo> findById(Long id) {
        return usuarioSeloRepository.findById(id);
    }

    public UsuarioSelo save(UsuarioSelo usuarioSelo) {
        return usuarioSeloRepository.save(usuarioSelo);
    }

    public void delete(Long id) {
        usuarioSeloRepository.deleteById(id);
    }
}
