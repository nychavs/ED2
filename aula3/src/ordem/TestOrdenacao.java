package ordem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOrdenacao {

	@Test
	void testInserirNaOrdem() {
		OrdenarPilha pilha = new OrdenarPilha();
		pilha.inserirNaOrdemPilha("ana");
		pilha.inserirNaOrdemPilha("bru");
	}

	@Test
	void testInserirForaDaOrdem() {
		
	}

}
