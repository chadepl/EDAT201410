package huffman;

import java.io.Serializable;

public class NodoHuffman implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private InfoCaracter info;
	
	private int frecuencia;
	
	public NodoHuffman nodoDerecho;
	
	public NodoHuffman nodoIzquierdo; 
	
	public NodoHuffman nodoAnterior;
	
	public NodoHuffman nodoSiguiente;
	
	/**
	 * Metodo constructor del nodo de Huffman
	 * @param c Caracer que se va a agregar al nodo, es decir un nodo hoja
	 */
	public NodoHuffman(char c){
		info=new InfoCaracter(c);
		frecuencia=0;
		nodoAnterior=null;
		nodoSiguiente=null;
		nodoDerecho=null;
		nodoIzquierdo=null;
		
	}
	
	/**
	 * Metodo constructor del nodo de Huffman
	 * @param nodoIzq Izquierda del nodo
	 * @param nodoDer Derecha del nodo
	 */
	public NodoHuffman(NodoHuffman nodoIzq, NodoHuffman nodoDer) {
		info=new InfoCaracter('*');
		frecuencia=nodoIzq.frecuencia+nodoDer.frecuencia;
		nodoAnterior=null;
		nodoSiguiente=null;
		nodoDerecho=nodoDer;
		nodoIzquierdo=nodoIzq;
	}

	/**
	 * Metodo constructor del nodo de Huffman
	 * @param nodoIzq Izquierda del nodo
	 */
	public NodoHuffman(NodoHuffman nodoIzq) {
		info=new InfoCaracter('*');
		frecuencia=nodoIzq.frecuencia;
		nodoAnterior=null;
		nodoSiguiente=null;
		nodoDerecho=null;
		nodoIzquierdo=nodoIzq;
	}
	
	/**
	 * Metodo que registra una nueva ocurrencia del el caracter aumentando su frecuencia en uno
	 */
	public void registrarNuevo(){
		frecuencia++;
	}
	
	/**
	 * Metodo que retorna la frecuencia del caracter en el nodo 
	 * @return La frecuencia
	 */
	public int darFrecuencia(){
		return frecuencia;
	}
	
	/**
	 * Metodo que devuelve la informacion de caracter del elemento del nodo 
	 * @return Informacion del Caracter
	 */
	public InfoCaracter darInfo(){
		return info;
	}
	
	/**
	 * Metodo que da el nodo izquierdo
	 * @return El nodo izquierdo
	 */
	public NodoHuffman darIzquierda(){
		return nodoIzquierdo;
	}
	
	/**
	 * Metodo que da el nodo derecho
	 * @return El nodo derecho
	 */
	public NodoHuffman darDerecha() {
		return nodoDerecho;
	}

	/**
	 * Metodo que da el nodo siguiente
	 * @return El nodo siguiente
	 */
	public NodoHuffman darSiguiente() {
		return nodoSiguiente;
	}

	/**
	 * Metodo que da el nodo anterior
	 * @return El nodo anterior
	 */
	public NodoHuffman darAnterior() {
		return nodoAnterior;
	}
	
	/**
	 * Metodo que se encarga de insertar un nodo antes de otro
	 * @param nodo Nodo que se va a insertar despues
	 */
	public void insertarAntes(NodoHuffman nodo){
		nodo.nodoSiguiente=this;
		nodo.nodoAnterior=nodoAnterior;
		if(nodoAnterior!=null){
			nodoAnterior.nodoSiguiente=nodo;
		}
		nodoAnterior=nodo;
	}
	
	/**
	 * Metodo que se encarga de insertar un nodo despues de otro 
	 * @param nodo Nodo que se va a insertar despues
	 */
	public void insertarDespues(NodoHuffman nodo) {
		nodo.nodoSiguiente=nodoSiguiente;
		nodo.nodoAnterior=this;
		if(nodoSiguiente!=null){
			nodoSiguiente.nodoAnterior=nodo;
		}
		nodoSiguiente=nodo;
	}
	
	/**
	 * Metodo que desconecta el primer nodo de un arbol de Huffman  
	 * @return El nodo que fue desconectado
	 */
	public NodoHuffman desconectarPrimero(){
		NodoHuffman p=nodoSiguiente;
		nodoSiguiente=null;
		if(p!=null){
			p.nodoAnterior=null;
		}
		return p;
		
	}
	
	/**
	 * Metodo que genera los codigos a partir de un arbol de huffman recorriendo la izquierda y la derecha de
	 * manera recursiva
	 */
	public void generarCodigos(){
		if (nodoDerecho != null) {
			nodoDerecho.info.asignarCodigo(info, true);
			nodoDerecho.generarCodigos();
			
		}
		if (nodoIzquierdo != null) {
			nodoIzquierdo.info.asignarCodigo(info, false);
			nodoIzquierdo.generarCodigos();
		}
	}
	
	/**
	 * Metodo que se encarga de retornar el toString de la clase
	 */
	public String toString(){
		return info +" ("+frecuencia+") ";
	}
	
	

}
