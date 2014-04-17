package trie;

public interface ITrie<T> {
	
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
