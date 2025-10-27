/*
 * Essa classe representa o usuário que será validado.
 * Cada campo tem uma ou mais validações, incluindo as customizadas criadas pelo desenvolvedor:
 * @Cpf → valida formato de CPF
 * @IdadeMinima(18) → exige idade mínima de 18 anos
 * @EmailCorporativo → exige e-mail com domínio “@empresa.com”
 */

package com.example.usuariovalidator.model;


import com.example.usuariovalidator.validation.Cpf;
import com.example.usuariovalidator.validation.EmailCorporativo;
import com.example.usuariovalidator.validation.IdadeMinima;

import jakarta.validation.constraints.*;

public class Usuario {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Cpf
    private String cpf;

    @IdadeMinima(18)
    private Integer idade;

    @EmailCorporativo
    private String email;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
