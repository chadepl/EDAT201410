package trie;

import java.io.Serializable;

public class NodoTrie<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodoTrie<T> hijo;
	
	public NodoTrie<T> hermano;
	
	public char id;
	
	public T elemento;
	
	
	/**
	 * 
	 * @param nId
	 */
	public NodoTrie(char nId){
		hijo = null;
		hermano = null;
		id = nId;
	}
	
	/**
	 * Metodo que agrega un elemento al trie.
	 * @param palabra La palabra que identifica al elemento.
	 * @param elemento Elemento que se va a agregar.
	 * @return El elemento que se agrego
	 */
	public T agregar(String palabra, T elemento){
	
		if(palabra.charAt(0)==id){
			
			if(palabra.length()==1){
				
				this.elemento=elemento;
				return elemento;

			}else if(hijo != null){
					if(hijo.id>palabra.charAt(1)){
						NodoTrie<T> nuevo = new  NodoTrie<T>(palabra.charAt(1));
						nuevo.hermano=hijo;
						hijo=nuevo;
					}
				return hijo.agregar(palabra.substring(1), elemento);
		
			}else if(hijo == null){
				
				hijo = new NodoTrie<T>(palabra.charAt(1));
				return hijo.agregar(palabra.substring(1), elemento);
				
			}
			
		}else if (palabra.charAt(0)>id){
			
			if(hermano!=null){
				
					if(palabra.charAt(0)<hermano.id){
						NodoTrie<T> nuevo=new NodoTrie<T>(palabra.charAt(0));
						nuevo.hermano=hermano;
						hermano=nuevo;
					}
				
					return hermano.agregar(palabra, elemento);
			}else{
				
				hermano = new NodoTrie<T>(palabra.charAt(0));
				return hermano.agregar(palabra, elemento);
				
			}
		}
		return null;
		
	}
	
	/**
	 * Metodo que se encarga de buscar un elemento dada la palabra que lo identifica
	 * @param palabra que identifica el elemento
	 * @return elemento que se estaba buscando o null en caso de no encontrarlo
	 */
	public T buscar(String palabra){
		
		if(palabra.charAt(0)==id){
			
			if(palabra.length()==1){
				
				return elemento;

			}else if(hijo != null){
					if(hijo.id>palabra.charAt(1)){
						return null;
					}
				return hijo.buscar(palabra.substring(1));
		
			}else if(hijo == null){
				
				return null;
				
			}
			
		}else if (palabra.charAt(0)>id){
			
			if(hermano!=null){
				
					if(palabra.charAt(0)<hermano.id){
						return null;
					}
				
					return hermano.buscar(palabra);
			}else{
				
				return null;
				
			}
		}
		return null;
	}
	
	/**
	 * Metodo que elimina un elemento del trie
	 * @param palabra donde esta el elemento a eliminar
	 * @return elemento que se elimino
	 */
	public T eliminar(String palabra){

		if (palabra.charAt(0) == id) {

			if (palabra.length() == 1) {
				
				T elementoEliminado=elemento;
				
				elemento=null;
				
				eliminarSobrantes(palabra);

				return elementoEliminado;

			} else if (hijo != null) {
				if (hijo.id > palabra.charAt(1)) {
					return null;
				}
				return hijo.buscar(palabra.substring(1));

			} else if (hijo == null) {

				return null;

			}

		} else if (palabra.charAt(0) > id) {

			if (hermano != null) {

				if (palabra.charAt(0) < hermano.id) {
					return null;
				}

				return hermano.buscar(palabra);
			} else {

				return null;

			}
		}
		return null;
	}
	
	/**
	 * Metodo que dice si es hoja
	 * @return true si es hoja o false si no
	 */
	public boolean esHoja(){
		return hermano==null&&hijo==null?true:false;
	}
	
	/**
	 * Metodo que se encarga de eliminar los sobrantes
	 */
	public void eliminarSobrantes(String palabra){
		
	}

}
