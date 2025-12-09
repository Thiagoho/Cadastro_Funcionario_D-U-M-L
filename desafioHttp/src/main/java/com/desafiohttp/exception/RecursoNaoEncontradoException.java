package com.desafiohttp.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
	public RecursoNaoEncontradoException(String msg) {
		super(msg);
	}
	/* Fluxo
	 * Recebe String msg como parâmetro
	 * Chama construtor pai (RuntimeExcetion) com msg
	 * Herda toda pilha de execução Stack trace automaticamente
	 * */

}
