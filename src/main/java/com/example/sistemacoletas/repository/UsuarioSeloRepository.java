package com.example.sistemacoletas.repository;

import com.example.sistemacoletas.entities.UsuarioSelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSeloRepository extends JpaRepository<UsuarioSelo, Long> {

}