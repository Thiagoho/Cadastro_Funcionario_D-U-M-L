/*
 * Essa classe inicia o projeto Spring Boot e ativa automaticamente
 * as configurações de validação (Bean Validation) e injeção de dependências.
 */

package com.example.usuariovalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioValidatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioValidatorDemoApplication.class, args);
	}

}
