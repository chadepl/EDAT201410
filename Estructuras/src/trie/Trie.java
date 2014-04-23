package trie;

public class Trie<T> implements ITrie<T> {
	
	private NodoTrie<T> raiz;
	
	public Trie(){
		raiz = null;
	}

	/**
	 * Metodo que agrega un elemento al trie.
	 * @param palabra La palabra que identifica al elemento.
	 * @param elemento Elemento que se va a agregar.
	 * @return El elemento que se agrego
	 */
	@Override
	public T agregar(String palabra, T elemento) {
		if(raiz == null){
			raiz = new NodoTrie<T>(palabra.charAt(0));
		}else if(raiz.id>palabra.charAt(0)){
			NodoTrie<T> nuevo = new NodoTrie<T>(palabra.charAt(0));
			nuevo.hermano=raiz;
			raiz=nuevo;
		}
		return raiz.agregar(palabra, elemento);
		
	}

	/**
	 * Metodo que se encarga de buscar un elemento dada la palabra que lo identifica
	 * @param palabra que identifica el elemento
	 * @return elemento que se estaba buscando o null en caso de no encontrarlo
	 */
	@Override
	public T buscar(String palabra) {
		if (raiz == null) {
			return null;
		} else {
			return raiz.buscar(palabra);
		}
	}

	/**
	 * Metodo que elimina un elemento del trie
	 * @param palabra donde esta el elemento a eliminar
	 * @return elemento que se elimino
	 */
	@Override
	public T eliminar(String palabra) {
		if (raiz == null) {
			return null;
		} else {
			return raiz.eliminar(palabra);
		}
	}

}
