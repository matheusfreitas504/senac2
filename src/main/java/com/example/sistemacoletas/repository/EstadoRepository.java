package com.example.sistemacoletas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sistemacoletas.entities.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
