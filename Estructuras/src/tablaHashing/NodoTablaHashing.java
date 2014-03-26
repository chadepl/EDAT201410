package tablaHashing;

import java.io.Serializable;

public class NodoTablaHashing <K, V > implements Serializable {
	
	/**
	 * Elemento del tipo V del nodo.
	 */
	private V elemento;
	
	/**
	 * Llave del tipo K del nodo.
	 */
	private K llave;
	
	/**
	 * M��todo constructor del nodo.
	 * @param key la llave. Llave de tipo K del nodo.
	 * @param element el elemento de tipo V del nodo.
	 */
	public NodoTablaHashing (K key, V element ){
		llave=key;
		elemento=element;
	}
	
	/**
	 * Retorna la llave del nodo.
	 * @return la llave del nodo de tipo K.
	 */
	public K darLlave(){
		return llave;
	}
	
	/**
	 * Retorna el elemento del nodo.
	 * @return el elemento de tipo V.
	 */
	public V darElemento(){
		return elemento;
	}
}
