package com.example.sistemacoletas.entities;


import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "usuario_email_login", length = 45)
    private String emailLogin;

    @Column(name = "usuario_nome", length = 250)
    private String nome;

    @Column(name = "usuario_telefone", length = 15)
    private String telefone;

    @Column(columnDefinition = "LONGBLOB", name = "usuario_foto")
    private byte[] foto;

    @Column(name = "usuario_cpf", length = 11)
    private String cpf;

    @Column(name = "usuario_cnpj", length = 15)
    private String cnpj;

    @Column(name = "usuario_senha", length = 45)
    private String senha;

    @Column(name = "usuario_status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_tipo_id")
    private UsuarioTipo usuarioTipo;

}