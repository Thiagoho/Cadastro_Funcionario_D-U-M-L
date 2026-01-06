package com.cadastro_Funcionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro_Funcionarios.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	boolean existsByEmail(String email);
}
