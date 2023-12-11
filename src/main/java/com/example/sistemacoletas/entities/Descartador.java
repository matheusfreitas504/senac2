package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "descartador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descartador {

    @Id
    @Column(name = "descartador_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
