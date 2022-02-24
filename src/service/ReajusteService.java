package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.Funcionario;
import model.ValidacaoException;

public class ReajusteService {

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percetualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		
		if(percetualReajuste.compareTo(new BigDecimal("0.4")) > 0)
			throw new ValidacaoException("Reajuste não autorizado!! O aumento não pode ser superior a 40% do salário atual");
		
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		Long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
	
		if(mesesUltimoReajuste < 6)
			throw new ValidacaoException("Reajuste não autorizado!! O intervalo entre reajustes deve ser de no mínimo 6 meses");
		
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
