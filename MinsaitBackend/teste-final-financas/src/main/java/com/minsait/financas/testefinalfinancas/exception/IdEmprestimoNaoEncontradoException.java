package com.minsait.financas.testefinalfinancas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdEmprestimoNaoEncontradoException extends Exception{
	private static final long serialVersionUID = 1L;
	public IdEmprestimoNaoEncontradoException(Long id) {
		super(String.format("o ID %s nao foi encontrado", id));
	}
}
