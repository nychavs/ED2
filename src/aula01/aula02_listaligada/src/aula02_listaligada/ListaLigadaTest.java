package aula02_listaligada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// lista vazia
// lista com elemento
// lista com mais de um elemento

class ListaLigadaTest {

	@Test
	void testAdicionarNoComecoListaVazia() {

		ListaLigada lista = new ListaLigada();

		lista.adicionaNoComeco("Fernando");

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());

		
	}

	@Test
	void testAdicionarNoComecoComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionaNoComeco("Fernando");
		lista.adicionaNoComeco("Maria");
		lista.adicionaNoComeco("Carlos");

		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Carlos", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());

	}

	@Test
	void testAdicionarNoFinalListaVazia() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Fernando", lista.pegaUltima());


	}

	@Test
	void testAdicionarNoFinalComElementos() {

		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Maria");
		lista.adicionaNoFinal("Carlos");

		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Fernando", lista.pegaPrimeiro());
		assertEquals("Carlos", lista.pegaUltima());

	}
	
	@Test
	void testPegarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(-1));
		
	}
	
	@Test
	void testPegarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pega(6));
	}
	
	@Test
	void testPegarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Maria");
		lista.adicionaNoFinal("Carlos");

		assertEquals("Fernando", lista.pega(0));
		assertEquals("Maria", lista.pega(1));
		assertEquals("Carlos", lista.pega(2));
		
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaNegativa() {
		
		ListaLigada lista = new ListaLigada();
		
		lista.adicionaNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicinaNaPosicao("Fernando", -1));
		
	}
	
	@Test
	void testAdicionarNaPosicaoInvalidaQuantidadeElementos() {
	
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Carlos");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicinaNaPosicao("Fernando", 2));
		
	}
	
	@Test
	void testAdicionarNaPosicaoValida() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Maria");
		lista.adicionaNoFinal("Carlos");

		lista.adicinaNaPosicao("Rose", 1);
		
		assertEquals("Fernando", lista.pega(0));
		assertEquals("Rose", lista.pega(1));
		assertEquals("Maria", lista.pega(2));
		assertEquals("Carlos", lista.pega(3));
		
	}
	
	@Test
	void testContemListaVazia() {
		
		ListaLigada lista = new ListaLigada();
		
		assertFalse(lista.contem("Mauro"));
		
	}
	
	@Test
	void testContemNaoAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Maria");
		lista.adicionaNoFinal("Carlos");
		
		assertFalse(lista.contem("Mauro"));
		
	}
	
	@Test
	void testContemAcharLista() {
		
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Maria");
		lista.adicionaNoFinal("Carlos");
		
		assertTrue(lista.contem("Maria"));
		
		
	}
	
	@Test
	void testRemoverNoFinalListaVazia() {
		ListaLigada lista = new ListaLigada();
		assertThrows(IllegalArgumentException.class, () -> lista.removeNoFinal());
	}
	
	@Test
	void testRemoverNoFinalListaComVariosElementos() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Lara");
		lista.removeNoFinal();
		
		assertFalse(lista.contem("Lara"));
		assertEquals(1, lista.pegaTotalElementos());
	}
	
	@Test
	void testRemoverNoFinalListaComUmElemento() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Lara");
		lista.removeNoFinal();
		
		assertFalse(lista.contem("Lara"));
		assertEquals(0, lista.pegaTotalElementos());
	}
	
	@Test
	void testRemoverNoComecoListaVazia() {
		ListaLigada lista = new ListaLigada();
		assertThrows(IllegalArgumentException.class, () -> lista.removeNoComeco());
	}
	
	@Test
	void testRemoverNoComecoListaComUmElemento() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Lara");
		lista.removeNoComeco();
		
		assertFalse(lista.contem("Lara"));
		assertEquals(0, lista.pegaTotalElementos());
		
	}
	
	@Test
	void testRemoverNoComecoListaComVariosElementos() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Lara");
		lista.adicionaNoFinal("Fernando");
		lista.removeNoComeco();
		
		assertFalse(lista.contem("Lara"));
		assertEquals(1, lista.pegaTotalElementos());
		
	}
	
	
	@Test
	void testRemoverPosicaoVariosElementos() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");
		lista.adicionaNoFinal("Lara");
		lista.adicionaNoFinal("Maria");
		
		assertEquals("Lara", lista.pega(1));
		
		lista.removerPosicao(1);
		
		assertFalse(lista.contem("Lara"));
		assertEquals(2, lista.pegaTotalElementos());
	}
	
	@Test
	void testRemoverPosicaoUmElemento() {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoFinal("Fernando");

		assertEquals("Fernando", lista.pega(0));
		
		lista.removerPosicao(0);
		
		assertFalse(lista.contem("Fernando"));
		assertEquals(0, lista.pegaTotalElementos());
	}
	
	@Test
	void testRemoverPosicaoListaVazia() {
		ListaLigada lista = new ListaLigada();
		assertThrows(IllegalArgumentException.class, () -> lista.removerPosicao(0));
	}
	
	
	
	
	
	
	
	


}
