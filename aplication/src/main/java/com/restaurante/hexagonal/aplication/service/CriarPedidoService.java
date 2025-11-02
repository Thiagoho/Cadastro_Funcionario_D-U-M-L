package com.restaurante.hexagonal.aplication.service;

import org.springframework.stereotype.Service;

import com.restaurante.hexagonal.aplication.port.in.CriarPedidoUseCase;
import com.restaurante.hexagonal.aplication.port.out.PedidoRepositoryPort;
import com.restaurante.hexagonal.domain.model.Pedido;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CriarPedidoService implements CriarPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        // 🧠 Aqui aplicamos regras antes de salvar
        if (pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um produto.");
        }
        return pedidoRepositoryPort.salvar(pedido);
    }
}
