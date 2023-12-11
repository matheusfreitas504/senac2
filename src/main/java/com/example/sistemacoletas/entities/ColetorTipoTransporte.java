package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "coletor_tipo_transporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColetorTipoTransporte {

    @Id
    @Column(name = "coletor_tipo_transporte_id")
    private Long id;

    @Column(name = "coletor_tipo_transporte_descricao", length = 100)
    private String descricao;

    @Column(name = "coletor_tipo_transporte_capacidade")
    private Integer capacidade;

    @Column(name = "coletor_tipo_transporte_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coletor_id")
    private Coletor coletor;
}