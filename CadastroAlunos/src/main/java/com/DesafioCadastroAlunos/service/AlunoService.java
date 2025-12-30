// Camada de regra de negócio e orquestração
package com.DesafioCadastroAlunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DesafioCadastroAlunos.dto.AlunoDto;
import com.DesafioCadastroAlunos.model.Aluno;
import com.DesafioCadastroAlunos.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	public AlunoDto salvarAluno(AlunoDto alunoDto) {
		Aluno aluno = alunoDto.toEntity();
		Aluno salvo = alunoRepository.save(aluno);
		return AlunoDto.fromEntity(salvo);
	}
	
	public List<AlunoDto> listarAluno() {
		return alunoRepository.findAll()
				.stream()
				.map(AlunoDto::fromEntity)
				.collect(Collectors.toList());
	}
	
}
