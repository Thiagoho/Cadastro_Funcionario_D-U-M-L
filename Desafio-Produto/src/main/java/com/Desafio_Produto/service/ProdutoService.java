// O Service contém a lógica e serve como intermediário entre Controller e Repository
package com.Desafio_Produto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Desafio_Produto.dto.ProdutoResponseDTO;
import com.Desafio_Produto.model.Produto;
import com.Desafio_Produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Conversão de entidade para DTO
    private ProdutoResponseDTO toDTO(Produto produto) {
        return new ProdutoResponseDTO(
            produto.getNome(),
            produto.getPreco(),
            produto.getQuantidade()
        );
    }

    // Conversão de DTO para entidade
    private Produto toEntity(ProdutoResponseDTO dto) {
        return new Produto(
            dto.getNome(),
            dto.getPreco(),
            dto.getQuantidade()
        );
    }

    // Buscar por ID
    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        return toDTO(produto);
    }

    // Listar todos os produtos
    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll()
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    // Atualizar produto
    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoResponseDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());

        produtoRepository.save(produto);
        return toDTO(produto);
    }

    // Criar produto
    public ProdutoResponseDTO criarProduto(ProdutoResponseDTO produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        Produto salvo = produtoRepository.save(produto);
        return toDTO(salvo);
    }

    // Deletar produto
    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }
}
