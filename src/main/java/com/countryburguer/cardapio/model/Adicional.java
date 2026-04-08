package com.countryburguer.cardapio.model;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("adicional")
public class Adicional {

    @Id
    private UUID id;

    @Column("produto_id")
    private UUID produtoId;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal preco;
    
    @NotNull
    private Integer ativo;

}
