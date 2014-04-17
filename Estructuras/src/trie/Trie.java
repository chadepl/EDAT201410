package trie;

public class Trie<T> implements ITrie<T> {
	
	private NodoTrie<T> raiz;
	
	public Trie(){
		raiz = null;
	}

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

	@Override
	public T buscar(String palabra) {
		if (raiz == null) {
			return null;
		} else {
			return raiz.buscar(palabra);
		}
	}

	@Override
	public T eliminar(String palabra) {
		if (raiz == null) {
			return null;
		} else {
			return raiz.eliminar(palabra);
		}
	}

}
