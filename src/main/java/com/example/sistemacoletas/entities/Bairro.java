package com.example.sistemacoletas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bairro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bairro_id")
    private Integer id;

    @Column(name = "bairro_nome", length = 45)
    private String nome;

    @Column(name = "bairro_status", length = 45)
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_cidade_id")
    private Cidade cidade;

}

