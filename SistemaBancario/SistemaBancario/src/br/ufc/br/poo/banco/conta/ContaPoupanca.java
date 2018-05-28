package br.ufc.br.poo.banco.conta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numero) {
		super(numero);
	}

	public void renderJuros(double taxa) {
		this.creditar(this.getSaldo() * taxa);
	}
}
