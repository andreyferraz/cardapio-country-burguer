package com.countryburguer.cardapio.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, UUID> {

    List<Categoria> findAll();

}
