import static org.junit.Assert.*;
import junit.framework.TestCase;
import lista.Lista;



public class listaTest extends TestCase {

	private Lista<String> lista;
	private String primerString;
	private String segundoString;
	private String tercerString;
	private String cuartoString;
	private String unicoString;
	
	
	
	public void setupEscenario1(){
		lista = new Lista<String>();
		primerString="Primero";
		segundoString="Segundo";
		tercerString="Tercero";
		cuartoString="Cuarto";
	}
	
	public void setupEscenario2(){
		lista = new Lista<String>();
	}
	
	public void setupEscenario3(){
		lista = new Lista<String>();
		primerString="Primero";
		segundoString="Segundo";
		tercerString="Tercero";
		cuartoString="Cuarto";
		lista.agregar(primerString);
		lista.agregar(segundoString);
		lista.agregar(tercerString);
		lista.agregar(cuartoString);
	}
	
	public void testDarLongitud(){
		setupEscenario2();
		int longitud = lista.darLongitud();
		assertEquals(0, longitud);
	}
	
	public void testAgregar(){
		setupEscenario2();
		unicoString="Solo Yo";
		assertEquals(true, lista.agregar(unicoString));
		assertEquals(unicoString, lista.dar(0));
		String unicoString2="otro yo";
		String unicoString3="otro yo 2";
		lista.agregar(unicoString2);
		lista.agregar(unicoString3);
		assertEquals(unicoString2, lista.dar(1));
		
	}
	
	public void testClear(){
		setupEscenario3();
		lista.clear();
		assertNull(lista.dar(0));
		assertNull(lista.dar(1));
		assertNull(lista.dar(2));
		assertNull(lista.dar(3));
		
	}
	
	public void testContiene(){
		
		setupEscenario3();
		assertEquals(true, lista.contiene(primerString));
		assertEquals(true, lista.contiene(segundoString));
		assertEquals(true, lista.contiene(tercerString));
		assertEquals(true, lista.contiene(cuartoString));
		lista.eliminar(primerString);
		assertEquals(false, lista.contiene(primerString));
		
	}
	
	public void testEstaVacia(){
		setupEscenario3();
		assertEquals(false, lista.estaVacia());
		setupEscenario1();
		assertEquals(true, lista.estaVacia());
		
	}
	
	public void testEliminar(){
		
		setupEscenario3();
		assertEquals(4,lista.darLongitud());
		assertEquals(primerString, lista.eliminar(0));
		assertEquals(3,lista.darLongitud());
		assertEquals(true,lista.eliminar(segundoString));
		assertEquals(2,lista.darLongitud());
		
	}
	
	public void testCambiar(){
		
		setupEscenario1();
		lista.agregar(primerString);
		lista.agregar(segundoString);
		assertEquals(primerString, lista.dar(0));
		assertEquals(tercerString,lista.cambiar(0, tercerString));
		assertNotNull(lista.dar(0));
		//lista.cambiar(segundoString, cuartoString);
		//assertEquals(cuartoString, lista.dar(1));
		
	}
	
	

}
