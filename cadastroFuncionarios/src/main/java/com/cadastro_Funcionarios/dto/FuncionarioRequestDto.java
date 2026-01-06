package com.cadastro_Funcionarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioRequestDto {
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Email(message = "E-mail inválido")
	@NotBlank(message = "E-mail é obrigatório")
	private String email;
	
	@NotBlank(message = "Cargo é obrigatório")
	private String cargo;
	
	
	// Construtor vázio(opcional)
	public FuncionarioRequestDto() {
		
	}
	// Getters & Setters

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
