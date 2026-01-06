package com.cadastro_Funcionarios.dto;

import com.cadastro_Funcionarios.model.Funcionario;

public class FuncionarioResponseDto {
	// Atributos
	private Long id;
	private String nome;
	private String email;
	private String cargo;
	
	// Construtor Vázio(opcional)
	public FuncionarioResponseDto() {
		
	}
	// Construtor
	public FuncionarioResponseDto(Long id,String nome, String email, String cargo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	// Converter Dto --> Entity
	public Funcionario toEntity() {
		return new Funcionario(this.nome, this.email, this.cargo);
	}
	
	// Converter Entidade -->Dto
	public static FuncionarioResponseDto fromEntity(Funcionario funcionario ) {
		return new FuncionarioResponseDto(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getEmail(),
				funcionario.getCargo()
				);
	}
	// Getters & Getters
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	

	}

	

	

