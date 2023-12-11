package com.example.sistemacoletas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "selo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Selo {

    @Id
    @Column(name = "selo_id")
    private Long id;

    @Column(name = "selo_nome", length = 45)
    private String nome;

    @Column(name = "selo_descricao", length = 300)
    private String descricao;

    @Column(columnDefinition = "LONGBLOB", name = "selo_imagem")
    private byte[] seloImagem;

    @Column(name = "selo_status")
    private Integer status;
}
