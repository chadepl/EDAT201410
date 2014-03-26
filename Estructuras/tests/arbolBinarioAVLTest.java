import java.util.Iterator;





import arbolBinAVL.ArbolBinAVL;
import junit.framework.TestCase;
import junit.framework.TestCase;
import lista.Lista;

public class arbolBinarioAVLTest extends TestCase{

	private String[] letras;

	/**
	 * Arbol de strings para pruebas.
	 */
	private ArbolBinAVL<String> arbolStrings;

	/**
	 * Arbol de Strings para pruebas de iteradores.
	 */
	private ArbolBinAVL<String> arbolIterator;

	/**
	 * Iterador del arbol.
	 */
	private Iterator<String> iterador;

	/**
	 * Corre el esenacio base, a-z
	 */
	public void setupEscenario1(){
		letras=new String[26];
		arbolStrings=new ArbolBinAVL<String>();
		for(int i = 0;i<letras.length;i++){
			int a = 65+i;
			String ascii=Character.toString((char)a);
			letras[i]=ascii;
			arbolStrings.agregar(ascii);
		}
	}

	/**
	 * Corre el escenario de un solo elemento.
	 */
	public void setupEscenario2(){
		arbolStrings=new ArbolBinAVL<String>();
		arbolStrings.agregar("A");
	}

	/**
	 * Corre el escenario de un arbol vacio.
	 */
	public void setupEscenario3(){
		arbolStrings=new ArbolBinAVL<String>();
	}

	/**
	 * Corre el escenario de un caso de A, B, C
	 */
	public void setupEscenario4(){
		arbolIterator=new ArbolBinAVL<String>();
		arbolIterator.agregar("B");
		arbolIterator.agregar("A");
		arbolIterator.agregar("C");
	}

	/**
	 * Corre el escenario para probar el iterador in orden.
	 */
	public void setupInOrden(){
		setupEscenario4();
		iterador=arbolIterator.iterator();
	}

	/**
	 * Corre el escenario para probar pre orden.
	 */
	public void setupPreOrden(){
		setupEscenario4();
		iterador=arbolIterator.iteratorPreOrden();
	}

	/**
	 * Corre el escenario para probar post orden.
	 */
	public void setupPostOrden(){
		setupEscenario4();
		iterador=arbolIterator.iteratorPostOrden();
	}

	/**
	 * Test para probar tanto el m��todo agregar como el buscar caso 1.
	 */
	public void testAgregarYBuscar1(){
		setupEscenario1();
		for(int i=0;i<25;i++){
			int a = 65+i;
			String ascii=Character.toString((char)a);
			assertEquals(ascii, arbolStrings.buscar(ascii));
		}
	}

	/**
	 * Test para probar tanto el m��todo agregar como el buscar caso 2.
	 */
	public void testAgregarYBuscar2(){
		setupEscenario2();
		assertEquals("No se esta agregando y/o buscando correctamente", "A",arbolStrings.buscar("A"));
	}

	/**
	 * Test para probar el m��toodo buscar.
	 */
	public void testBuscar(){
		setupEscenario3();
		assertNull("No esta buscando correctamente", arbolStrings.buscar("B"));
	}

	/**
	 * Test para los m��todos agregar y eliminar caso 1.
	 */
	public void testAgregarYEliminar1(){
		setupEscenario1();
		for(int i=0;i<25;i++){
			int a = 65+i;
			String ascii=Character.toString((char)a);
			arbolStrings.eliminar(ascii);
			assertNull(arbolStrings.buscar(ascii));
		}
	}

	/**
	 * Test para los m��todos agregar y eliminar caso 2.
	 */
	public void testAgregarYEliminar2(){
		setupEscenario2();
		String eliminado=arbolStrings.eliminar("A");
		String deleted=arbolStrings.buscar("A");
		assertEquals("No se esta agregando y/o eliminando correctamente", "A", eliminado );
		assertNull(deleted);
	}

	/**
	 * Test para eliminar.
	 */
	public void testEliminar(){
		setupEscenario3();
		assertNull(arbolStrings.eliminar("A"));
	}

	/**
	 * Test para el iterador en orden.
	 */
	public void testIteratorInOrden(){
		setupInOrden();
		int i=65;
		while(iterador.hasNext()){
			String temp=iterador.next();
			String ascii=Character.toString((char)i);
			assertEquals("No esta iterando correctamente", ascii, temp);
			i++;
		}
	}

	/**
	 * Test para el iterador en post orden.
	 */
	public void testIteratorPostOrden(){
		setupPostOrden();
		Lista<String> lTemp=new Lista<String>();
		lTemp.agregar("A");
		lTemp.agregar("C");
		lTemp.agregar("B");
		int i=0;
		while(iterador.hasNext()){
			String temp=iterador.next();
			String dTemp=lTemp.dar(i);
			assertEquals("No esta iteranddo en Post Orden adecuadamente", dTemp, temp);
			i++;
		}
	}

	/**
	 * Test para el iterador en pre orden.
	 */
	public void testIteratorPreOrden(){
		setupPreOrden();
		Lista<String> lTemp=new Lista<String>();
		lTemp.agregar("B");
		lTemp.agregar("A");
		lTemp.agregar("C");
		int i=0;
		while(iterador.hasNext()){
			String temp=iterador.next();
			String dTemp=lTemp.dar(i);
			assertEquals("No esta iteranddo en Post Orden adecuadamente", dTemp, temp);
			i++;
		}
	}
	
	/**
	 * Test para saber si se esta cumpliendo que el arbol es AVL.
	 */
	public void testEsAVL(){
		setupEscenario1();
		assertTrue(arbolStrings.darRaiz().esAVL());
	}
}

