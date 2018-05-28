package br.ufc.br.poo.banco.servico;

public interface IServicoOperacaoFinanceira {

	public void creditar(String numero, double valor);

	public void debitar(String numero, double valor);

	public double saldo(String numero);

	public void transferir(String origem, String destino, double valor);

	public void renderJuros(String numero);

	public void renderBonus(String numero);

}
