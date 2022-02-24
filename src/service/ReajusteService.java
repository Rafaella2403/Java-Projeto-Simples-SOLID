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
			throw new ValidacaoException("Reajuste n�o autorizado!! O aumento n�o pode ser superior a 40% do sal�rio atual");
		
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		Long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
	
		if(mesesUltimoReajuste < 6)
			throw new ValidacaoException("Reajuste n�o autorizado!! O intervalo entre reajustes deve ser de no m�nimo 6 meses");
		
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
