package producao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestControleProducao {

	@Test
	void testInserir() {
		ControleProducao maquina01 = new ControleProducao();
		maquina01.adicionarPecaMaquina(2);
		
		assertEquals(2, maquina01.pegaTamanhoMaquina01());
	}
	
	@Test
	void testProcessarVazia() {
		ControleProducao maquina01 = new ControleProducao();
		
		assertThrows(IllegalArgumentException.class, () -> maquina01.processarMaquina(1));
	
	}
	

	void testProcessar() {
		ControleProducao maquina01 = new ControleProducao();
		maquina01.adicionarPecaMaquina(2);
		maquina01.processarMaquina(1);
		assertEquals(0, maquina01.pegaTamanhoMaquina01());
	
	}

}
