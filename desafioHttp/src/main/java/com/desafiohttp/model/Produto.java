package com.desafiohttp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 
/* Gera automaticamente métodos como 
 * Getters & Setters
 * */


@Entity
/* Marca a classe como uma entidade JPA(Java Persistence API)
 * Será mapeada para uma tabela no banco de dados chamado produto (por padrão)
 * */

public class Produto {
	@Id
	/* Define id como chave primária da tabela:
	 * */
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* O banco de dados gera automaticamente valores únicos
	 * Comportamento similar ao AUTO_INCREMENT do MYSQL
	 * */
	
	// CAMPOS DA ENTIDADE
	private Long id;
	private String nome;
	private Double preco;
	private Integer estoque;
	
	
}
