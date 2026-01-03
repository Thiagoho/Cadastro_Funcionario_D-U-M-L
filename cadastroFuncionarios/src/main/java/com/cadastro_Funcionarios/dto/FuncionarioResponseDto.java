package com.cadastro_Funcionarios.dto;

public class FuncionarioResponseDto {
	// Atributos
	private String nome;
	private String email;
	private String cargo;
	
	// Construtor Vázio(opcional)
	public FuncionarioResponseDto() {
		
	}
	// Construtor
	public FuncionarioResponseDto(String nome, String email, String cargo) {
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	// Getters & Getters
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
