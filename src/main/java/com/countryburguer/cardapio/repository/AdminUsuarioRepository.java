package com.countryburguer.cardapio.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.countryburguer.cardapio.model.AdminUsuario;

public interface AdminUsuarioRepository extends CrudRepository<AdminUsuario, UUID> {

    Optional<AdminUsuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
