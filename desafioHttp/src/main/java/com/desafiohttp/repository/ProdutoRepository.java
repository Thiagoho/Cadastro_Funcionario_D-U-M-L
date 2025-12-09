package com.desafiohttp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiohttp.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Optional<Produto> findByNome(String nome);
	/*JpaRepository já vem com métodos prontos(findAll, findById, save...)
	 * Criamos um método para verificar conflito de nomes(findByNome)
	 * */
	
}
