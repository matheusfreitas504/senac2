package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsuarioEndereco {

    @Id
    @Column(name = "usuario_endereco_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}