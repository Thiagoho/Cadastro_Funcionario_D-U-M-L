// Camada de regra de negócio e orquestração
package com.DesafioCadastroAlunos.service;

import java.util.List;
import java.util.Optional;
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

	public List<AlunoDto> listarTodos() {
		return alunoRepository.findAll()
				.stream()
				.map(AlunoDto::fromEntity)
				.collect(Collectors.toList());
	}

    public Optional<AlunoDto> buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .map(AlunoDto::fromEntity);
    }


	public AlunoDto salvar(AlunoDto alunoDto) {
		Aluno aluno = alunoDto.toEntity();
		return AlunoDto.fromEntity(alunoRepository.save(aluno));
	}
	
	public Optional<AlunoDto> atualizar(Long id, AlunoDto dto) {
		return alunoRepository.findById(id).map(alunoExistente -> {
			alunoExistente.setNome(dto.getNome());
			alunoExistente.setEmail(dto.getEmail());
			return AlunoDto.fromEntity(alunoRepository.save(alunoExistente));
		});
	}
	public boolean excluir(Long id) {
		if(alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);;
			return true;
		}
		return false;
	}
	
}
