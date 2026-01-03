package com.cadastro_Funcionarios.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cadastro_Funcionarios.dto.FuncionarioResponseDto;
import com.cadastro_Funcionarios.service.FuncionarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	// Get -- Buscar funcionário por ID
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioResponseDto> buscarPorId(@PathVariable Long id){
		FuncionarioResponseDto funcionario = funcionarioService.buscarPorId(id);
		return ResponseEntity.ok(funcionario);
	}
	
	// Get -- Listar todos os funcionarios
	public ResponseEntity<List<FuncionarioResponseDto>> listarTodos() {
		List<FuncionarioResponseDto> funcionario = funcionarioService.listarTodos();
		return ResponseEntity.ok(funcionario);
	}
	
	// PUT -- Atualizar produto
	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioResponseDto> atualizarProduto (
			@PathVariable Long id,
			@Valid @RequestBody FuncionarioResponseDto funcionarioDto) {
		FuncionarioResponseDto funcionarioAtualizado = 
			funcionarioService.atualizarFuncionario(id, funcionarioDto);
		return ResponseEntity.ok(funcionarioAtualizado);
	}
	// DELETE -- Deletar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarfuncioanrio(@PathVariable Long id) {
		funcionarioService.deletarFuncionario(id);
	
	return ResponseEntity.noContent().build();
	}
}
