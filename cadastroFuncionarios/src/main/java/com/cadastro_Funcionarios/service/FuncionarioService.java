package com.cadastro_Funcionarios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cadastro_Funcionarios.dto.FuncionarioRequestDto;
import com.cadastro_Funcionarios.dto.FuncionarioResponseDto;
import com.cadastro_Funcionarios.exception.RecursoNaoEncontradoException;
import com.cadastro_Funcionarios.model.Funcionario;
import com.cadastro_Funcionarios.repository.FuncionarioRepository;



@Service
public class FuncionarioService {
	private final FuncionarioRepository repository;
	
	public FuncionarioService(FuncionarioRepository repository ) {
		this.repository = repository;
	}
	
	// Post --> cadastrar Funcionário
	public FuncionarioResponseDto criar(FuncionarioRequestDto dto) {
		if(repository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("E-mail já cadastro.");
		}
		Funcionario funcionario = new Funcionario (
			dto.getNome(),
			dto.getEmail(),
			dto.getCargo()
		);
		return FuncionarioResponseDto.fromEntity(repository.save(funcionario));
	}
	
	// Get --> Listar Funcionarios
	public List<FuncionarioResponseDto> listarTodos() {
		return repository.findAll()
				.stream()
				.map(FuncionarioResponseDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	// Get ---> Buscar Funcionário por ID
	public FuncionarioResponseDto buscarPorId(Long id) {
		Funcionario  funcionario = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Funcionário não encontrado com ID : " + id));
				return FuncionarioResponseDto.fromEntity(funcionario);
	}
	
	// Put --> Atualizar Funcionário por ID
	public FuncionarioResponseDto atualizar(Long id, FuncionarioRequestDto dto) {
		Funcionario funcionario = repository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Funcionário não encontrado com ID :" + id));
				funcionario.setNome(dto.getNome());
				funcionario.setEmail(dto.getEmail());
				funcionario.setCargo(dto.getCargo());
				
				return FuncionarioResponseDto.fromEntity(repository.save(funcionario));
	}
	// Deletar --> Funcionário por ID
	public void deletar(Long id) {
		if(!repository.existsById(id)) {
			throw new RecursoNaoEncontradoException(
					"Funcionário não encontrado com ID :" + id);
		}
		repository.deleteById(id);
	}
}
