package com.restaurante.hexagonal.insfrastructure.adaptar.in.web;


import com.restaurante.hexagonal.application.port.in.CriarPedidoUseCase;
import com.restaurante.hexagonal.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    // Endpoint para criar pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return criarPedidoUseCase.criarPedido(pedido);
    }
}

