package producao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestControleProducao {

	@Test
	void testInserir() {
		ControleProducao maquina = new ControleProducao();
		maquina.adicionarPecaMaquina(6);
		
		assertEquals(6, maquina.pegaTamanhoMaquina01());
		assertEquals(0, maquina.pegaTamanhoMaquina02());
		assertEquals(0, maquina.pegaTamanhoMaquina03());
	}
	
	@Test
	void testProcessarVazia() {
		ControleProducao maquina = new ControleProducao();
		
		assertThrows(IllegalArgumentException.class, () -> maquina.processarMaquina(1));
	}
	
	@Test
	void testProcessar() {
		ControleProducao maquina = new ControleProducao();
		maquina.adicionarPecaMaquina(6);
		maquina.processarMaquina(1);
		
		assertEquals(0, maquina.pegaTamanhoMaquina01());
		assertEquals(6, maquina.pegaTamanhoMaquina02());
		assertEquals(0, maquina.pegaTamanhoMaquina03());
	}
	
	@Test
	void testProcessarMaquina3() {
		ControleProducao maquina = new ControleProducao();
		maquina.adicionarPecaMaquina(6);
		maquina.processarMaquina(1);
		maquina.processarMaquina(2);
		
		assertEquals(0, maquina.pegaTamanhoMaquina01());
		assertEquals(0, maquina.pegaTamanhoMaquina02());
		assertEquals(6, maquina.pegaTamanhoMaquina03());
		
		maquina.processarMaquina(3);
		assertEquals(0, maquina.pegaTamanhoMaquina03());

	}

}
