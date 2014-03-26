

import huffman.Texto;
import huffman.TextoCompactadoHuffman;

public class huffman {
	public static void main(String[] args) {
		Texto texto=new Texto("Hola que tal");
		System.out.println(texto.toString());
		TextoCompactadoHuffman huffman=texto.comprimirHuffman();
		System.out.println(huffman.descomprimir().toString());
	}
}
