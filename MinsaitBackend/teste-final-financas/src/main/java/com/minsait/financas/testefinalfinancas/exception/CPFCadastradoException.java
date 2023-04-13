package com.minsait.financas.testefinalfinancas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.CONFLICT)

public class CPFCadastradoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CPFCadastradoException(Long cpf) {
		super(String.format("O CPF %s já está cadastrado", cpf));
	}
}