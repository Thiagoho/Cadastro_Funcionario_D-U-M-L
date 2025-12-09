package com.desafiohttp.exception;

public class ConflitoException extends RuntimeException{
	public ConflitoException(String msg) {
		super(msg);
		/* Fluxo
		 * Recebe String msg como parâmetro
		 * Chama construtor pai (RuntimeExcetion) com msg
		 * Herda toda pilha de execução Stack trace automaticamente
		 * */
	
	}
	

}
