package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_selo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSelo {

    @Id
    @Column(name = "usuario_selo_id")
    private Long id;

    @Column(name = "usuario_selo_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "selo_id")
    private Selo selo;
}