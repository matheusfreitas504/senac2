package com.example.sistemacoletas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.sistemacoletas.entities.Cidade;
import com.example.sistemacoletas.repository.CidadeRepository;


@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> findById(Integer id) {
        return cidadeRepository.findById(id);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade update(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
