package arbolBinario;

import java.util.Iterator;

import lista.Lista;



public class IteratorArbolBinario<T extends Comparable<T>> {

	/**
	 * Raíz del árbol a iterar.
	 */
	private NodoArbolBinario<T> raiz;
	
	//------------------
	// Constructor
	//------------------
	/**
	 * Construye el iterador a partir de la raíz del árbol a recorrer.
	 * @param nRaiz Raíz del árbol a iterar.
	 */
	public IteratorArbolBinario(NodoArbolBinario<T> nRaiz){
		raiz=nRaiz;
	}
	
	//------------------
	// Métodos
	//------------------
	/**
	 * Retorna el iterador del árbol en orden.
	 * @return El iterador del árbol en orden.
	 */
	public Iterator<T> iteradorInOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaInOrden(listaTemp);
		return listaTemp.iterator();
	}
	
	/**
	 * Retorna el iterador del árbol en pre orden.
	 * @return El iterador del árbol en pre orden.
	 */
	public Iterator<T> iteradorPreOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaPreOrden(listaTemp);
		return listaTemp.iterator();
	}
	
	/**
	 * Retorna el iterador del árbol en post orden.
	 * @return El iterador del árbol en post orden.
	 */
	public Iterator<T> iteradorPostOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaPostOrden(listaTemp);
		return listaTemp.iterator();
	}
}

