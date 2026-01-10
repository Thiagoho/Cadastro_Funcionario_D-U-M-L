package com.Cadastro_Funcionario.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
@Entity
@Table(name = "cliente",
	uniqueConstraints= {
			@UniqueConstraint(columnNames="email") // E-mail único garantido no BD.
	}
		)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	// Construtor vázio (opcional)
	public Cliente() {}
	
	// Construtor
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
