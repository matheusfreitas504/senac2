package com.example.sistemacoletas.repository;

import com.example.sistemacoletas.entities.UsuarioEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEndereco, Long> {
    UsuarioEndereco findByUsuarioUsuarioId(Long usuarioId);
}
