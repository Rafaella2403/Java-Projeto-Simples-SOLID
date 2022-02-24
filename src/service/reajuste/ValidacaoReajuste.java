package service.reajuste;

import java.math.BigDecimal;

import model.Funcionario;

public interface ValidacaoReajuste {
	
	void validar(Funcionario funcionario, BigDecimal aumento);

}
