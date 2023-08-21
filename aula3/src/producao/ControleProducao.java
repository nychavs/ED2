package producao;

import fila.Fila;

public class ControleProducao {
	
	
	private Fila maquina01 = new Fila();
	private Fila maquina02 = new Fila();
	private Fila maquina03 = new Fila();


	public void adicionarPecaMaquina(int quantidadePecas) {
		for (int i=0; i<quantidadePecas; i++) {
			maquina01.adicionar("peca" + " " + i);	
		}
		exibeSituacaoMaquinas();	
	}
	
	public void processarMaquina(int maquina){
		switch (maquina) {
		case 1:
			if (maquina01.ehVazia()) {
				throw new IllegalArgumentException("nao ha pecas nessa maquina");			
			}else {
				int tamanho = maquina01.pegaTamanho();
				for (int i=1; i<=tamanho; i++) {
					maquina02.adicionar(maquina01.pegaElemento());	
					maquina01.remover();
				}
			}break;
		case 2:
			if (maquina02.ehVazia()) {
				throw new IllegalArgumentException("nao ha pecas nessa maquina");			
			}else {
				int tamanho = maquina02.pegaTamanho();
				for (int i=1; i<=tamanho; i++) {
					maquina03.adicionar(maquina02.pegaElemento());	
					maquina02.remover();
				}
			}break;
		case 3:
			if (maquina03.ehVazia()) {
				throw new IllegalArgumentException("nao ha pecas nessa maquina");			
			}else {
				int tamanho = maquina03.pegaTamanho();
				for (int i=1; i<=tamanho; i++) {
					maquina03.remover();
				}
			}break;
			default:
				System.out.println("Opcao incorreta");
		}
		exibeSituacaoMaquinas();
	}

	private void exibeSituacaoMaquinas() {
		System.out.println("\nmaquina 1 contem: " + maquina01.pegaTamanho() + " pecas.");
		System.out.println("maquina 2 contem: " + maquina02.pegaTamanho() + " pecas.");
		System.out.println("maquina 3 contem: " + maquina03.pegaTamanho() + " pecas.");
	}
	
	
	public int pegaTamanhoMaquina01() {
		return maquina01.pegaTamanho();
	}
	public int pegaTamanhoMaquina02() {
		return maquina02.pegaTamanho();
	}
	public int pegaTamanhoMaquina03() {
		return maquina03.pegaTamanho();
	}
}
