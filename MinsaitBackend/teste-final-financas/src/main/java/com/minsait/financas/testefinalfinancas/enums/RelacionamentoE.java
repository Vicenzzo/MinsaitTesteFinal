package com.minsait.financas.testefinalfinancas.enums;

import java.math.BigDecimal;

import com.minsait.financas.testefinalfinancas.entity.Emprestimo;

public enum RelacionamentoE {
	
	BRONZE() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo) {
        	
        	emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.8)));
        	return emprestimo.getValorFinal();
        }
    },
    PRATA() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo) {
        	
        	if(emprestimo.getDataInicial().equals(5000)) {
        		emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.4)));
        	}
        	return emprestimo.getValorFinal();	
        	
        }
    },
    OURO() {
        @Override
		public
        BigDecimal calcula(Emprestimo emprestimo) {
        	
        	
        	emprestimo.setValorFinal(emprestimo.getValorIncial().multiply(new BigDecimal(1.3)));
        	return emprestimo.getValorFinal();	
        	
        }
    };

    public abstract BigDecimal calcula(Emprestimo emprestimo);
}
