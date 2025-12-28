/*  Função completa do model.Aluno
A classe Aluno define:
como os dados de um aluno são representados na aplicação;
como serão armazenados na tabela alunos do banco;
como outros componentes (como os controllers e services)
vão acessar e alterar esses dados de forma segura.
 * 
 * */
package com.Cadastro.Aluno.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long matricula;

	private String nome;
	private Integer idade;

	// construtor vázio (obrigatório)
	public Aluno() {
	}
	//Getters & Setters
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
