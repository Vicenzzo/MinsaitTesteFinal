package com.minsait.financas.testefinalfinancas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.financas.testefinalfinancas.entity.Emprestimo;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{


	List<Emprestimo> findAllByCPFCliente(Long cpf);	
}
