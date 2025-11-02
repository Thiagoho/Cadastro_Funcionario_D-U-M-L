package com.restaurante.hexagonal.application.port.in;


import com.restaurante.hexagonal.domain.model.Pedido;

public interface CriarPedidoUseCase {
    Pedido criarPedido(Pedido pedido);
}

