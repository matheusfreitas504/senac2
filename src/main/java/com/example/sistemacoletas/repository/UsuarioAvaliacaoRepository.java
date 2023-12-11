package com.example.sistemacoletas.repository;
import com.example.sistemacoletas.entities.UsuarioAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAvaliacaoRepository extends JpaRepository<UsuarioAvaliacao, Long> {
    // Custom query methods can be added here
}
