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
@Table("item_pedido")
public class ItemPedido {

    @Id
    private UUID id;

    @Column("pedido_id")
    private UUID pedidoId;

    @Column("produto_id")
    private UUID produtoId;

    private Integer quantidade;

    private String observacao;

    @Column("preco_unitario")
    @NotNull
    private BigDecimal precoUnitario;

}
