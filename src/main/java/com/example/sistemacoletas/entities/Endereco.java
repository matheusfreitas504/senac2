package com.example.sistemacoletas.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @Column(name = "endereco_place_id", length = 45)
    private String placeId;

    @Column(name = "endereco_rua", length = 45)
    private String rua;

    @Column(name = "endereco_numero", length = 45)
    private String numero;

    @Column(name = "endereco_complemento", length = 45)
    private String complemento;

    @Column(name = "endereco_cep", length = 8)
    private String cep;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bairro_id")
    private Bairro bairro;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    private Estado estado;
}