package com.minsait.financas.testefinalfinancas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)

public class LimiteEmprestimoException extends Exception{
	private static final long serialVersionUID = 1L;
	public LimiteEmprestimoException(Long cpf) {
		super(String.format("O CPF %s não possue limite para cadastro de novos emprestimos", cpf));
	}
}
