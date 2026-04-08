package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.ItemPedido;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, UUID> {

    List<ItemPedido> findAll();

    List<ItemPedido> findAllByPedidoId(UUID pedidoId);

}
