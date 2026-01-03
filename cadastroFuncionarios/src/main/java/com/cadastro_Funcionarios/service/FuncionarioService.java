package com.cadastro_Funcionarios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cadastro_Funcionarios.dto.FuncionarioResponseDto;
import com.cadastro_Funcionarios.model.Funcionario;
import com.cadastro_Funcionarios.repository.FuncionarioRepository;



@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	// Conversão de entidade para DTO
	private FuncionarioResponseDto toDto(Funcionario funcionario) {
		return new FuncionarioResponseDto(
				funcionario.getNome(),
				funcionario.getEmail(),
				funcionario.getCargo()
				);
	}
	// Conversão de DTO para entidade (para ciração e atualizaçõa)
	private Funcionario toEntity(FuncionarioResponseDto funcionarioDto) {
		return new Funcionario(
				funcionarioDto.getNome(), 
				funcionarioDto.getEmail(),
				funcionarioDto.getCargo());
	}
	// Buscar por ID
	public FuncionarioResponseDto buscarPorId(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionario não encontrado com ID!!: " + id));
		return toDto(funcionario);
	}
	// Listar todos
	public List<FuncionarioResponseDto> listarTodos() {
		return funcionarioRepository.findAll()
				.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
	/// Atualizar funcionario
	
	public FuncionarioResponseDto atualizarFuncionario (Long id, FuncionarioResponseDto funcionarioDto) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionario não encontrado com ID : " + id));
		funcionario.setNome(funcionarioDto.getNome());
		funcionario.setEmail(funcionario.getEmail());
		funcionario.setCargo(funcionarioDto.getCargo());
		funcionarioRepository.save(funcionario);
		return toDto(funcionario);
	}
	// Criar funcionário
	public FuncionarioResponseDto criarFuncionario(FuncionarioResponseDto funcionarioDto) {
		Funcionario funcionario = toEntity(funcionarioDto);
		Funcionario salvo = funcionarioRepository.save(funcionario);
		return toDto(salvo);
	}
	// Deletar funcionário
	public void deletarFuncionario(Long id) {
		if(!funcionarioRepository.existsById(id)) {
			throw new RuntimeException("Funcionário não encontrado com ID :" + id);
		}
		funcionarioRepository.deleteById(id);
	}
	

}
