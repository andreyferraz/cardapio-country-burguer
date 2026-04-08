package com.countryburguer.cardapio.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("admin_usuario")
public class AdminUsuario {

    @Id
    private UUID id;

    @NotNull
    private String username;

    @NotNull
    @Column("senha_hash")
    private String senhaHash;

    @NotNull
    private String role;

    @NotNull
    private Integer ativo;

    @NotNull
    @Column("created_at")
    private LocalDateTime createdAt;
}
