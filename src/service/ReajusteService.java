package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.Funcionario;
import model.ValidacaoException;

public class ReajusteService {

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percetualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if(percetualReajuste.compareTo(new BigDecimal("0.4")) > 0)
			throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário atual");
		
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
