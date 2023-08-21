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
		if (nome1.compareTo(nome) == 1) {
			pilha1.push(nome);
		}else {
			transporPilha(nome);
		}
	}

	public void transporPilha(String nome) {
		for (int i=0; i<pilha1.pegaTamanho(); i++) {
			pilha2.push(pilha1.top());
			pilha1.pop();
			String nom = (String) pilha2.top();
			if (nom.compareTo(nome) == 1){
				pilha2.push(nome);
				System.out.println("teste");
			}
			System.out.println(pilha2.top());
		}
	}
	

}
