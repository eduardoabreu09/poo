package br.ufc.br.poo.banco.servico;

import br.ufc.br.poo.banco.auditoria.IAuditavel;
import br.ufc.br.poo.banco.conta.ContaAbstrata;
import br.ufc.br.poo.banco.persistencia.IRepositorioConta;

public class ServicoAuditoria implements IAuditavel {

	private IRepositorioConta repositorio;

	public ServicoAuditoria(IRepositorioConta repositorio) {
		this.repositorio = repositorio;
	}

	public double saldoTotal() {
		ContaAbstrata[] contas = repositorio.listar();
		double saldoTotal = 0;
		for (ContaAbstrata conta : contas) {
			saldoTotal += conta.getSaldo();
		}
		return saldoTotal;
	}

	public int numeroContas() {
		return this.repositorio.tamanho();
	}
}
