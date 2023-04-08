package com.minsait.financas.testefinalfinancas.service;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.minsait.financas.testefinalfinancas.entity.Cliente;
import com.minsait.financas.testefinalfinancas.entity.Emprestimo;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.repository.ClienteRepository;
import com.minsait.financas.testefinalfinancas.repository.EmprestimoRepository;
@Service

public class EmprestimoService {
	
private final EmprestimoRepository emprestimoRepository;

private final ClienteRepository clienteRepository;

	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.emprestimoRepository = emprestimoRepository;
		this.clienteRepository = clienteRepository;
		
	}
	
	public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo, Long cpf) throws ClienteNaoEncontradoException{
		if (this.clienteRepository.existsById(cpf)) {
			Cliente LivroASerAlterado = this.clienteRepository.findById(cpf).get();
			
			emprestimo.setCPFCliente(cpf);

		}
		return this.emprestimoRepository.save(emprestimo);
	}



	public Emprestimo retornarTodosOsCliente(Long cpf, @Valid Emprestimo empresimo, Cliente cliente, Long id) throws ClienteNaoEncontradoException {
		if(empresimo.getCPFCliente() == cliente.getCPF()) {
			return this.emprestimoRepository.findById(id).get();
		}
		throw new ClienteNaoEncontradoException(cpf);
	}

}
