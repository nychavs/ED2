package ordem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOrdenacao {

	@Test
	void testInserirNaOrdem() {
		OrdenarPilha pilha = new OrdenarPilha();
		pilha.inserirNaOrdemPilha("ana");
		pilha.inserirNaOrdemPilha("bru");
		pilha.inserirNaOrdemPilha("car");
		pilha.inserirNaOrdemPilha("ddd");
		pilha.inserirNaOrdemPilha("ee");
		pilha.inserirNaOrdemPilha("ff");
		
		assertEquals(6, pilha.pegaTamanhoPilha1());
	}
	@Test
	void testInserirForaDaOrdem() {
		OrdenarPilha pilha = new OrdenarPilha();
		pilha.inserirNaOrdemPilha("ana");
		pilha.inserirNaOrdemPilha("car");
		pilha.inserirNaOrdemPilha("bru");
		
		assertEquals(3, pilha.pegaTamanhoPilha3());
	}

}
