package com.countryburguer.cardapio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryburguer.cardapio.model.ItemPedido;
import com.countryburguer.cardapio.repository.ItemPedidoRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class ItemPedidoService {

	private static final String MSG_ID_ITEM_PEDIDO_OBRIGATORIO = "ID do item do pedido";
	private static final String MSG_ITEM_PEDIDO_NAO_ENCONTRADO = "Item do pedido nao encontrado para o ID informado.";

	private final ItemPedidoRepository itemPedidoRepository;

	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}

	@Transactional(readOnly = true)
	public List<ItemPedido> listarTodos() {
		return itemPedidoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<ItemPedido> listarPorPedido(UUID pedidoId) {
		ValidationUtils.validarCampoObrigatorio(pedidoId, "ID do pedido");
		return itemPedidoRepository.findAllByPedidoId(pedidoId);
	}

	@Transactional(readOnly = true)
	public ItemPedido buscarPorId(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ITEM_PEDIDO_OBRIGATORIO);
		return itemPedidoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_ITEM_PEDIDO_NAO_ENCONTRADO));
	}

	@Transactional
	public ItemPedido criar(ItemPedido itemPedido) {
		validarItemPedido(itemPedido);

		if (itemPedido.getId() == null) {
			itemPedido.setId(UUID.randomUUID());
		}

		return itemPedidoRepository.save(itemPedido);
	}

	@Transactional
	public ItemPedido atualizar(UUID id, ItemPedido itemPedido) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ITEM_PEDIDO_OBRIGATORIO);
		validarItemPedido(itemPedido);

		ItemPedido existente = itemPedidoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_ITEM_PEDIDO_NAO_ENCONTRADO));

		existente.setPedidoId(itemPedido.getPedidoId());
		existente.setProdutoId(itemPedido.getProdutoId());
		existente.setQuantidade(itemPedido.getQuantidade());
		existente.setObservacao(itemPedido.getObservacao() != null ? itemPedido.getObservacao().trim() : null);
		existente.setPrecoUnitario(itemPedido.getPrecoUnitario());

		return itemPedidoRepository.save(existente);
	}

	@Transactional
	public void remover(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_ITEM_PEDIDO_OBRIGATORIO);

		if (!itemPedidoRepository.existsById(id)) {
			throw new IllegalArgumentException(MSG_ITEM_PEDIDO_NAO_ENCONTRADO);
		}

		itemPedidoRepository.deleteById(id);
	}

	private void validarItemPedido(ItemPedido itemPedido) {
		ValidationUtils.validarCampoObrigatorio(itemPedido, "Item do pedido");
		ValidationUtils.validarCampoObrigatorio(itemPedido.getPedidoId(), "Pedido do item");
		ValidationUtils.validarCampoObrigatorio(itemPedido.getProdutoId(), "Produto do item");
		ValidationUtils.validarCampoObrigatorio(itemPedido.getQuantidade(), "Quantidade do item");
		ValidationUtils.validarCampoObrigatorio(itemPedido.getPrecoUnitario(), "Preco unitario do item");

		if (itemPedido.getQuantidade() <= 0) {
			throw new IllegalArgumentException("Quantidade do item deve ser maior que zero.");
		}

		if (itemPedido.getPrecoUnitario().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Preco unitario do item nao pode ser negativo.");
		}

		if (itemPedido.getObservacao() != null) {
			itemPedido.setObservacao(itemPedido.getObservacao().trim());
		}
	}

}
