package br.ufc.br.poo.banco.api;

import br.ufc.br.poo.banco.auditoria.IAuditavel;
import br.ufc.br.poo.banco.persistencia.IRepositorioConta;
import br.ufc.br.poo.banco.servico.IServicoOperacaoCadastral;
import br.ufc.br.poo.banco.servico.IServicoOperacaoFinanceira;
import br.ufc.br.poo.banco.servico.ServicoAuditoria;
import br.ufc.br.poo.banco.servico.ServicoOperacaoCadastral;
import br.ufc.br.poo.banco.servico.ServicoOperacaoFinanceira;

public class BancoAPI {

	private IRepositorioConta repositorio;

	public BancoAPI(IRepositorioConta repositorio) {
		this.repositorio = repositorio;
	}

	public IServicoOperacaoCadastral getOperacaoCadastral() {
		return new ServicoOperacaoCadastral(repositorio);
	}

	public IServicoOperacaoFinanceira getOperacaoFinanceira() {
		return new ServicoOperacaoFinanceira(repositorio);
	}

	public IAuditavel getAuditoria() {
		return new ServicoAuditoria(repositorio);
	}
}
