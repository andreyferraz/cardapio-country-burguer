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
@Table("produto")
public class Produto {

    @Id
    private UUID id;

    @Column("categoria_id")
    private UUID categoriaId;

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private BigDecimal preco;

    @Column("imagem_url")
    private String imagemUrl;
    
    @NotNull
    private Integer ativo;

}
