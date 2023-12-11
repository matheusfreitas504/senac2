package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @Column(name = "notificacao_id")
    private Long id;

    @Column(name = "notificacao_texto", columnDefinition = "TEXT")
    private String texto;

    @Column(name = "notificacao_data")
    private LocalDateTime data;

    @Column(name = "notificacao_status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_receptor_id")
    private Usuario usuarioReceptor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_notificador_id")
    private Usuario usuarioNotificador;
}

