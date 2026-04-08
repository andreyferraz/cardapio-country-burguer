package com.countryburguer.cardapio.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryburguer.cardapio.model.Categoria;
import com.countryburguer.cardapio.repository.CategoriaRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class CategoriaService {

	private static final String MSG_ID_CATEGORIA_OBRIGATORIO = "ID da categoria";
	private static final String MSG_CATEGORIA_NAO_ENCONTRADA = "Categoria nao encontrada para o ID informado.";

	private final CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Transactional(readOnly = true)
	public List<Categoria> listarTodas() {
		return categoriaRepository.findAllByOrderByOrdemExibicaoAsc();
	}

	@Transactional(readOnly = true)
	public Categoria buscarPorId(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_CATEGORIA_OBRIGATORIO);
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_CATEGORIA_NAO_ENCONTRADA));
	}

	@Transactional
	public Categoria criar(Categoria categoria) {
		validarCategoria(categoria);

		if (categoria.getId() == null) {
			categoria.setId(UUID.randomUUID());
		}

		return categoriaRepository.save(categoria);
	}

	@Transactional
	public Categoria atualizar(UUID id, Categoria categoria) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_CATEGORIA_OBRIGATORIO);
		validarCategoria(categoria);

		Categoria existente = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_CATEGORIA_NAO_ENCONTRADA));

		existente.setNome(categoria.getNome().trim());
		existente.setOrdemExibicao(categoria.getOrdemExibicao());

		return categoriaRepository.save(existente);
	}

	@Transactional
	public void remover(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_CATEGORIA_OBRIGATORIO);

		if (!categoriaRepository.existsById(id)) {
			throw new IllegalArgumentException(MSG_CATEGORIA_NAO_ENCONTRADA);
		}

		categoriaRepository.deleteById(id);
	}

	private void validarCategoria(Categoria categoria) {
		ValidationUtils.validarCampoObrigatorio(categoria, "Categoria");
		ValidationUtils.validarCampoStringObrigatorio(categoria.getNome(), "Nome da categoria");
		ValidationUtils.validarCampoObrigatorio(categoria.getOrdemExibicao(), "Ordem de exibicao da categoria");

		if (categoria.getOrdemExibicao() < 0) {
			throw new IllegalArgumentException("Ordem de exibicao nao pode ser negativa.");
		}

		categoria.setNome(categoria.getNome().trim());
	}

}
