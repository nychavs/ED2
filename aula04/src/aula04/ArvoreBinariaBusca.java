package aula04;

public class ArvoreBinariaBusca {

	private No raiz;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNosDosSubNos(No noReferencia) {

		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDosSubNos(noReferencia.getEsquerdo()) + 1
					+ pegaQuantidadeNosDosSubNos(noReferencia.getDireito());
		}
	}
	
	public int pegaQuantidadeNosArvore() {
		return pegaQuantidadeNosDosSubNos(this.raiz);
	}
	
	public int pegaAlturaNo(No noReferencia) {
		if (ehVazia()) {
			return 0;
		}
		else {
			return pegaAlturaNoSubNo(noReferencia) - 1;
		}
	}
	
	public int pegaAlturaNoSubNo (No noReferencia) {
		
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaNoSubNo(noReferencia.getDireito());
		int alturaEsquerda = pegaAlturaNoSubNo(noReferencia.getEsquerdo());
		
		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}
	
	public int pegaAlturaArvore() {
		return pegaAlturaNo(raiz);
	}
	
	public int pegaProfundidadeDoNo(No noReferencia) {
		return 0;
	}
	
	public boolean contemValor(int valorNo) {
		return percorre(raiz, valorNo);
	}
	
	public boolean percorre(No noRef, int valorNo) {

		if (noRef.getValor() == valorNo) {
			return true;
		
		}else if (noRef.getValor() <= valorNo) {
			return percorre(noRef.getEsquerdo(), valorNo);
			
		}else if (noRef.getValor() > valorNo){
			return percorre(noRef.getDireito(), valorNo);
			
		}else {
			return false;
		}
	
	}
	
	
	
	
	


}
