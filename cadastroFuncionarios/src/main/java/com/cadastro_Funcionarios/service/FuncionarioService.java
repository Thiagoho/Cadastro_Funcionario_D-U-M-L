package com.cadastro_Funcionarios.service;

import org.springframework.stereotype.Service;

import com.cadastro_Funcionarios.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	// Conversão de entidade para DTO
//	private 

}
