package com.Cadastro_Funcionario.model;

import java.math.BigDecimal;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Table(name = "servico")
public class Servico {
	
	private Long id;
	
	private String nome;
	
	private BigDecimal preco;
	
	public Servico() {}
	public Servico(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

}
