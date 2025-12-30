// Camada que lida com as requisições HTTP (ex: POST, GET, PUT, DELETE)
package com.DesafioCadastroAlunos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.DesafioCadastroAlunos.dto.AlunoDto;

import com.DesafioCadastroAlunos.service.AlunoService;





@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private final AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	// Criar Aluno
	@PostMapping
	public AlunoDto criarAluno(@RequestBody AlunoDto alunoDto) {
		return alunoService.salvarAluno(alunoDto);
	}
	
	// List Aluno
	@GetMapping
	public List<AlunoDto> listarAlunos() {
		return alunoService.listarAluno();
	}

}
