package com.minsait.financas.testefinalfinancas.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minsait.financas.testefinalfinancas.entity.Emprestimo;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.exception.EmprestimoNaoCadastradoException;
import com.minsait.financas.testefinalfinancas.repository.ClienteRepository;
import com.minsait.financas.testefinalfinancas.repository.EmprestimoRepository;
@Service

public class EmprestimoService {
	
private final EmprestimoRepository emprestimoRepository;

private final ClienteRepository clienteRepository;
Integer valorTotalEmprestimo;
	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.emprestimoRepository = emprestimoRepository;
		this.clienteRepository = clienteRepository;
		
	}
	
	public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo, Long cpf) throws ClienteNaoEncontradoException, EmprestimoNaoCadastradoException{
		
		if (this.clienteRepository.existsById(cpf)) {
			
			if(this.clientePodeSolicitarEmprestimo(cpf, emprestimo.getValorIncial().doubleValue())) {
				emprestimo.setCPFCliente(cpf);
				emprestimo.setValorFinal(emprestimo.getRelacionamento().calcula(emprestimo, this.retornarTodosOsEmprestimosPorCliente(cpf).size()));
				
				return this.emprestimoRepository.save(emprestimo);
			}
			throw new EmprestimoNaoCadastradoException();
				
		}
		throw new ClienteNaoEncontradoException(cpf);
					
		
	}



	public List<Emprestimo> retornarTodosOsEmprestimosPorCliente(Long cpf) throws ClienteNaoEncontradoException {
		
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
	
	
	public boolean clientePodeSolicitarEmprestimo(Long cpf, Double valor) throws ClienteNaoEncontradoException {
		Double valorLimite = this.clienteRepository.getReferenceById(cpf).getRendimentoMensal().doubleValue() * 10;
		Double valorEmprestimo = valor;
		for (Emprestimo emprestimoAux : this.retornarTodosOsEmprestimosPorCliente(cpf)) {
			valorEmprestimo += emprestimoAux.getValorIncial().doubleValue();
		}
		if (valorEmprestimo <= valorLimite) {
				return true;	
		}
		return false;
	}
	


}
