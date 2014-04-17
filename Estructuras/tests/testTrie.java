import trie.Trie;
import junit.framework.TestCase;


public class testTrie extends TestCase{
	
	private Trie<String> sintactico;
	
	private void setupEscenario1(){
		sintactico = new Trie<String>();
	}
	
	private void setupEscenario2(){
		sintactico = new Trie<String>();
		sintactico.agregar("amor", "Sentimiento hacia alguien");
		sintactico.agregar("amada", "Persona amada por otra");
		sintactico.agregar("elefante", "Animal gris y muy grande");
		sintactico.agregar("zorro", "Animal rojo que canta");
		sintactico.agregar("elegante", "Con porte, clase");
		sintactico.agregar("cabeza", "Parte de la anatomia humana");
		sintactico.agregar("cabezazo", "Golpe propiciado por una cabeza");
		sintactico.agregar("zorra", "Esposa del zorro");
			
		}
	
	private void setupEscenario3(){
		
	}
	
	public void testAgregar(){
		setupEscenario1();
		String agregar1=sintactico.agregar("amor", "Sentimiento hacia alguien");
		String agregar2=sintactico.agregar("amada", "Persona amada por otra");
		String agregar3=sintactico.agregar("elefante", "Animal gris y muy grande");
		String agregar4=sintactico.agregar("zorro", "Animal rojo que canta");
		String agregar5=sintactico.agregar("elegante", "Con porte, clase");
		String agregar6=sintactico.agregar("cabeza", "Parte de la anatomia humana");
		String agregar7=sintactico.agregar("cabezazo", "Golpe propiciado por una cabeza");
		String agregar8=sintactico.agregar("zorra", "Esposa del zorro");
		assertEquals("Sentimiento hacia alguien", agregar1);
		assertEquals("Persona amada por otra", agregar2);
		assertEquals("Animal gris y muy grande", agregar3);
		assertEquals("Animal rojo que canta", agregar4);
		assertEquals("Con porte, clase", agregar5);
		assertEquals("Parte de la anatomia humana", agregar6);
		assertEquals("Golpe propiciado por una cabeza", agregar7);
		assertEquals("Esposa del zorro", agregar8);
	}
	
	public void testBuscar(){
		setupEscenario2();
		assertEquals("Animal rojo que canta", sintactico.buscar("zorro"));
		assertEquals("Con porte, clase",sintactico.buscar("elegante"));
		assertNull(sintactico.buscar("ella"));
	}
	
	public void testEliminar(){
		setupEscenario2();
		assertEquals("Animal rojo que canta", sintactico.eliminar("zorro"));
		assertEquals("Con porte, clase",sintactico.eliminar("elegante"));
		assertNull(sintactico.buscar("ella"));
	}

}
