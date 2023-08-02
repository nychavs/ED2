package aula01;

import java.util.Arrays;

public class Vetor {

	private Cliente[] clientes = new Cliente[5];
	private int totalDeClientes = 0;
	
	private void reduzEspaco() {
		if (totalDeClientes < clientes.length * 0.25) {
			Cliente[] novoVetor = Arrays.copyOf(clientes, clientes.length/2);
			clientes = novoVetor;
		}		
	}
	public int retornaTamanhoVetor(){
		return clientes.length;
	}
	
	private void garateEspaco() {
		
		if (totalDeClientes == clientes.length) {
			Cliente[] novoVetor = Arrays.copyOf(clientes, clientes.length * 2);
			clientes = novoVetor;
		}
		
	}
	
	public void adicionar(Cliente novoCliente) {
		
		garateEspaco();
		clientes[totalDeClientes] = novoCliente;
		totalDeClientes++;
	}
	
	public int pegaTotalClientes() {
		return totalDeClientes;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return (posicao >=0)&& (posicao < totalDeClientes);
	}
	
	public Cliente pegar(int posicao) {
		
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return clientes[posicao];
	}
	
	public boolean contem(Cliente clienteBuscado) {
		for (int i=0; i<totalDeClientes; i++) {
			if (clienteBuscado.equals(clientes[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean posicaoValidaInsercao(int posicao) {
		return (posicao >=0)&& (posicao <= totalDeClientes);
	}
	
	public void adicionar(Cliente novoCliente, int posicaoAdicionar) {
		
		garateEspaco();
		if (!posicaoValidaInsercao(posicaoAdicionar)){
			throw new IllegalArgumentException("Posicao invalida");
		}
		
		for (int i=totalDeClientes; i>=posicaoAdicionar; i--) {
			clientes[i+1] = clientes[i];
		}
		clientes[posicaoAdicionar] = novoCliente;
		totalDeClientes++;
	}
	
	public void remover(int posicaoRemover) {
		
		if (!posicaoOcupada(posicaoRemover)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		
		for (int i=posicaoRemover; i < totalDeClientes; i++) {
			clientes[i] = clientes[i+1];
		}
		
		totalDeClientes--;
		reduzEspaco();
	}
	
	public void removerUltimo() {

		if (!posicaoOcupada(totalDeClientes-1)) {
			throw new IllegalArgumentException("O vetor esta vazio");
		}
		clientes[totalDeClientes-1] = null;
		totalDeClientes--;
		reduzEspaco();
	}
	
	public void removerPrimeiro() {

		if (!posicaoOcupada(0)) {
			throw new IllegalArgumentException("O vetor esta vazio");
		}
		for (int i=0; i<totalDeClientes; i++) {
			clientes[i] = clientes[i+1];
		}
		totalDeClientes--;
		reduzEspaco();
	}
	
	public void removerTodos() {
		if (!posicaoOcupada(0)) {
			throw new IllegalArgumentException("O vetor esta vazio");
		}
		
		for (int i=0; i <= totalDeClientes; i++) {
			clientes[i] = null;
			totalDeClientes --;
		}
		reduzEspaco();
	}
	

}
