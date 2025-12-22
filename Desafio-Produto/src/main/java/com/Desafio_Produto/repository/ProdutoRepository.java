package com.Desafio_Produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Desafio_Produto.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
