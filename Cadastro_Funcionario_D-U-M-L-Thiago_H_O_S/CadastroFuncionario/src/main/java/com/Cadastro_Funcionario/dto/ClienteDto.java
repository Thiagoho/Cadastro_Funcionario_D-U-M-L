package com.Cadastro_Funcionario.dto;

import lombok.*;

@Getter
@Setter
public class ClienteDto {
	private String nome;
	
	private String email;
	
	private String telefone;
	
	public ClienteDto() {}
	
	public ClienteDto (String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

}
