package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.Adicional;

public interface AdicionalRepository extends CrudRepository<Adicional, UUID> {

    List<Adicional> findAll();

    List<Adicional> findAllByProdutoId(UUID produtoId);

}
