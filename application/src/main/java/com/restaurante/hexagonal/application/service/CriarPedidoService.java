package com.restaurante.hexagonal.application.service;



import com.restaurante.hexagonal.application.port.in.CriarPedidoUseCase;
import com.restaurante.hexagonal.application.port.out.PedidoRepositoryPort;
import com.restaurante.hexagonal.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class CriarPedidoService implements CriarPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    
    @Override
    public Pedido criarPedido(Pedido pedido) {
        if (pedido.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um produto.");
        }
        return pedidoRepositoryPort.salvar(pedido);
    }
}

