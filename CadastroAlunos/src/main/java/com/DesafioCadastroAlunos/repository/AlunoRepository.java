// Interface que entende JpaRepository para persistência
package com.DesafioCadastroAlunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DesafioCadastroAlunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	// Pode incluir métodos como findByEmail(String email)
}
