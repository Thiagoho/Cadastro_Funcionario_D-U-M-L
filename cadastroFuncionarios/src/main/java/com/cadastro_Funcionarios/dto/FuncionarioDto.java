package com.cadastro_Funcionarios.dto;

public class FuncionarioDto {
	
	private String nome;
	private String email;
	private String carga;
	
	// Construtor Vázio(opcional)
	public FuncionarioDto() {
		
	}
	// Construtor
	public FuncionarioDto(String nome, String emial, String carga) {
		this.nome = nome;
		this.email = email;
		this.carga = carga;
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
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	
}
