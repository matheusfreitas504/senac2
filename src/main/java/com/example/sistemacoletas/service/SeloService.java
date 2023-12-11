package com.example.sistemacoletas.service;

import com.example.sistemacoletas.entities.Selo;
import com.example.sistemacoletas.repository.SeloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeloService {

    @Autowired
    private SeloRepository seloRepository;

    public List<Selo> listarTodos(){
        return seloRepository.findAll();
    }

    public Selo buscarPorId(Long id){
        Optional<Selo> selo = seloRepository.findById(id);
        return selo.orElse(null);
    }

    public Selo salvar(Selo selo){
        return seloRepository.save(selo);
    }

    public Selo atualizar(Selo selo){
        return seloRepository.save(selo);
    }

    public void deletar(Long id){
        seloRepository.deleteById(id);
    }

}