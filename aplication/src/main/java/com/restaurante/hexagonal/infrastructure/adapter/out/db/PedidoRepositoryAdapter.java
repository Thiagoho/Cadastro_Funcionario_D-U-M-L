package com.restaurante.hexagonal.infrastructure.adapter.out.db;

import org.springframework.stereotype.Component;

import com.restaurante.hexagonal.aplication.port.out.PedidoRepositoryPort;
import com.restaurante.hexagonal.domain.model.Pedido;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    // 🧠 Simulação de persistência (poderia ser via JPA)
    @Override
    public Pedido salvar(Pedido pedido) {
        pedido.setId(1L); // simula ID gerado
        System.out.println(" Pedido salvo no banco: " + pedido);
        return pedido;
    }
}
