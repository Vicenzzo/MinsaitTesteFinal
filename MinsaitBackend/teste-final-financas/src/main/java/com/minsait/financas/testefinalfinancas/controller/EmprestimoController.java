package com.minsait.financas.testefinalfinancas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.financas.testefinalfinancas.entity.Emprestimo;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoCorrespondenteException;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.exception.IdEmprestimoNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.exception.LimiteEmprestimoException;
import com.minsait.financas.testefinalfinancas.service.ClienteService;
import com.minsait.financas.testefinalfinancas.service.EmprestimoService;
import com.minsait.financas.testefinalfinancas.service.MensagemDeSucesso;

@RestController
@RequestMapping("/clientes/{cpf}/emprestimos")
public class EmprestimoController{
	private ClienteService clienteService;
	private EmprestimoService emprestimoService;
	
	
	@Autowired
	public EmprestimoController(ClienteService clienteService, EmprestimoService emprestimoService) {
		this.clienteService = clienteService;
		this.emprestimoService = emprestimoService;
	}  
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo cadastrarEmprestimoCliente(@PathVariable Long cpf, @Valid @RequestBody Emprestimo empresimo) throws ClienteNaoEncontradoException, LimiteEmprestimoException {
		Emprestimo empretimoSalvo = this.emprestimoService.cadastrarEmprestimo(empresimo, cpf);
		return empretimoSalvo;
	}
	@GetMapping
	public List<Emprestimo> retornarTodosOsEmprestimosPorCliente(@PathVariable Long cpf) throws ClienteNaoEncontradoException{
	
		List<Emprestimo> emprestimo = this.emprestimoService.retornarTodosOsEmprestimosPorCliente(cpf);
		return emprestimo;
	}
	@GetMapping("/{id}")
	
	public Emprestimo retornarEmprestimoPorId(@PathVariable Long cpf, @PathVariable Long id) throws ClienteNaoEncontradoException, IdEmprestimoNaoEncontradoException, ClienteNaoCorrespondenteException {
		return this.emprestimoService.retornarEmprestimoPorId(cpf, id);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public MensagemDeSucesso deletarEmprestimoPorId(@PathVariable Long id, @PathVariable Long cpf) throws ClienteNaoEncontradoException,  IdEmprestimoNaoEncontradoException{
		return this.emprestimoService.deletarEmprestimo(id, cpf);
	}
	
}
