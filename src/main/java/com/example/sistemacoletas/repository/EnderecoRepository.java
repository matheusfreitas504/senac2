package com.example.sistemacoletas.repository;


import com.example.sistemacoletas.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}