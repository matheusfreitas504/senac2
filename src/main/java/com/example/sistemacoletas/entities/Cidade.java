package com.example.sistemacoletas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidade_id")
    private Integer id;

    @Column(name = "cidade_nome", length = 45)
    private String nome;

    @Column(name = "cidade_status", length = 45)
    private String status;

    // Relacionamento com Estado
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_estado_id")
    private Estado estado;

}