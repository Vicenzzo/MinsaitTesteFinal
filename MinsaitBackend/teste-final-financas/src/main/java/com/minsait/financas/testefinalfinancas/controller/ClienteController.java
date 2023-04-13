package com.minsait.financas.testefinalfinancas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.financas.testefinalfinancas.dto.ClienteDTO;
import com.minsait.financas.testefinalfinancas.entity.Cliente;
import com.minsait.financas.testefinalfinancas.exception.CPFCadastradoException;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.service.ClienteService;
import com.minsait.financas.testefinalfinancas.service.MensagemDeSucesso;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@Valid @RequestBody Cliente cliente) throws CPFCadastradoException {
		Cliente clienteSalvo = this.clienteService.cadastrarCliente(cliente);
		return clienteSalvo;
	}
	@GetMapping
	public List<Cliente> retornarTodosOsCliente(){
		List<Cliente> retorno = this.clienteService.retornarTodosOsCliente();
		return retorno;
	}
	@GetMapping("/{cpf}")
	public Cliente retornaCliente(@PathVariable Long cpf) throws ClienteNaoEncontradoException {
		Cliente clienteRetornado = this.clienteService.retornaCliente(cpf);
		return clienteRetornado;
	}
	@PutMapping("/{cpf}")
	public ClienteDTO alterarCliente(@PathVariable Long cpf, @Valid @RequestBody ClienteDTO cliente) 
	throws ClienteNaoEncontradoException {
		Cliente clienteRequest = ClienteDTO.retornarCliente(cliente);
		Cliente clienteAlterado = this.clienteService.alterarCliente(cpf, clienteRequest);
		
		return ClienteDTO.retornarCliente(clienteAlterado);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{cpf}")
	public MensagemDeSucesso deletarCliente(@PathVariable Long cpf) throws ClienteNaoEncontradoException {
		return this.clienteService.deletarCliente(cpf);
	}
	
}
