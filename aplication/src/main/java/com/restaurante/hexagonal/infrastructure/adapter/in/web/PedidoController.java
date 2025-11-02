package com.restaurante.hexagonal.infrastructure.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.hexagonal.aplication.port.in.CriarPedidoUseCase;
import com.restaurante.hexagonal.domain.model.Pedido;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    // 🧠 Endpoint para criar pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return criarPedidoUseCase.criarPedido(pedido);
    }
}
