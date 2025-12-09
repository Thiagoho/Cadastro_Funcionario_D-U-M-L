package com.desafiohttp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiohttp.exception.ConflitoException;
import com.desafiohttp.exception.RecursoNaoEncontradoException;
import com.desafiohttp.model.Produto;
import com.desafiohttp.repository.ProdutoRepository;

@Service

public class ProdutoService {
	private final ProdutoRepository repository;
	
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
		
	}
	public List<Produto> listarTodos() {
		return repository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Produto não Encotrado"));
	}
	
	public Produto criar(Produto produto) {
		repository.findByNome(produto.getNome())
		.ifPresent(p -> {
			throw new ConflitoException("Já existe um produto com essa nome");
		}); {
			
		}
		if(produto.getNome() == null || produto.getPreco() == null) {
			throw new IllegalArgumentException("Dados inválidos");
		}
		return repository.save(produto);
	}
	
	
}
















