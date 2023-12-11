package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "coletor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coletor {

    @Id
    @Column(name = "coletor_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}