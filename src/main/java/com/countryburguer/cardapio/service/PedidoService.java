package com.countryburguer.cardapio.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryburguer.cardapio.model.Pedido;
import com.countryburguer.cardapio.repository.PedidoRepository;
import com.countryburguer.cardapio.utils.ValidationUtils;

@Service
public class PedidoService {

	private static final String MSG_ID_PEDIDO_OBRIGATORIO = "ID do pedido";
	private static final String MSG_PEDIDO_NAO_ENCONTRADO = "Pedido nao encontrado para o ID informado.";

	private final PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Transactional(readOnly = true)
	public List<Pedido> listarTodos() {
		return pedidoRepository.findAllByOrderByDataPedidoDesc();
	}

	@Transactional(readOnly = true)
	public Pedido buscarPorId(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PEDIDO_OBRIGATORIO);
		return pedidoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_PEDIDO_NAO_ENCONTRADO));
	}

	@Transactional
	public Pedido criar(Pedido pedido) {
		validarPedido(pedido);

		if (pedido.getId() == null) {
			pedido.setId(UUID.randomUUID());
		}

		if (pedido.getDataPedido() == null) {
			pedido.setDataPedido(LocalDateTime.now());
		}

		return pedidoRepository.save(pedido);
	}

	@Transactional
	public Pedido atualizar(UUID id, Pedido pedido) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PEDIDO_OBRIGATORIO);
		validarPedido(pedido);

		Pedido existente = pedidoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(MSG_PEDIDO_NAO_ENCONTRADO));

		existente.setNomeCliente(pedido.getNomeCliente().trim());
		existente.setTelefoneCliente(pedido.getTelefoneCliente().trim());
		existente.setEnderecoCliente(pedido.getEnderecoCliente().trim());
		existente.setValorTotal(pedido.getValorTotal());
		existente.setDataPedido(pedido.getDataPedido() != null ? pedido.getDataPedido() : existente.getDataPedido());

		return pedidoRepository.save(existente);
	}

	@Transactional
	public void remover(UUID id) {
		ValidationUtils.validarCampoObrigatorio(id, MSG_ID_PEDIDO_OBRIGATORIO);

		if (!pedidoRepository.existsById(id)) {
			throw new IllegalArgumentException(MSG_PEDIDO_NAO_ENCONTRADO);
		}

		pedidoRepository.deleteById(id);
	}

	private void validarPedido(Pedido pedido) {
		ValidationUtils.validarCampoObrigatorio(pedido, "Pedido");
		ValidationUtils.validarCampoStringObrigatorio(pedido.getNomeCliente(), "Nome do cliente");
		ValidationUtils.validarCampoStringObrigatorio(pedido.getTelefoneCliente(), "Telefone do cliente");
		ValidationUtils.validarCampoStringObrigatorio(pedido.getEnderecoCliente(), "Endereco do cliente");
		ValidationUtils.validarCampoObrigatorio(pedido.getValorTotal(), "Valor total do pedido");

		if (pedido.getValorTotal().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Valor total do pedido nao pode ser negativo.");
		}

		pedido.setNomeCliente(pedido.getNomeCliente().trim());
		pedido.setTelefoneCliente(pedido.getTelefoneCliente().trim());
		pedido.setEnderecoCliente(pedido.getEnderecoCliente().trim());
	}

}
