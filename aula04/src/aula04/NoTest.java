package aula04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void testRetornaEhFolhaNaoTemFilhos() {
		
		No no7 = new No(7, null, null);
		
		assertTrue(no7.ehFolha());
	}
	
	@Test
	void testRetornaNaoEhFolhaTemFilhoDireito() {
		
		No no10 = new No(10, null, null);
		No no7 = new No(7, no10, null);
	
		assertTrue(no10.ehFolha());
		assertFalse(no7.ehFolha());
	}
	
	@Test
	void testRetornaNaoEhFolhaTemFilhoEsquerdo() {
		
		No no5 = new No(5, null, null);
		No no7 = new No(7, null, no5);
	
		assertTrue(no5.ehFolha());
		assertFalse(no7.ehFolha());
	}


}
