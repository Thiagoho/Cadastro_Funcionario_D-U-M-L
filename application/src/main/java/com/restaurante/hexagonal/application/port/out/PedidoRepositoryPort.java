package com.restaurante.hexagonal.application.port.out;



import com.restaurante.hexagonal.domain.model.Pedido;

public interface PedidoRepositoryPort {
    Pedido salvar(Pedido pedido);
}
