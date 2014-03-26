package huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Texto {
	
	private final static int MAXIMO_CARACTERES=256;
	
	private StringBuilder texto;
	
	/**
	 * Constructor de la clase
	 */
	public Texto(){
		texto = null;
	}
	
	/**
	 * Constructor de la clase
	 * @param elTexto Texto con el que se va a inicializar
	 */
	public Texto(String elTexto) {
		texto = new StringBuilder(elTexto);
	}
	
	/**
	 * Constructor de la clase
	 * @param elStringBuilder StringBuilder con el que se va a inicializar
	 */
	public Texto(StringBuilder elStringBuilder) {
		texto = elStringBuilder;
	}
	
	/**
	 * Constructor de la clase
	 * @param archivo Lugar de donde se va a tomar la informacion para incializar el texto
	 * @throws IOException Se lanza si hay problemas de lectura o escritura
	 */
	public Texto(File archivo) throws IOException{

		texto = new StringBuilder();
		BufferedReader read = new BufferedReader(new FileReader(archivo));
		String linea = read.readLine();
		while (linea != null) {
			texto.append(linea);

			linea = read.readLine();

			if (linea != null) {
				texto.append("\r\n");
			}
		}
		read.close();
	}
	
	/**
	 * Metodo que modifica el atributo texto 
	 * @param textoProcesar Valor nuevo que se le asignara a el atributo
	 */
	public void cambiarTexto(String textoProcesar){
		
	}
	
	/**
	 * Metodo que se encarga de dar la longitud del texto
	 * @return Logitud del texto 
	 */
	public int darLongitud(){
		if(texto==null){
			return 0;
		}else{
			return texto.length();
		}
	}

	/**
	 * Metodo que returna el Stringbuider
	 * @return StringBuilder texto
	 */
	public StringBuilder darStringBuilder(){
		return texto;
	}
	
	/**
	 * Metodo que se encarga de determinar si dos texos son iguales
	 * @param txt Texto contra el que se va a compar
	 * @return True si son iguales o false en caso contrario
	 */
	public boolean equals(Texto txt){
		return texto.toString().equals(txt.toString());
	}

	/**
	 * Metodo que se encarga de comprimir el texto obteniendo su representacion por frecuencia
	 * @return Un objeto con el texto comprimido
	 */
	public TextoCompactadoHuffman comprimirHuffman(){
		
		if(texto==null){
			return null;
		}
		
		NodoHuffman[] nodos=new NodoHuffman[MAXIMO_CARACTERES];
		
		
		for(int i=0;i<MAXIMO_CARACTERES;i++){
			nodos[i]=new NodoHuffman((char)i);
		}
		
		
		for(int i=0;i<texto.length();i++){
			nodos[texto.charAt(i)].registrarNuevo();
		}
		
		
		ListaHuffman lista=new ListaHuffman();
		int caracteresDiferentes=0;
		for(int i=0;i<MAXIMO_CARACTERES;i++){
			if(nodos[i].darFrecuencia()>0){
				lista.insertarOrdenado(nodos[i]);
				caracteresDiferentes++;
			}
		}
		
		lista.generarArbolHuffman();
		
		TextoCompactadoHuffman th=new TextoCompactadoHuffman(caracteresDiferentes);
		for(int i=0;i<MAXIMO_CARACTERES;i++){
			if(nodos[i].darFrecuencia()>0){
				th.agregarCaracterTabla(nodos[i].darInfo());
			}
		}
		
		for(int i=0;i<texto.length();i++){
			th.agregarCaracterTexto(nodos[texto.charAt(i)].darInfo());
		}
		
		return th; 
		
		
	}
	
	/**
	 * Metodo que se encarga de salvar la clase y sus componentes
	 * @param archivo archivo lugar donde se llevara a cabo la escritura
	 * @throws IOException Se lanza si se presenta algun error de lectura o escritura
	 */
	public void salvar(File archivo) throws IOException{
		PrintWriter out = new PrintWriter(archivo);
		out.print(texto.toString());
		out.close();
	}
	
	/**
	 * Metodo que se encarga de retornar el toString de la clase
	 */
	public String toString(){
		return texto.toString();
	}
	
}
