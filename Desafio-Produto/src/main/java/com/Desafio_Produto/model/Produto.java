
/* Model Entidade JPA) *Java persistencia API
 * */
package com.Desafio_Produto.model;

import jakarta.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	
	// Construtor padrão [obrigatório para JPA]
	public Produto() {
		
	}
	
	// Construtor com todos os campos (exceto ID)
	public Produto(String nome, Double preco, Integer quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	

}
