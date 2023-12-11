package com.example.sistemacoletas.service;

import com.example.sistemacoletas.entities.Endereco;
import com.example.sistemacoletas.entities.Estado;
import com.example.sistemacoletas.entities.UsuarioEndereco;
import com.example.sistemacoletas.repository.EnderecoRepository;
import com.example.sistemacoletas.repository.UsuarioEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final UsuarioEnderecoRepository usuarioEnderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, UsuarioEnderecoRepository usuarioEnderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        this.usuarioEnderecoRepository = usuarioEnderecoRepository;
    }

    public List<Endereco> findAllEnderecosByUsuarioId(Long usuarioId) {
        List<UsuarioEndereco> usuarioEnderecos = usuarioEnderecoRepository.findAllById(Collections.singleton(usuarioId));
        return usuarioEnderecos.stream()
                .map(UsuarioEndereco::getEndereco)
                .collect(Collectors.toList());
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveOrUpdateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
