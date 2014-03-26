

import tablaHashing.TablaHashing;
import junit.framework.TestCase;
import lista.Lista;

public class testTablaHashing extends TestCase{
	private String llave1;
	private String llave2;
	private String llave3;
	private String elemento1;
	private String elemento2;
	private String elemento3;
	private TablaHashing<String, String> tabla;

	public void setupEscenario1(){
		tabla=new TablaHashing(3);
		llave1="LlaveUno";
		llave2="LlaveDos";
		llave3="LLaveTres";
		elemento1="ElementoUno";
		elemento2="ElementoDos";
		elemento3="ElementoTres";
	}
	public void setupEscenario2(){
		tabla=new TablaHashing(1);
		llave1="LlaveUno";
	}
	public void setupEscenario3(){
		tabla=new TablaHashing(2);
		llave1="A";
		llave2="L";
		llave3="Z";
		elemento1="ElementoUno";
		elemento2="ElementoDos";
		elemento3="ElementoTres";
	}
	public void testAgregar1(){
		setupEscenario1();
		boolean bool1= tabla.agregar(llave1, elemento1);
		boolean bool2=tabla.agregar(llave2, elemento2);
		boolean bool3=tabla.agregar(llave3, elemento3);
		assertTrue("No esta agregando correctamente", bool1);
		assertTrue("No esta agregando correctamente", bool2);
		assertTrue("No esta agregando correctamente", bool3);
	}
	public void testAgregar2(){
		setupEscenario1();
		tabla.agregar(llave1, elemento1);
		tabla.agregar(llave2, elemento2);
		tabla.agregar(llave3, elemento3);
		assertEquals("No esta agregando correctamente", 2, tabla.darTamanio());
	}
	public void testBuscar1(){
		setupEscenario1();
		tabla.agregar(llave1, elemento1);
		tabla.agregar(llave2, elemento2);
		tabla.agregar(llave3, elemento3);
		Lista<String> temp=tabla.buscar(llave1);
		Lista<String> temp2=tabla.buscar(llave3);
		assertEquals("No esta buscando y/o agregando correctamente", 2, temp.darLongitud());
		assertEquals("No esta buscando y/o agregando correctamente", 1, temp2.darLongitud());
	}
	public void testBuscar2(){
		setupEscenario2();
		assertNull("No esta buscando correctamente", tabla.buscar(llave1));
	}
	public void testAgregarYBuscar1(){
		setupEscenario1();
		tabla.agregar(llave1, elemento1);
		tabla.agregar(llave2, elemento2);
		tabla.agregar(llave3, elemento3);
		assertNotNull("No esta agregando y/o buscando correctamente", tabla.buscar(llave1).dar(0));
	}
//	public void testAgregarYEliminar1(){
//		setupEscenario1();
//		tabla.agregar(llave1, elemento1);
//		tabla.agregar(llave2, elemento2);
//		tabla.eliminar(llave1,elemento1);
//		assertNull("No esta eliminando y/o agregando correctamente", tabla.buscar(llave1));
//		assertEquals(elemento2, tabla.buscar(llave2));
//	}
//	public void testAgregarYEliminar2(){
//		setupEscenario2();
//		tabla.eliminar(llave1,elemento1);
//		assertNull("No se esta eliminando y/o agregando correctamente", tabla.buscar(llave1));
//	}
//	public void testReHash(){
//		setupEscenario3();
//		tabla.agregar(llave1, elemento1);
//		tabla.agregar(llave2, elemento2);
//		assertEquals("No esta bien el rehash", 5, tabla.darCapacidad());
//	}
}
