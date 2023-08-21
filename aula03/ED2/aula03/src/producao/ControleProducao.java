import
//import pilha.Pilha;

public class ControleProducao {
	private Fila maquina01 = new Fila();
	private Fila maquina02 = new Fila();
//	private Fila maquina03 = new Fila();
//	fazer private maquina01
//	maquina01 = new fila() e ai usa td com this

	public void adicionarPecaMaquina(int quantidadePecas) {
		for (int i=1; i<=quantidadePecas; i++) {
			maquina01.adicionar("peca" + " " + i);
			System.out.println(maquina01.pegaElemento());
		}
	}
	
	public void processarMaquina(int maquina){
		if (maquina == 1) {
			if (maquina01.ehVazia()) {
				throw new IllegalArgumentException("nao ha pecas nessa maquina");			
			}else{
				for (int i=1; i<=maquina01.pegaTamanho(); i++) {
					maquina02.adicionar(maquina01.pegaElemento());	
					maquina01.remover();
					
					System.out.println("maquina 02 " + maquina02.pegaElemento());
				}
			}
			
		}
	}

	public Object retornaPecasMaquina() {
		String pecas[] = null;
		for (int i=0; i<maquina01.pegaTamanho(); i++) {
			pecas[i] = (String) maquina01.pegaElemento();
			
		}
		return pecas;
	}
	
	public int pegaTamanhoMaquina01() {
		return maquina01.pegaTamanho();
	}
	public int pegaTamanhoMaquina02() {
		return maquina02.pegaTamanho();
	}
}
