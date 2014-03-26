package huffman;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import arbolBinario.ArbolBinario;
import arbolBinario.NodoArbolBinario;
import bitString.BitString;

public class TextoCompactadoHuffman implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private BitString bits;
	
	private short numeroDeCaracteres;
	
	private InfoCaracter[] tabla;
	
	/**
	 * Constructor de la clase
	 * @param totalCaracteres Numero total de caracteres que tiene el texto
	 */
	public TextoCompactadoHuffman(int totalCaracteres) {
		bits=new BitString();
		tabla=new InfoCaracter[totalCaracteres];
		numeroDeCaracteres=0;
	}
	
	/**
	 * Constructor de la clase
	 * @param archivo Archivo a partir del cual se va a construir el texto compactado Huffman
	 * @throws IOException Se lanza si se produce un error de lectura o escritura
	 */
	public TextoCompactadoHuffman(File archivo) throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream(archivo));
		numeroDeCaracteres=in.readShort();
		tabla=new InfoCaracter[numeroDeCaracteres];
		for(int i=0;i<numeroDeCaracteres;i++){
			tabla[i]=new InfoCaracter(in);
		}
		bits=new BitString(in);
		in.close();
	}
	
	/**
	 * Metodo que se encarga de agregar un caracter a la tabla de codificacion
	 * @param info Caracter que se va a agregar
	 */
	public void agregarCaracterTabla(InfoCaracter info){
		tabla[numeroDeCaracteres++]=info;
	}
	
	/**
	 * Metodo que se encarga de agregar un caracter al texto
	 * @param info EL caracter que se va a agregar
	 */
	public void agregarCaracterTexto(InfoCaracter info) {
		bits.concatenar(info.darCodigo());
	}
	
	/**
	 * Metodo que se encarga de reconstruir un texto a partir de un arbol
	 * @return El texto que se obtuvo de la descompresion
	 */
	public Texto descomprimir(){
		ArbolBinario<Character> arbolHuffman=reconstruirArbol();
		StringBuilder buffer=new StringBuilder();
		NodoArbolBinario<Character>  aNodo=arbolHuffman.darRaiz();
		for(int i=0;i<bits.darLongitud();i++){
			aNodo=bits.estaEncendido(i)?aNodo.darDerecho():aNodo.darIzquierdo();
			if(aNodo.esHoja()){
				buffer.append(aNodo.darElemento().charValue());
				aNodo=arbolHuffman.darRaiz();
			}
		}
		return new Texto(buffer);
	}
	
	/**
	 * Metodo que se encarga de salvar la clase y sus componentes
	 * @param archivo lugar donde se llevara a cabo la escritura
	 * @throws IOException Se lanza si se presenta algun error de lectura o escritura
	 */
	public void salvar(File archivo) throws IOException{
		DataOutputStream out=new DataOutputStream(new FileOutputStream(archivo));
		out.writeShort(numeroDeCaracteres);
		for(int i=0;i<numeroDeCaracteres;i++){
			tabla[i].salvar(out);
		}
		bits.salvar(out);
		out.close();
		
	}
	
	/**
	 * Metodo que retorna el BitString
	 * @return El BitString del arbol
	 */
	public BitString darBitString(){
		return bits;
	}
	
	/**
	 * Metodo que se encarga de retornar el toString de la clase
	 */
	@Override
	public String toString() {
		String respuesta="";
		for(int i=0;i<numeroDeCaracteres;i++){
			respuesta+=tabla[i]+"\n";
		}
		return respuesta+bits;
	}
	
	/**
	 * Metodo que se encarga de reconstruir el arbol de Huffman
	 * @return Arbol binario de Huffman
	 */
	public ArbolBinario<Character> reconstruirArbol(){
		ArbolBinario<Character> arbol=new ArbolBinario<Character>();
		NodoArbolBinario<Character> raiz=new NodoArbolBinario<Character>(null);
		arbol.cambiarRaiz(raiz);
		for(int i=0;i<numeroDeCaracteres;i++){
			agregarHoja(raiz, tabla[i]);
		}
		return arbol;
	}
	
	/**
	 * Metodo que se encarga de agregar una hoja al arbol de Huffman
	 * @param raiz Nodo raiz donde se va a agregar la hoja
	 * @param car Informacion del caracter que se alojara en la hoja
	 */
	public void agregarHoja(NodoArbolBinario<Character> raiz,InfoCaracter car){
		BitString cod=car.darCodigo();
		int longitud=cod.darLongitud();
		for(int i=0;i<longitud;i++){
			if(cod.estaEncendido(i)){
				if(raiz.darDerecho()!=null){
					raiz=raiz.darDerecho();
				}else{
					NodoArbolBinario<Character> aNodo=new NodoArbolBinario<Character>(null);
					raiz.unirDerecho(aNodo);
					raiz=aNodo;
				}
			}else{
				if(raiz.darIzquierdo()!=null){
					raiz=raiz.darIzquierdo();
				}else{
					NodoArbolBinario<Character> aNodo=new NodoArbolBinario<Character>(null);
					raiz.unirIzquierdo(aNodo);
					raiz=aNodo;
				}
			}
		}
		raiz.asignarElemento(new Character(car.darCaracter()));
	}
	

}
