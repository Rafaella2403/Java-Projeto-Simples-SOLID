package service.promocao;

import model.Cargo;
import model.Funcionario;
import model.ValidacaoException;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		
		Cargo cargoAtual = funcionario.getCargo();
		
		if (Cargo.GERENTE == cargoAtual)
			throw new ValidacaoException("Promoção não autorizada!! Gerentes nao podem ser promovidos!");
		
		if (metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		} else
			throw new ValidacaoException("Promoção não autorizada!! Funcionario nao bateu a meta!");
	}

}
