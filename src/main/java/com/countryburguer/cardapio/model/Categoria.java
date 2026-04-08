package com.countryburguer.cardapio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("categoria")
public class Categoria {

    @Id 
    private UUID id;

    @NotNull
    private String nome;

    @Column("ordem_exibicao")
    @NotNull
    private Integer ordemExibicao;

}
