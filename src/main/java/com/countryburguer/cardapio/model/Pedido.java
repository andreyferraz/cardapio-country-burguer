package com.countryburguer.cardapio.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table("pedido")
public class Pedido {

    @Id
    private UUID id;

    @Column("nome_cliente")
    private String nomeCliente;

    @Column("telefone_cliente")
    private String telefoneCliente;

    @Column("endereco_cliente")
    private String enderecoCliente;

    private String observacoes;

    @Column("valor_total")
    private BigDecimal valorTotal;

    @Column("data_pedido")
    private LocalDate dataPedido;

}
