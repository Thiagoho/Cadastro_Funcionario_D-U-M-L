/* Esta class é o coração da lógica de negócios relacionada ao produtos em uma
 * aplicação Spring Boot.
 * Sua função principal e orquestrar as regras e operações que envolvem os produtos.
 * */

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
	/* 				listarTods
	 * Recupera uma lista com todos os produtos cadastrados no sistema.
	 * Delega a tarefa ao repositório, que busca os dados no banco, e simplemente 
	 * repassa a lista.
	 * */
	public List<Produto> listarTodos() {
		return repository.findAll();
	}
	
	/*			buscarPorId
	 * Busca um produto especificado pelo seu ID único.
	 * Se nenhum produto for encontrado com aquele ID, não retorna null. 
	 * Em vez disso, lança uma exceção personalizada  (como RecursoNaoEncontradoException), que
	 * será traduzida em uma reposta de erro HTTP(como 404 Not Found). Isso garente um tratamento
	 * de erro consistente.
	 * */
	public Produto buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Produto não Encotrado"));
	}
	
	/*			criar(produto)
	 * Recebe os dados de um novo produto e o salva no BD
	 * Antes de salvar, verifica se já existe um produto com o mesmo nome.
	 * Se existir, lança um exceção de conflito (como ConflitoException), que
	 * resultará em um erro 409 Conflict. Isso evita duplicações indesejadas.
	 * Verificase os campos essenciais, como nome e preco, foram fornecidos. 
	 * Se estiverem ausentes(null), lança um exceção de argumento inválido.
	 * */
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
	
	/*			atualizar
	 * Atualiza todas as informações de um produto existente.
	 * Primeiro, busca o produto pelo ID (usando o próprio método buscarPorId, que já
	 * valida a existência).
	 * Depois, subustitui completamente os dados antigos (nome, preco, estoque) pelos
	 * novos dados fornecidos. Por fim, salva a versão atualizada.
	 * */
	
	public Produto atualizar(Long id, Produto novo) {
		Produto existente = buscarPorId(id);
		
		existente.setNome(novo.getNome());
		existente.setPreco(novo.getPreco());
		existente.setEstoque(novo.getEstoque());
		
		return repository.save(existente);
	}
	
	/*			atualizaParcial
	 * Atualiza apenas os campos especificos que forem fornecidos, mantendo os outros
	 * inalterados.
	 * Também começa buscando o produto existente. A diferença é que ela verifca campo a campo
	 * nos novos dados. Se um campo (como nome) foi enviado na requesição (não é null), ele atualiza
	 * somente aquele campo no produto existente. Campos não enviados permanecem como estavam.
	 * É muito útil para operações de "patch".
	 * */
	public Produto atualizarParcial(Long id, Produto updates) {
		Produto existente = buscarPorId(id);
		
		if(updates.getNome() != null)
			existente.setNome(updates.getNome());
		if(updates.getPreco() != null)
			existente.setPreco(updates.getPreco());
		if(updates.getEstoque() != null)
			existente.setEstoque(updates.getEstoque());
		
		return repository.save(existente);
	}
	
	/*			deletar
	 * Remove um produto do sistema pelo seu ID.
	 * Primeiro valida se o produto existe (chamando buscarPorId).
	 * Só depois de confirmar a existência, solicita ao repositório e exclusão.
	 * Isso evita tentativas de apagar recursos que não existem.
	 * */
	public void deletar(Long id) {
		Produto existente = buscarPorId(id); 
			repository.delete(existente);
		
	}
	
}
















