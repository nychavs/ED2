package aula02_listaligada;

public class ListaLigada {
	
	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;
	
	public void adicionaNoComeco(Object novoElemento) {
		
		if (eh_vazia()) {
			Celula nova = new Celula(novoElemento);
			this.primeira = nova;
			this.ultima = nova;
		}
		else {
			Celula nova = new Celula(novoElemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}
	
	public void removerPosicao(int posicao) {
		if (!posicaoValidaRecuperar(posicao)) {
			throw new IllegalArgumentException("posicao invalida");
		}
		else if (eh_vazia()) {
			throw new IllegalArgumentException("lista vazia");
		}
		else if (posicao == totalDeElementos - 1) {
			removeNoFinal();
		}
		else if (posicao == 0) {
			removeNoComeco();
		}
		else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula proxima = pegaCelula(posicao + 1);
			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);
			totalDeElementos --;
		}
	}
	
	public void removeNoComeco() {
		if (eh_vazia()) {
			throw new IllegalArgumentException("lista vazia");
		}
		else if (totalDeElementos == 1) {
			this.ultima = null;
			this.primeira = null;
			this.totalDeElementos--;
		}
		else {
			Celula proxima = (this.primeira.getProximo());
			this.primeira = proxima;
			this.totalDeElementos--;
		}
	} 
	
	public void removeNoFinal() {
		if (eh_vazia()) {
			throw new IllegalArgumentException("lista vazia");
		}
		else if (totalDeElementos == 1) {
			this.ultima = null;
			this.primeira = null;
			this.totalDeElementos--;
		}
		else {
			Celula anterior = (this.ultima.getAnterior());
			this.ultima = anterior;
			this.ultima.setProximo(null);
			this.totalDeElementos--;
		}
		}
	
	public void adicionaNoFinal(Object novoElemento) {
		
		if (eh_vazia()) {
			adicionaNoComeco(novoElemento);
		}
		else {
			Celula nova = new Celula(novoElemento);
			this.ultima.setProximo(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
		
	}
	
	private boolean posicaoValidaInsercao(int posicao) {
		return (posicao >= 0) && (posicao <= this.totalDeElementos);
	}
	
	public void adicinaNaPosicao(Object novoElemento, int posicao) {
		
		if (!posicaoValidaInsercao(posicao)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		
		if (posicao == 0) {
			adicionaNoComeco(novoElemento);
		}
		else if (posicao == this.totalDeElementos) {
			adicionaNoFinal(novoElemento);
		}
		else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula proxima = anterior.getProximo();
			
			Celula nova = new Celula(novoElemento, proxima);
			nova.setAnterior(anterior);
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
		
	}
	
	private boolean eh_vazia() {
	    return  totalDeElementos == 0;
	
	}
	
	public int pegaTotalElementos() {
		return totalDeElementos;
	}
	
	public Object pegaPrimeiro() {
		return this.primeira.getElemento();
	}
	
	public Object pegaUltima() {
		return this.ultima.getElemento();
	}
	
	private boolean posicaoValidaRecuperar(int posicao) {
		return (posicao >= 0) && (posicao < this.totalDeElementos);
	}
	
	private Celula pegaCelula(int posicao) {
		
		if (!posicaoValidaRecuperar(posicao)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		
		Celula atual = this.primeira;
		
		for (int i=0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
			
	}
	
	public Object pega(int posicao) {
		
		return pegaCelula(posicao).getElemento();
		
	}
	
	public boolean contem (Object elementoBuscado) {
		
		Celula atual = this.primeira;
		
		while (atual != null) {
			
			if (atual.getElemento().equals(elementoBuscado)) {
				return true;
			}
			atual = atual.getProximo();
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
