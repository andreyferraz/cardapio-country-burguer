package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ItemPedidoRepository extends CrudRepository<ItemPedidoRepository, UUID> {

    List<ItemPedidoRepository> findAll();

}
