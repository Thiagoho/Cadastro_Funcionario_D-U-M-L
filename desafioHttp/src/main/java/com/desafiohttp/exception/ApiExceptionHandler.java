/*Explicação
 * @Controller --> Captura erros de toda a aplicação.
 * Cria JSON padrinazado sempre que ocorrer erro.
 * */

package com.desafiohttp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> handleNotFound(RecursoNaoEncontradoException e) {
		return buildResponse(HttpStatus.CONFLICT, e.getMessage());
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerConflict(ConflitoException e) {
		return buildResponse(HttpStatus.CONFLICT, e.getMessage());
	}
	
	public ResponseEntity<?> handlerGeneric(Exception e) {
		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no Servidor");
		
	}
	private ResponseEntity<?> buildResponse(HttpStatus status, String mensagem){
		Map<String, Object> body = new HashMap<>();
		body.put("status", status.value());
		body.put("erro", mensagem);
		body.put("timestamp", LocalDateTime.now());
		return ResponseEntity.status(status).body(body);
	}
	
}
