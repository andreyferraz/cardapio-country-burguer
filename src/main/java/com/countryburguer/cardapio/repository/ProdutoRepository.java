package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

    List<Produto> findAll();

}
