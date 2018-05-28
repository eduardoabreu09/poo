package br.ufc.br.poo.banco.conta;

public class ContaImposto extends ContaAbstrata {

	public ContaImposto(String numero) {
		super(numero);
	}

	public void debitar(double valor) {
		this.saldo -= (valor + (valor * 0.001));
	}

}
