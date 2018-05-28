package br.ufc.br.poo.banco.conta;

public class Conta extends ContaAbstrata {

	public Conta(String numero) {
		super(numero);
	}

	public void debitar(double valor) {
		this.saldo -= valor;
	}

}
