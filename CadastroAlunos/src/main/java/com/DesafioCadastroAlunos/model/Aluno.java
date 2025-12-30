// Entidade JPA
package com.DesafioCadastroAlunos.model;

import jakarta.persistence.*;
@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	// Construtor vázio (opcional)
	public Aluno() {}
	
	public Aluno (String nome, String email) {
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
