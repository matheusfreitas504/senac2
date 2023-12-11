package com.example.sistemacoletas.entities;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Integer id;

    @Column(name = "estado_nome", length = 45)
    private String nome;

    @Column(name = "estado_sigla", length = 45)
    private String sigla;

    @Column(name = "estado_status", length = 45)
    private int status;

}