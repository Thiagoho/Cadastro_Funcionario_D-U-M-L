// Camada que lida com as requisições HTTP (ex: POST, GET, PUT, DELETE)
package com.DesafioCadastroAlunos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DesafioCadastroAlunos.dto.AlunoDto;

import com.DesafioCadastroAlunos.service.AlunoService;

/*
 * GET        /alunos         → Listar todos
 * GET        /alunos/{id}    → Buscar por ID
 * POST       /alunos         → Cadastrar novo aluno
 * PUT        /alunos/{id}    → Atualizar aluno existente
 * DELETE     /alunos/{id}    → Remover aluno
 * */



@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private final AlunoService service;
	
	public AlunoController(AlunoService service) {
		this.service = service;
	}
	// GET List /alunos
	@GetMapping
	public List<AlunoDto> listarTodos() {
		return service.listarTodos();
	}

	// GET /aluno/{id}
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST // alunos
	@PostMapping
	public ResponseEntity<AlunoDto> criar(@RequestBody AlunoDto dto) {
		AlunoDto salvo = service.salvar(dto);
		return ResponseEntity.ok(salvo);
	}
	
	// PUT /alunos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody AlunoDto dto) {
		return service.atualizar(id, dto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// DELETE /alunos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		System.out.println("Foi deletado com sucesso!");
		return service.excluir(id)
				? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
		
						
	}
	
}




















