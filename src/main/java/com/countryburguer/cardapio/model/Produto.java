package com.countryburguer.cardapio.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("produto")
public class Produto {

    @Id
    private UUID id;

    @Column("categoria_id")
    private UUID categoriaId;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private String imagemUrl;
    
    private Integer ativo;

}
