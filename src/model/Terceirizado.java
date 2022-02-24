package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Terceirizado extends Funcionario{

	private String empresa;
	
	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, LocalDate dataUltimoReajuste) {
		super(nome, cpf, cargo, salario, dataUltimoReajuste);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
