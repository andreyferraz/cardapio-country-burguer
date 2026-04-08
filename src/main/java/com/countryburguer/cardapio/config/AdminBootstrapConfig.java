package com.countryburguer.cardapio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.countryburguer.cardapio.service.AdminUsuarioService;

@Configuration
public class AdminBootstrapConfig {

    @Bean
    CommandLineRunner adminBootstrapRunner(
            AdminUsuarioService adminUsuarioService,
            @Value("${admin.bootstrap.username:admin}") String adminUsername,
            @Value("${admin.bootstrap.password:admin123}") String adminPassword) {
        return args -> adminUsuarioService.criarAdminSeNaoExistir(adminUsername, adminPassword);
    }
}
