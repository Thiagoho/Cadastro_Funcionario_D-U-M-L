package com.restaurante.hexagonal.aplication.port.in;

import com.restaurante.hexagonal.domain.model.Pedido;

public interface CriarPedidoUseCase {
    Pedido criarPedido(Pedido pedido);
}
