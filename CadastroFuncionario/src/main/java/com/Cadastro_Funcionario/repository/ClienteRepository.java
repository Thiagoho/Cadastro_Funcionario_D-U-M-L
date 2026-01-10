package com.Cadastro_Funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cadastro_Funcionario.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
