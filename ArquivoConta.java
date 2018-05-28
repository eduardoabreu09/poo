package br.ufc.br.poo.banco.persistencia;

import java.io.*;
import br.ufc.br.poo.banco.conta.ContaAbstrata;


public class ArquivoConta implements IRepositorioConta{
	private ContaAbstrata[] contas;
	private int tam;
	private int tamax;

	public ArquivoConta(int tamax){
		this.tamax = tamax;
		this.tam = 0;
		this.contas = new ContaAbstrata[tamax];

	}
	public void inserir(ContaAbstrata conta){
		if(tam!= tamax){

			contas[tam] = conta;
			tam++;

		}



	}

	public ContaAbstrata procurar(String numero){
		int aux=-1;
		for(int i =0;i<tam;i++){
			if(contas[i].getNumero().equals(numero)){
				aux = i;


			}




		}
		return contas[aux];




	}
	public void remover(String numero){
		ContaAbstrata conta = procurar(numero);
		int aux=-1;
		for(int i=0;i<tam;i++){

			if(conta.getNumero().equals(contas[i].getNumero())){
				aux = i;

			}



		}
	contas[aux] = contas[tam-1];



	}

	public ContaAbstrata[] listar(){
		File diretorio = new File("/home/399016/Área de Trabalho");
		File arquivo = new File(diretorio,"Contas.txt");

		    try {
            PrintWriter gravador = new PrintWriter(arquivo);
      for (int i = 0; i < tam; i++){
    gravador.println("Numero: " + contas[i].getNumero()+"  Saldo: " + contas[i].getSaldo());
          }
      gravador.close();




    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
   
    


		return contas;



	}

	public int tamanho(){
		return tam;
	}




}