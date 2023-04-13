package com.minsait.financas.testefinalfinancas.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.financas.testefinalfinancas.entity.Cliente;
import com.minsait.financas.testefinalfinancas.exception.CPFCadastradoException;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.repository.ClienteRepository;
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrarCliente(Cliente cliente) throws CPFCadastradoException {
		if(this.clienteRepository.existsById(cliente.getCPF())) {
			throw new CPFCadastradoException(cliente.getCPF());
		}
		Cliente clienteRetorno = this.clienteRepository.save(cliente);
		return clienteRetorno;
	}

	public List<Cliente> retornarTodosOsCliente() {
		return this.clienteRepository.findAll();
	}

	public Cliente retornaCliente(Long cpf) throws ClienteNaoEncontradoException{
		
		if(this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.findById(cpf).get();
		}
		throw new ClienteNaoEncontradoException(cpf);
	}

	public Cliente alterarCliente(Long cpf, @Valid Cliente cliente) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente LivroASerAlterado = this.clienteRepository.findById(cpf).get();
			
			cliente.setCPF(cpf);
			if (cliente.getCEP() == null) {
				cliente.setCEP(LivroASerAlterado.getCEP());
			}
			
			if (cliente.getTelefone() == null) {
				cliente.setTelefone(LivroASerAlterado.getTelefone());
			}
			
			if (cliente.getRua() == null) {
				cliente.setRua(LivroASerAlterado.getRua());
			}
			if (cliente.getNumeroDaResidencia() == null) {
				cliente.setNumeroDaResidencia(LivroASerAlterado.getNumeroDaResidencia());
			}
			if(cliente.getRendimentoMensal() == null) {
				cliente.setRendimentoMensal(LivroASerAlterado.getRendimentoMensal());
			}
			if(cliente.getNome() == null) {
				cliente.setNome(LivroASerAlterado.getNome());
			}
			
			return this.clienteRepository.save(cliente);
		}

		throw new ClienteNaoEncontradoException(cpf);
	}

	public MensagemDeSucesso deletarCliente(Long cpf) throws ClienteNaoEncontradoException {
		
		if (this.clienteRepository.existsById(cpf)) {
			this.clienteRepository.deleteById(cpf);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Deletado com sucesso");
			return mensagem;
			
		} 
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	

}
