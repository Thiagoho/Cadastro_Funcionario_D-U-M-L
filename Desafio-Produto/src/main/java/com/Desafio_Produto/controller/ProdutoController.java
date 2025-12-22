
// O controller recebe as requisições HTTP  e retorna as repostas apropriadas.

package com.Desafio_Produto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Desafio_Produto.dto.ProdutoResponseDTO;
import com.Desafio_Produto.service.ProdutoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	// Get - Listar todos os produtos
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
		List<ProdutoResponseDTO> produto = produtoService.listarTodos();
		return ResponseEntity.ok(produto);
	}
	
	
	// Get Buscar or Id
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
		ProdutoResponseDTO produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok(produto);
		
	}
	
	
	// Cadastrar um novo produto.
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> criarProduto(
	        @Valid @RequestBody ProdutoResponseDTO produtoDTO) {
		
		// Mostrar na tela 
		System.out.println("Recebido" + produtoDTO);
		ProdutoResponseDTO criado = produtoService.criarProduto(produtoDTO);
	    return ResponseEntity.status(201).body(criado); // ou HttpStatus.CREATED
		
	}
	
	// Put - Atualaizar produto
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> autualizarProduto(
			@PathVariable Long id, 
			@Valid @RequestBody ProdutoResponseDTO produtoDTO) {
		
		
		ProdutoResponseDTO produtoAtualizado = 
				produtoService.atualizarProduto(id, produtoDTO);
		return ResponseEntity.ok(produtoAtualizado);
		
	}
	// DELETE - Deletar produto
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
}


