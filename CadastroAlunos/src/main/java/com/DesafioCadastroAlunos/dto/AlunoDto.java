// Objetos de transferência de dados (entrada e saída da API)
package com.DesafioCadastroAlunos.dto;

import com.DesafioCadastroAlunos.model.Aluno;

public class AlunoDto {

	private String nome;
	private String email;

	public AlunoDto() {
	}

	public AlunoDto(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public static AlunoDto fromEntity(Aluno aluno) {
		return new AlunoDto(aluno.getNome(), aluno.getEmail());
	}

	public Aluno toEntity() {
		return new Aluno(this.nome, this.email);
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

}
