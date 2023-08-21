package ordem;

import java.util.Iterator;

import pilha.Pilha;

public class OrdenarPilha {
	private Pilha pilha1 = new Pilha();
	private Pilha pilha2 = new Pilha();
	private Pilha pilha3 = new Pilha();
	
	public void inserirNaOrdemPilha(String nome) {
		if (pilha1.pegaTamanho() == 0) {
			pilha1.push(nome);	
		} else {
			verificaOrdenacao(nome);
		}
	}
	
	public void verificaOrdenacao(String nome) {
		String nome1 = (String) pilha1.top();
		System.out.println(nome1);
		
		if (nome1.compareTo(nome) == -1) {
			pilha1.push(nome);
		}else {
			transporPilha(nome);
		}
	}

	public void transporPilha(String nome) {
		int tamanho = pilha1.pegaTamanho();
		
		for (int i=0; i<tamanho; i++) {
			pilha2.push(pilha1.top());
			pilha1.pop();
			if (pilha1.pegaTamanho() == 0) {
				pilha2.push(nome);
			}
			else {
				String nomeTopo = (String) pilha1.top();
				if (nomeTopo.compareTo(nome) == -1){
					pilha2.push(nome);
				}
			}
		}
		reordernarPilha();
	}
	
	public void reordernarPilha() {
		int tamanho = pilha2.pegaTamanho();
		for (int i=0; i<tamanho; i++) {
			pilha3.push(pilha2.top());
			pilha2.pop();
		}
		imprimirPilha(pilha3);
	}
	
	public void imprimirPilha(Pilha pilha) {
		Pilha pilhaAux = pilha;
		int tamanho = pilha.pegaTamanho();
		for (int i=0; i<tamanho; i++) {
			System.out.println(pilhaAux.top());
			pilhaAux.pop();
		}
	}
	
	public int pegaTamanhoPilha1() {
		return pilha1.pegaTamanho();
	}
	public int pegaTamanhoPilha3() {
		return pilha3.pegaTamanho();
	}
}
