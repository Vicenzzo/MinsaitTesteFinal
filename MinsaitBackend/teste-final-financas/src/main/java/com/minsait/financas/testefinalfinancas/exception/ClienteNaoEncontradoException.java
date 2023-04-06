package com.minsait.financas.testefinalfinancas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException(Long cpf) {
		super(String.format("O cpf %s nao foi encontrado", cpf));
	}
}
