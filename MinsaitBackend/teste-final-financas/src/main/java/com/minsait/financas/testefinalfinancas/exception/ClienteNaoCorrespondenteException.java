package com.minsait.financas.testefinalfinancas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoCorrespondenteException extends Exception{
	private static final long serialVersionUID = 1L;
	public ClienteNaoCorrespondenteException(Long id, Long cpf) {
		super(String.format("O empréstimo com ID %s não corresponde ao cliente com CPF %s", id, cpf));
	}
}
