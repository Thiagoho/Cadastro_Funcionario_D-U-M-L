package com.restaurante.hexagonal.aplication.port.out;

import com.restaurante.hexagonal.domain.model.Pedido;

public interface PedidoRepositoryPort {
    Pedido salvar(Pedido pedido);
}
