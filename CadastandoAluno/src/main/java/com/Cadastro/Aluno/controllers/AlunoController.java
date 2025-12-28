package com.Cadastro.Aluno.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cadastro.Aluno.model.Aluno;
import com.Cadastro.Aluno.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoRepository alunoRepository;
	
	public AlunoController (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	/* @PostMapping: indica que esse método será chamado quando uma requisição HTTP do tipo POST for feita.

	@RequestBody: pega os dados JSON enviados no corpo da requisição e converte para um objeto Aluno.

	alunoRepository.save(aluno): salva o aluno no banco de dados.

	return: retorna o aluno salvo como resposta.
	 * */
	
	//criar aluno
	@PostMapping
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
	/*@GetMapping: indica que esse método será chamado quando o front-end fizer uma requisição HTTP do tipo GET.

	alunoRepository.findAll(): busca todos os registros da tabela alunos.

	return: retorna uma lista de alunos.
	 * */
	// List alunos
	@GetMapping
	public List<Aluno> listarAluno() {
		return alunoRepository.findAll();
	}
	
}
