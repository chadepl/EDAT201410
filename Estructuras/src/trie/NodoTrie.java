package trie;

public class NodoTrie<T> {
	
	private NodoTrie<T> hijo;
	
	private NodoTrie<T> hermano;
	
	private char id;
	
	private T elemento;
	
	public NodoTrie(char nId){
		hijo = null;
		hermano = null;
		id = nId;
	}
	
	public T agregar(String palabra, T elemento){
		//Caso 1, cuando la letra a comparar es igual a la del nodo
		if(palabra.charAt(0)==id){
			//
			if(palabra.length()==1){
				this.elemento=elemento;
				return elemento;
				//
			}else if(hijo != null){
				return hijo.agregar(palabra.substring(1), elemento);
				//
			}else if(hijo == null){
				hijo = new NodoTrie<T>(palabra.substring(1).charAt(0));
				return hijo.agregar(palabra.substring(1), elemento);
			}
		}else if(palabra.charAt(0)>id){
			if(hermano!=null){
				NodoTrie<T> nodo= new NodoTrie<T>(palabra.charAt(0));
				nodo.hermano=this.hermano;
				this.hermano=nodo;
				return nodo.agregar(palabra, elemento);
			}else{
				hermano = new NodoTrie<T>(palabra.charAt(0));
				return hermano.agregar(palabra, elemento);
			}
		}
		return null;
		
	}
	
	public T buscar(String palabra){
		return null;
	}
	
	public T eliminar(String palabra){
		return null;
	}

}
