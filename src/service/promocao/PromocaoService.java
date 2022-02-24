package service.promocao;

import model.Cargo;
import model.Funcionario;
import model.ValidacaoException;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		
		Cargo cargoAtual = funcionario.getCargo();
		
		if (Cargo.GERENTE == cargoAtual)
			throw new ValidacaoException("Promo��o n�o autorizada!! Gerentes nao podem ser promovidos!");
		
		if (metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		} else
			throw new ValidacaoException("Promo��o n�o autorizada!! Funcionario nao bateu a meta!");
	}

}
