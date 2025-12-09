package com.desafiohttp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.desafiohttp.model.Produto;
import com.desafiohttp.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	private final ProdutoService service;
	
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}
	
	// Get - Listar todos
	@GetMapping	
	public List<Produto> listar() {
		return service.listarTodos();
	}
	
	// Get - Buscar por ID
	@GetMapping("/{id}")
	public Produto buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	
	// POST - Criar novo produto
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criar(@RequestBody Produto produto) {
		return service.criar(produto);
		
	}
	
	// PUT - Atualizar TODOS os dados
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return service.atualizar(id, produto);
	}
	
	// PATCH - Atualização parcial
	@PatchMapping("/{id}")
	public Produto AtualizarParcial(@PathVariable Long id, @RequestBody Produto produto) {
		return service.atualizarParcial(id, produto);
	}
	
	// DELETE - Remover
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable Long id) {
		service.deletar(id);
	}

}












