package br.ufc.br.poo.banco.conta;

public class ContaEspecial extends Conta {

	private double bonus;

	public ContaEspecial(String numero) {
		super(numero);
		this.bonus = 0;
	}

	public void renderBonus() {
		super.creditar(this.bonus);
		this.bonus = 0;
	}

	public void creditar(double valor) {
		this.bonus += valor * 0.01;
		super.creditar(valor);
	}

}
