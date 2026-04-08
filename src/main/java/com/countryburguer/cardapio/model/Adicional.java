package com.countryburguer.cardapio.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
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
    private UUID produtoId;
    private String nome;
    private BigDecimal preco;
    private Integer ativo;

}
