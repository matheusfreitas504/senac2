package com.example.sistemacoletas.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_tipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_tipo_id")
    private Long id;

    @Column(name = "usuario_tipo_descricao", length = 45)
    private String descricao;

    @Column(name = "usuario_tipo_status", length = 45)
    private String status;
}