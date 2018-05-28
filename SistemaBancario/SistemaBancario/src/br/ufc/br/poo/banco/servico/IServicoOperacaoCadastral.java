package br.ufc.br.poo.banco.servico;

import br.ufc.br.poo.banco.conta.ContaAbstrata;

public interface IServicoOperacaoCadastral {

	public void cadastrar(ContaAbstrata conta);

	public void remover(String numero);

	public ContaAbstrata procurar(String numero);

}
