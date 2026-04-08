package com.countryburguer.cardapio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.countryburguer.cardapio.model.Produto;
import com.countryburguer.cardapio.repository.ProdutoRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class ProdutoService {

	private static final String MSG_ID_PRODUTO_OBRIGATORIO = "ID do produto";
	private static final String MSG_PRODUTO_NAO_ENCONTRADO = "Produto nao encontrado para o ID informado.";
	private static final String MSG_IMAGEM_OBRIGATORIA = "Imagem do produto e obrigatoria.";

	private final ProdutoRepository produtoRepository;
	private final FileUploadService fileUploadService;

	public ProdutoService(ProdutoRepository produtoRepository, FileUploadService fileUploadService) {
		this.produtoRepository = produtoRepository;
		this.fileUploadService = fileUploadService;
	}

	@Transactional(readOnly = true)
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Produto buscarPorId(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PRODUTO_OBRIGATORIO);
		return produtoRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(MSG_PRODUTO_NAO_ENCONTRADO));
	}

	@Transactional
	public Produto criar(Produto produto) {
		validarProduto(produto);
		ValidationUtils.validarCampoStringObrigatorio(produto.getImagemUrl(), "Imagem do produto");

		if (produto.getId() == null) {
			produto.setId(UUID.randomUUID());
		}

		return produtoRepository.save(produto);
	}

	@Transactional
	public Produto criar(Produto produto, MultipartFile imagemFile) {
		validarProduto(produto);
		validarImagemObrigatoria(imagemFile);

		String nomeArquivoImagem = fileUploadService.salvarImagem(imagemFile);
		produto.setImagemUrl(nomeArquivoImagem);

		if (produto.getId() == null) {
			produto.setId(UUID.randomUUID());
		}

		return produtoRepository.save(produto);
	}

	@Transactional
	public Produto atualizar(UUID id, Produto produto) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PRODUTO_OBRIGATORIO);
		validarProduto(produto);

		Produto existente = produtoRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(MSG_PRODUTO_NAO_ENCONTRADO));

		existente.setCategoriaId(produto.getCategoriaId());
		existente.setNome(produto.getNome().trim());
		existente.setDescricao(produto.getDescricao());
		existente.setPreco(produto.getPreco());
		existente.setImagemUrl(produto.getImagemUrl());
		existente.setAtivo(produto.getAtivo());

		return produtoRepository.save(existente);
	}

	@Transactional
	public Produto atualizar(UUID id, Produto produto, MultipartFile novaImagem) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PRODUTO_OBRIGATORIO);
		validarProduto(produto);

		Produto existente = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_PRODUTO_NAO_ENCONTRADO));

		String imagemAnterior = existente.getImagemUrl();

		existente.setCategoriaId(produto.getCategoriaId());
		existente.setNome(produto.getNome().trim());
		existente.setDescricao(produto.getDescricao());
		existente.setPreco(produto.getPreco());
		existente.setAtivo(produto.getAtivo());

		if (novaImagem != null && !novaImagem.isEmpty()) {
			String novaImagemWebp = fileUploadService.salvarImagem(novaImagem);
			existente.setImagemUrl(novaImagemWebp);
		}

		Produto atualizado = produtoRepository.save(existente);

		if (novaImagem != null && !novaImagem.isEmpty() && imagemAnterior != null && !imagemAnterior.isBlank()) {
			fileUploadService.removerImagem(imagemAnterior);
		}

		return atualizado;
	}

	@Transactional
	public void remover(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PRODUTO_OBRIGATORIO);

		Produto existente = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_PRODUTO_NAO_ENCONTRADO));

		produtoRepository.deleteById(id);

		if (existente.getImagemUrl() != null && !existente.getImagemUrl().isBlank()) {
			fileUploadService.removerImagem(existente.getImagemUrl());
		}
	}

	private void validarProduto(Produto produto) {
		ValidationUtils.validarCampoObrigatorio(produto, "Produto");
		ValidationUtils.validarCampoStringObrigatorio(produto.getNome(), "Nome do produto");
		ValidationUtils.validarCampoObrigatorio(produto.getPreco(), "Preco do produto");
		ValidationUtils.validarCampoObrigatorio(produto.getAtivo(), "Status ativo do produto");

		if (produto.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Preco do produto nao pode ser negativo.");
		}

		if (produto.getAtivo() != 0 && produto.getAtivo() != 1) {
			throw new IllegalArgumentException("Campo ativo deve ser 0 (inativo) ou 1 (ativo).");
		}

		produto.setNome(produto.getNome().trim());
	}

	private void validarImagemObrigatoria(MultipartFile imagemFile) {
		if (imagemFile == null || imagemFile.isEmpty()) {
			throw new IllegalArgumentException(MSG_IMAGEM_OBRIGATORIA);
		}
	}

}
