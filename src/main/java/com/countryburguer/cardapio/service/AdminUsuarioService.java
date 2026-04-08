package com.countryburguer.cardapio.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryburguer.cardapio.model.AdminUsuario;
import com.countryburguer.cardapio.repository.AdminUsuarioRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class AdminUsuarioService implements UserDetailsService {

    private static final String ROLE_ADMIN = "ADMIN";

    private final AdminUsuarioRepository adminUsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUsuarioService(AdminUsuarioRepository adminUsuarioRepository, PasswordEncoder passwordEncoder) {
        this.adminUsuarioRepository = adminUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUsuario adminUsuario = adminUsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario admin nao encontrado."));

        boolean ativo = adminUsuario.getAtivo() != null && adminUsuario.getAtivo() == 1;

        return User.withUsername(adminUsuario.getUsername())
                .password(adminUsuario.getSenhaHash())
                .roles(adminUsuario.getRole() == null || adminUsuario.getRole().isBlank() ? ROLE_ADMIN : adminUsuario.getRole())
                .disabled(!ativo)
                .build();
    }

    @Transactional
    public AdminUsuario criarAdminSeNaoExistir(String username, String senha) {
        ValidationUtils.validarCampoStringObrigatorio(username, "Usuario admin");
        ValidationUtils.validarCampoStringObrigatorio(senha, "Senha admin");

        String usernameNormalizado = username.trim();

        return adminUsuarioRepository.findByUsername(usernameNormalizado)
                .orElseGet(() -> {
                    AdminUsuario admin = new AdminUsuario();
                    admin.setId(UUID.randomUUID());
                    admin.setUsername(usernameNormalizado);
                    admin.setSenhaHash(passwordEncoder.encode(senha));
                    admin.setRole(ROLE_ADMIN);
                    admin.setAtivo(1);
                    admin.setCreatedAt(LocalDateTime.now());
                    return adminUsuarioRepository.save(admin);
                });
    }

    @Transactional
    public void alterarSenha(String username, String novaSenha) {
        ValidationUtils.validarCampoStringObrigatorio(username, "Usuario admin");
        ValidationUtils.validarCampoStringObrigatorio(novaSenha, "Nova senha");

        AdminUsuario adminUsuario = adminUsuarioRepository.findByUsername(username.trim())
                .orElseThrow(() -> new IllegalArgumentException("Usuario admin nao encontrado."));

        adminUsuario.setSenhaHash(passwordEncoder.encode(novaSenha));
        adminUsuarioRepository.save(adminUsuario);
    }
}
