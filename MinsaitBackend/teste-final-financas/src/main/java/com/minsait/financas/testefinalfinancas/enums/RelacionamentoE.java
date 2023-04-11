package com.minsait.financas.testefinalfinancas.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.minsait.financas.testefinalfinancas.entity.Emprestimo;
import com.minsait.financas.testefinalfinancas.exception.ClienteNaoEncontradoException;
import com.minsait.financas.testefinalfinancas.service.EmprestimoService;

public enum RelacionamentoE {
	BRONZE() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo){
        	
        	emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.8)).setScale(2, RoundingMode.HALF_UP));
        	return emprestimo.getValorFinal();
        }
    },
    PRATA() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo){
        	
        	if(emprestimo.getValorIncial().compareTo(new BigDecimal(5000)) > 5000) {
        		emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.4)).setScale(2, RoundingMode.HALF_UP));
        	}
        	emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.6)).setScale(2, RoundingMode.HALF_UP));
        	return emprestimo.getValorFinal();	
        	
        }
    },
    OURO() {
		@Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo) {
        	
				if(quantidaEmprestimo < 2) {
					emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.2)).setScale(2, RoundingMode.HALF_UP));		
				}else {
					emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.3)).setScale(2, RoundingMode.HALF_UP));
	
				}				
        	return emprestimo.getValorFinal();	
        	
        }  
    };

    public abstract BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo);
}
