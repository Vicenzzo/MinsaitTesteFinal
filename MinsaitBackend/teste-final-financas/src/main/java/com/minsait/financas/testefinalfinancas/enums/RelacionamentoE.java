package com.minsait.financas.testefinalfinancas.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.minsait.financas.testefinalfinancas.entity.Emprestimo;


public enum RelacionamentoE {
	BRONZE() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo){
        	
        	emprestimo.setValorFinal(emprestimo.getValorInicial().multiply(new BigDecimal(1.8)).setScale(2, RoundingMode.HALF_UP));
        	return emprestimo.getValorFinal();
        }
    },
    PRATA() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo){
        	
        	if(emprestimo.getValorInicial().compareTo(new BigDecimal(5000)) > 5000) {
        		emprestimo.setValorFinal(emprestimo.getValorInicial().multiply(new BigDecimal(1.4)).setScale(2, RoundingMode.HALF_UP));
        	}
        	emprestimo.setValorFinal(emprestimo.getValorInicial().multiply(new BigDecimal(1.6)).setScale(2, RoundingMode.HALF_UP));
        	return emprestimo.getValorFinal();	
        	
        }
    },
    OURO() {
		@Override
		public
        BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo) {
        	
				if(quantidaEmprestimo <= 1) {
					emprestimo.setValorFinal(emprestimo.getValorInicial().multiply(new BigDecimal(1.2)).setScale(2, RoundingMode.HALF_UP));		
				}else {
					emprestimo.setValorFinal(emprestimo.getValorInicial().multiply(new BigDecimal(1.3)).setScale(2, RoundingMode.HALF_UP));
				}
								
        	return emprestimo.getValorFinal();	
        	
        }  
    };

    public abstract BigDecimal calcula(Emprestimo emprestimo, Integer quantidaEmprestimo);
}
