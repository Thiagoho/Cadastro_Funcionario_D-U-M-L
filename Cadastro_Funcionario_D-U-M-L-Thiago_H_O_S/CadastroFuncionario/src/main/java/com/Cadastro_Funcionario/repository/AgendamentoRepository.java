package com.Cadastro_Funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cadastro_Funcionario.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
