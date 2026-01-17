package com.Cadastro_Funcionario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	@Email(message = "Email inválido")
	@NotBlank(message = "Email é obrigatório")
	private String email;
	
	@Size(min = 10, message = "Telefone deve ter no mínimo 10 digitos")
	private String telefone;
	
	public Cliente () {}
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
}
