package com.Cadastro_Funcionario.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoDto {

	private String nome;
	
	private BigDecimal preco;
	
	public ServicoDto () {}
	
	public ServicoDto (String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
}
