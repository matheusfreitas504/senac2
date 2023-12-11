package com.example.sistemacoletas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.sistemacoletas.entities.Bairro;
import com.example.sistemacoletas.repository.BairroRepository;

@Service
public class BairroService {

    private final BairroRepository bairroRepository;

    @Autowired
    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Optional<Bairro> findById(Integer id) {
        return bairroRepository.findById(id);
    }

    public Bairro save(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public Bairro update(Bairro bairro) {
        return bairroRepository.save(bairro);
    }
}


