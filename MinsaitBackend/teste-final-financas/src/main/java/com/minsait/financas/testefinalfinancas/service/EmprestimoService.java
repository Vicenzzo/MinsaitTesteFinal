package com.minsait.financas.testefinalfinancas.service;

import java.math.BigDecimal;
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
import com.minsait.financas.testefinalfinancas.enums.RelacionamentoE;
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
			emprestimo.setCPFCliente(cpf);
		}
		if(emprestimo.getRelacionamento().contains("Bronze")) {
			emprestimo.setValorFinal(this.calcula(emprestimo, RelacionamentoE.BRONZE));
		}
		return this.emprestimoRepository.save(emprestimo);
	}



	public List<Emprestimo> retornarTodosOsCliente(Long cpf) throws ClienteNaoEncontradoException {
		
		if (this.clienteRepository.existsById(cpf)) {
		
				return this.emprestimoRepository.findAllByCPFCliente(cpf);
			}
		
		
		
		throw new ClienteNaoEncontradoException(cpf);
	}

	public Emprestimo retornarEmprestimoPorId(Long cpf, Long id) throws ClienteNaoEncontradoException{
		
		if (this.clienteRepository.existsById(cpf)) {
			if (this.emprestimoRepository.existsById(id)) {
				Emprestimo emprestimo = this.emprestimoRepository.getReferenceById(id);
				if (emprestimo.getCPFCliente().equals(cpf)) {
					return emprestimo;
				}
				
			}
			
		}
		throw new ClienteNaoEncontradoException(cpf);
	}

	public MensagemDeSucesso deletarEmprestimo(Long id, Long cpf) throws ClienteNaoEncontradoException{
		if (this.clienteRepository.existsById(cpf)) {
			if (this.emprestimoRepository.existsById(id)) {
				this.emprestimoRepository.deleteById(id);
				MensagemDeSucesso mensagem = new MensagemDeSucesso();
				mensagem.setMensagem("Deletado com sucesso");
				return mensagem;
			}
			
			
		} 
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	BigDecimal calcula(Emprestimo emprestimo,  RelacionamentoE imposto) {
        return imposto.calcula(emprestimo);
   }


}
