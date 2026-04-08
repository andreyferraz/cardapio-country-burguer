package com.countryburguer.cardapio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryburguer.cardapio.model.Adicional;
import com.countryburguer.cardapio.repository.AdicionalRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class AdicionalService {

	private static final String MSG_ID_ADICIONAL_OBRIGATORIO = "ID do adicional";
	private static final String MSG_ADICIONAL_NAO_ENCONTRADO = "Adicional nao encontrado para o ID informado.";

	private final AdicionalRepository adicionalRepository;

	public AdicionalService(AdicionalRepository adicionalRepository) {
		this.adicionalRepository = adicionalRepository;
	}

	@Transactional(readOnly = true)
	public List<Adicional> listarTodos() {
		return adicionalRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Adicional> listarPorProduto(UUID produtoId) {
		ValidationUtils.validarCampoObrigatorio(produtoId, "ID do produto");
		return adicionalRepository.findAllByProdutoId(produtoId);
	}

	@Transactional(readOnly = true)
	public Adicional buscarPorId(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ADICIONAL_OBRIGATORIO);
		return adicionalRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_ADICIONAL_NAO_ENCONTRADO));
	}

	@Transactional
	public Adicional criar(Adicional adicional) {
		validarAdicional(adicional);

		if (adicional.getId() == null) {
			adicional.setId(UUID.randomUUID());
		}

		return adicionalRepository.save(adicional);
	}

	@Transactional
	public Adicional atualizar(UUID id, Adicional adicional) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ADICIONAL_OBRIGATORIO);
		validarAdicional(adicional);

		Adicional existente = adicionalRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_ADICIONAL_NAO_ENCONTRADO));

		existente.setProdutoId(adicional.getProdutoId());
		existente.setNome(adicional.getNome().trim());
		existente.setPreco(adicional.getPreco());
		existente.setAtivo(adicional.getAtivo());

		return adicionalRepository.save(existente);
	}

	@Transactional
	public void remover(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ADICIONAL_OBRIGATORIO);

		if (!adicionalRepository.existsById(id)) {
			throw new IllegalArgumentException(MSG_ADICIONAL_NAO_ENCONTRADO);
		}

		adicionalRepository.deleteById(id);
	}

	private void validarAdicional(Adicional adicional) {
		ValidationUtils.validarCampoObrigatorio(adicional, "Adicional");
		ValidationUtils.validarCampoStringObrigatorio(adicional.getNome(), "Nome do adicional");
		ValidationUtils.validarCampoObrigatorio(adicional.getPreco(), "Preco do adicional");
		ValidationUtils.validarCampoObrigatorio(adicional.getAtivo(), "Status ativo do adicional");

		if (adicional.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Preco do adicional nao pode ser negativo.");
		}

		if (adicional.getAtivo() != 0 && adicional.getAtivo() != 1) {
			throw new IllegalArgumentException("Campo ativo deve ser 0 (inativo) ou 1 (ativo).");
		}

		adicional.setNome(adicional.getNome().trim());
	}

}
