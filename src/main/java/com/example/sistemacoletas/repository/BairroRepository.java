package com.example.sistemacoletas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sistemacoletas.entities.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

}
