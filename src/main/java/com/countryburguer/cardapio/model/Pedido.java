package com.countryburguer.cardapio.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table("pedido")
public class Pedido {

    @Id
    private UUID id;

    @Column("nome_cliente")
    @NotNull
    private String nomeCliente;

    @Column("telefone_cliente")
    @NotNull
    private String telefoneCliente;

    @Column("endereco_cliente")
    @NotNull
    private String enderecoCliente;

    @Column("valor_total")
    @NotNull
    private BigDecimal valorTotal;

    @Column("data_pedido")
    @NotNull
    private LocalDateTime dataPedido;

}
