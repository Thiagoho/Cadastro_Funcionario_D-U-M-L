package com.Cadastro.Aluno.repository;
/* A interface AlunoRepository conecta sua entidade Aluno com o banco de dados.
Ela não precisa de código dentro (por isso está vazia), pois o Spring Data JPA já fornece tudo automaticamente.
 * */

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cadastro.Aluno.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, Long>{

}
