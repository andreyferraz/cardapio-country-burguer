package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, UUID> {

	List<Pedido> findAllByOrderByDataPedidoDesc();

}
