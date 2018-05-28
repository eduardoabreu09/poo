package br.ufc.br.poo.banco.servico;

import br.ufc.br.poo.banco.conta.ContaAbstrata;
import br.ufc.br.poo.banco.conta.ContaEspecial;
import br.ufc.br.poo.banco.conta.ContaPoupanca;
import br.ufc.br.poo.banco.persistencia.IRepositorioConta;

public class ServicoOperacaoFinanceira implements IServicoOperacaoFinanceira {

	private double taxa = 0.001;
	
	private IRepositorioConta repositorio;

	public ServicoOperacaoFinanceira(IRepositorioConta repositorio) {
		this.repositorio = repositorio;
	}

	public void creditar(String numero, double valor) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null) {
			conta.creditar(valor);
		}
	}

	public void debitar(String numero, double valor) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null) {
			conta.debitar(valor);
		}
	}

	public double saldo(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null) {
			return conta.getSaldo();
		}
		return 0;
	}

	public void transferir(String origem, String destino, double valor) {
		ContaAbstrata contaDestino = repositorio.procurar(destino);
		if (contaDestino != null) {
			ContaAbstrata contaOrigem = repositorio.procurar(origem);
			if (contaOrigem != null && contaOrigem.getSaldo() > valor) {
				contaOrigem.debitar(valor);
				contaDestino.creditar(valor);
			}
		}
	}

	public void renderJuros(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null && conta instanceof ContaPoupanca) {
			((ContaPoupanca) conta).renderJuros(this.taxa);
		}
	}

	public void renderBonus(String numero) {
		ContaAbstrata conta = repositorio.procurar(numero);
		if (conta != null && conta instanceof ContaEspecial) {
			((ContaEspecial) conta).renderBonus();
		}
	}

}
