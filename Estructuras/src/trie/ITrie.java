package trie;

import java.io.Serializable;

public interface ITrie<T> extends Serializable {
	
	/**
	 * 
	 * @param palabra
	 * @param elemento
	 * @return
	 */
	public T agregar(String palabra, T elemento);
	
	/**
	 * 
	 * @param palabra
	 * @return
	 */
	public T buscar(String palabra);
	
	/**
	 * 
	 * @param palabra
	 * @return
	 */
	public T eliminar(String palabra);

	

}
