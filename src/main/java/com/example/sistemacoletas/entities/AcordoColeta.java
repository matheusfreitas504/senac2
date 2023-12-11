package com.example.sistemacoletas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "acordo_coleta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcordoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acordo_coleta_id")
    private Long id;

    @Column(name = "acordo_coleta_data_solicitacao")
    private LocalDateTime dataSolicitacao;

    @Column(name = "acordo_coleta_data_coleta")
    private LocalDateTime dataColeta;

    @Column(name = "acordo_coleta_status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "coletor_id")
    private Coletor coletor;
}
