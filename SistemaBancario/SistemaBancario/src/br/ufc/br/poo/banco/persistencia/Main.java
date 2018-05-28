package br.ufc.br.poo.banco.persistencia;

import java.io.*;
import br.ufc.br.poo.banco.conta.*;

public class Main{
	public static void main(String[] args) {
		ArquivoConta teste = new ArquivoConta(10);
		ContaAbstrata conta1 = new Conta("12345");
		ContaAbstrata conta2 = new Conta("12346");
		ContaAbstrata conta3 = new Conta("12347");
		conta1.creditar(20);
		conta2.creditar(50);
		conta3.creditar(1000);

		teste.inserir(conta1);
		teste.inserir(conta2);
		teste.inserir(conta3);
		

		teste.listar();

		return;








	}





}