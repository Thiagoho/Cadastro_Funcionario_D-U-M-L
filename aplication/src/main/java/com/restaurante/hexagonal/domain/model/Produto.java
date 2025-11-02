package com.restaurante.hexagonal.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;

    // 🧠 Regra de negócio: reduzir estoque após venda
    public void reduzirEstoque(int quantidade) {
        if (quantidade > estoque) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + nome);
        }
        this.estoque -= quantidade;
    }
}
