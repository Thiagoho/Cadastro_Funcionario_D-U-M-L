package com.Cadastro_Funcionario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "cliente", 
				uniqueConstraints = {
						@UniqueConstraint(columnNames= "email") 
				})
public class Cliente {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	public Cliente () {}
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
}
