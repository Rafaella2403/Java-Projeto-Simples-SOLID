package service.reajuste;

import java.math.BigDecimal;
import java.util.List;
import model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> listaValidacoesReajuste;
	
	public ReajusteService(List<ValidacaoReajuste> listaValidacoesReajuste) {
		this.listaValidacoesReajuste = listaValidacoesReajuste;
	}

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		
		this.listaValidacoesReajuste.forEach(validacao -> validacao.validar(funcionario, aumento));
		
		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
