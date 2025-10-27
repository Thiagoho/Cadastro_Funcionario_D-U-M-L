/*
 * O método cadastrar() recebe um objeto Usuario via JSON.
 * A anotação @Valid ativa as validações automáticas do Bean Validation.
 * Se alguma validação falhar, a exceção MethodArgumentNotValidException
 * é lançada automaticamente — e capturada pelo GlobalExceptionHandler.
 */
package com.example.usuariovalidator.controlller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.usuariovalidator.model.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<String> cadastrar(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(" Usuário cadastrado com sucesso: " + usuario.getNome());
    }
}

