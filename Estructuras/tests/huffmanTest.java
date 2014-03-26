import huffman.Texto;
import huffman.TextoCompactadoHuffman;
import junit.framework.TestCase;


public class huffmanTest extends TestCase {
	
	private String textoAComprimir;
	
	private Texto texto;
	
	private TextoCompactadoHuffman comprimido;
	
	
	public void setupEscenario1(){
		 textoAComprimir="The quick brown fox jumped over the lazy dog";
		 texto=new Texto(textoAComprimir);
		 comprimido=texto.comprimirHuffman();
	}
	
	public void testDescomprimir(){
		setupEscenario1();
		System.out.println(texto.toString());
		assertEquals(texto.toString(), comprimido.descomprimir().toString());
		System.out.println(comprimido.descomprimir().toString());
	}
	
	public void testLista(){
		setupEscenario1();
		System.out.println(comprimido.toString());
	}

}
