package com.example.sistemacoletas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.sistemacoletas.entities.Estado;
import com.example.sistemacoletas.repository.EstadoRepository;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> findById(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }
}
