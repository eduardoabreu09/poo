package br.ufc.br.poo.banco.persistencia;

import java.util.Vector;

import br.ufc.br.poo.banco.conta.ContaAbstrata;

public class VectorConta implements IRepositorioConta {

	private Vector<ContaAbstrata> contas;

	public VectorConta() {
		this.contas = new Vector<ContaAbstrata>();
	}

	public void inserir(ContaAbstrata conta) {
		if (this.procurar(conta.getNumero()) == null) {
			this.contas.add(conta);
		}
	}

	public void remover(String numero) {
		ContaAbstrata conta = this.procurar(numero);
		if (conta != null) {
			this.contas.remove(conta);
		}
	}

	public ContaAbstrata procurar(String numero) {
		for (ContaAbstrata conta : contas) {
			if (conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		return null;
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata array[] = new ContaAbstrata[this.contas.size()];
		int index = 0;
		for (ContaAbstrata conta : contas) {
			array[index++] = conta;
		}
		return array;
	}

	public int tamanho() {
		return contas.size();
	}

}
