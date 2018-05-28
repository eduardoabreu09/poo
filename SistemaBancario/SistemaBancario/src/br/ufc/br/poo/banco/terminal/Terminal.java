package br.ufc.br.poo.banco.terminal;

import java.util.Scanner;

import br.ufc.br.poo.banco.api.BancoAPI;
import br.ufc.br.poo.banco.auditoria.AuditorGenerico;
import br.ufc.br.poo.banco.conta.Conta;
import br.ufc.br.poo.banco.conta.ContaAbstrata;
import br.ufc.br.poo.banco.conta.ContaEspecial;
import br.ufc.br.poo.banco.conta.ContaImposto;
import br.ufc.br.poo.banco.conta.ContaPoupanca;
import br.ufc.br.poo.banco.persistencia.VectorConta;
import br.ufc.br.poo.banco.servico.IServicoOperacaoCadastral;
import br.ufc.br.poo.banco.servico.IServicoOperacaoFinanceira;

public class Terminal {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BancoAPI api = new BancoAPI(new VectorConta());
		IServicoOperacaoFinanceira operacaoFinanceira = api.getOperacaoFinanceira();
		IServicoOperacaoCadastral operacaoCadastral = api.getOperacaoCadastral();
		boolean loop = true;
		while (loop) {
			switch (menuPrincipal()) {
			case 1:
				ContaAbstrata conta = null;
				switch (menuDeCadastro()) {
				case 1:
					System.out.println("Entre com o número da conta: ");
					conta = new Conta(scanner.next());
					break;
				case 2:
					System.out.println("Entre com o número da conta: ");
					conta = new ContaEspecial(scanner.next());
					break;
				case 3:
					System.out.println("Entre com o número da conta: ");
					conta = new ContaPoupanca(scanner.next());
					break;
				case 4:
					System.out.println("Entre com o número da conta: ");
					conta = new ContaImposto(scanner.next());
					break;

				default:
					System.out.println("Opção inválida!!!!");
					break;
				}

				if (conta != null) {
					operacaoCadastral.cadastrar(conta);
					System.out.println("Operação Realizada com Sucesso!");
				}

				break;
			case 2:
				System.out.println("Entre com o número da conta: ");
				String numero = scanner.next();
				System.out.println("Entre com o valor a ser creditado: ");
				double valor = scanner.nextDouble();
				operacaoFinanceira.creditar(numero, valor);
				System.out.println("Operação Realizada com Sucesso!");
				break;
			case 3:
				System.out.println("Entre com o número da conta: ");
				numero = scanner.next();
				System.out.println("Entre com o valor a ser debitado: ");
				valor = scanner.nextDouble();
				operacaoFinanceira.debitar(numero, valor);
				System.out.println("Operação Realizada com Sucesso!");

				break;
			case 4:
				System.out.println("Entre com o número da conta origem: ");
				String origem = scanner.next();
				System.out.println("Entre com o número da conta destino: ");
				String destino = scanner.next();
				System.out.println("Entre com o valor a ser transferido: ");
				valor = scanner.nextDouble();

				operacaoFinanceira.transferir(origem, destino, valor);
				System.out.println("Operação Realizada com Sucesso!");

				break;
			case 5:
				System.out.println("Entre com o número da conta: ");
				numero = scanner.next();
				System.out.println("Saldo: " + operacaoFinanceira.saldo(numero));
				break;
			case 6:
				System.out.println("Entre com o número da conta: ");
				numero = scanner.next();
				operacaoCadastral.remover(numero);
				System.out.println("Operação Realizada com Sucesso!");
				break;
			case 7:
				System.out.println("Entre com o número da conta: ");
				numero = scanner.next();
				operacaoFinanceira.renderJuros(numero);
				System.out.println("Operação Realizada com Sucesso!");

				break;
			case 8:
				System.out.println("Entre com o número da conta: ");
				numero = scanner.next();
				operacaoFinanceira.renderBonus(numero);
				System.out.println("Operação Realizada com Sucesso!");
				break;

			case 9:
				AuditorGenerico auditor = new AuditorGenerico();
				auditor.auditar(api.getAuditoria());
				break;

			case 10:
				System.out.print("Adeus e tenha um bom dia!!!");
				loop = false;
				break;

			default:
				break;
			}
		}
	}

	private static int menuPrincipal() {
		System.out.println("================================");
		System.out.println("Bem Vindo ao Nosso Banco");
		System.out.println("Terminal de Auto-Atendimento");
		System.out.println("================================");
		System.out.println(" [1] Cadastrar Nova Conta");
		System.out.println(" [2] Realizar Operação de Credito");
		System.out.println(" [3] Realizar Operação de Debito");
		System.out.println(" [4] Realizar Operação de Transferencia");
		System.out.println(" [5] Consultar Saldo");
		System.out.println(" [6] Fechar/Excluir Conta");
		System.out.println(" [7] Realizar Operação de Rendimento de Poupança");
		System.out.println(" [8] Realizar Operação de Conversão de Bonus");
		System.out.println(" [9] Realizar Auditoria");
		System.out.println(" [10] Sair");
		System.out.println("================================");
		System.out.println("Entre com a opção desejada: ");
		return scanner.nextInt();

	}

	private static int menuDeCadastro() {
		System.out.println("================================");
		System.out.println("Castrar Nova Conta");
		System.out.println("================================");
		System.out.println(" [1] Conta Simples");
		System.out.println(" [2] Conta Especial");
		System.out.println(" [3] Conta Poupanca");
		System.out.println(" [4] Conta Imposto");
		System.out.println("================================");
		System.out.println("Entre com a opção desejada: ");
		return scanner.nextInt();
	}

}
