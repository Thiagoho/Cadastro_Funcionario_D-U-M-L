package com.cadastro_Funcionarios.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cadastro_Funcionarios.dto.*;
import com.cadastro_Funcionarios.service.FuncionarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	private final FuncionarioService service;
	
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}
	
	// Post 
	@PostMapping
	public ResponseEntity<FuncionarioResponseDto> criar(
			@Valid @RequestBody FuncionarioRequestDto dto) {
		return ResponseEntity.ok(service.criar(dto));
	}
	//Get
	@GetMapping
	public ResponseEntity<List<FuncionarioResponseDto>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	// Get {id}
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioResponseDto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
			
	}
	
}
