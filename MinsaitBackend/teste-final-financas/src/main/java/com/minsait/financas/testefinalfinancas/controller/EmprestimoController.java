package com.minsait.financas.testefinalfinancas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.financas.testefinalfinancas.dto.ClienteDTO;
import com.minsait.financas.testefinalfinancas.entity.Cliente;
import com.minsait.financas.testefinalfinancas.entity.Emprestimo;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.repository.ClienteRepository;
import com.minsait.financas.testefinalfinancas.repository.EmprestimoRepository;
import com.minsait.financas.testefinalfinancas.service.ClienteService;
import com.minsait.financas.testefinalfinancas.service.EmprestimoService;

@RestController
@RequestMapping("/clientes")
public class EmprestimoController{
	private ClienteService clienteService;
	private EmprestimoService emprestimoService;
	
	
	@Autowired
	public EmprestimoController(ClienteService clienteService, EmprestimoService emprestimoService) {
		this.clienteService = clienteService;
		this.emprestimoService = emprestimoService;
	}  
	
	
	@PostMapping("/{cpf}/emprestimos")
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo cadastrarEmprestimoCliente(@PathVariable Long cpf, @Valid @RequestBody Emprestimo empresimo) throws ClienteNaoEncontradoException {
		Emprestimo empretimoSalvo = this.emprestimoService.cadastrarEmprestimo(empresimo, cpf);
		return empretimoSalvo;
	}
	@GetMapping("/{cpf}/emprestimos")
	public List<Emprestimo> EmprestimoretornarTodosOsCliente(@PathVariable Long cpf,  @Valid Emprestimo empresimo, Cliente cliente) throws ClienteNaoEncontradoException{
	
		List<Emprestimo> emprestimo = this.emprestimoService.retornarTodosOsCliente(cpf, empresimo, cliente);
		return emprestimo;
	}
}
