package br.ufc.br.poo.banco.auditoria;


public class AuditorGenerico {

	public void auditar(IAuditavel auditavel) {
		if ((auditavel.saldoTotal() / auditavel.numeroContas()) > 500) {
			System.out.println("Banco aprovado na auditoria!");
		} else {
			System.out.println("Banco reprovado na auditoria!");
		}
	}
}
