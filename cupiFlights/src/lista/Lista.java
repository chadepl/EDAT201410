package lista;

import java.io.Serializable;
import java.util.Iterator;

public class Lista<T> implements ILista<T>,Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NodoLista<T> primero;
	
	private NodoLista<T> ultimo;
	
	private int longitud;
	
	public Lista(){
		
		primero = null;
		
		ultimo = null;
		
		longitud = 0;
		
	}

	public boolean agregar(T t) {
		NodoLista<T> agregando = new NodoLista<T>(t);
		boolean agrego = false;
		if(primero==null){
			primero=agregando;
			ultimo=agregando;
			agrego=true;
			longitud++;
		}else{
			ultimo.cambiarSiguiente(agregando);
			ultimo=agregando;
			agrego=true;
			longitud++;
		}
		return agrego;
	}

	
	
	public void agregar(int indice, T t) {
		int i = 0;
		NodoLista<T> actual=primero;
		NodoLista<T> agregando = new NodoLista<T>(t);
		boolean agrego=false;
		while(actual!=null && !agrego){
			if(i==indice){
				agregando.cambiarSiguiente(actual.getSiguiente());
				actual.cambiarSiguiente(agregando);
				longitud++;
				agrego=true;
			}
			i++;
			actual=actual.getSiguiente();
		}
		
	}

	/**
	 * 
	 */
	
	public void clear() {
		
		if(primero!=null){
			primero=null;
		}
		
	}

	/**
	 * 
	 */
	public boolean contiene(T t) {
		
		NodoLista<T> actual=primero;
		boolean esta=false;
		while(actual!=null && !false){
			if(actual.getElemento().getElemento().equals(t)){
				esta=true;
			}
			actual=actual.getSiguiente();
		}
		return esta;
	}

	/**
	 * 
	 */
	public T dar(int i) {  //Manejo de Excepciones
		
		int indice=0;
		NodoLista<T> actual=primero;
		T retorno=null;
		boolean encontro=false;
		while(actual!=null && !encontro){
			if(i==indice){
				retorno = actual.getElemento().getElemento();
				encontro=true;
			}
			indice++;
			actual=actual.getSiguiente();
		}
		return retorno;
	}

	/**
	 * 
	 */
	
	public boolean estaVacia() {
		
		if(primero==null)
			return true;
		else
			return false;
		
	}

	/**
	 * 
	 */
	
	public T eliminar(int indice) {
		
		T eliminar=null;
		if(primero == null){
			
		}else if(primero != null && indice==0){
			eliminar= primero.getElemento().getElemento();
			primero=primero.getSiguiente();
			longitud--;
		}else{
			NodoLista<T> actual=primero;
			int i=1;
			boolean termino=false;
			while(actual.getSiguiente()!=null && !termino){
				if(indice==i){
					eliminar= actual.getElemento().getElemento();
					actual.desconectarSiguiente();
					termino=true;
					longitud--;
				}
				i++;
			}
			
		}
		return eliminar;
	}

	/**
	 * 
	 */
	
	public boolean eliminar(T t) {
		
		boolean elimino=false;
		if(primero==null){
			
		}else if(primero!=null && primero.getElemento().getElemento().equals(t)){
			primero=primero.getSiguiente();
			elimino=true;
			longitud--;
		}else{
			NodoLista<T> actual=primero;
			while(actual.getSiguiente()!=null && !elimino){
				if(actual.getSiguiente().getElemento().getElemento().equals(t)){
					actual.desconectarSiguiente();
					elimino=true;
					longitud--;
				}
			}
		}
		return elimino;
	}
	

	/**
	 * 
	 */
	
	public T cambiar(int indice, T t) {
		
		T elementoCambiado=null;
		if(indice<=(longitud-1)){
		NodoLista<T> actual=primero;
		int i=0;
		boolean cambio = false;
		while(actual!=null && !cambio){
			if(i==indice){
				actual.cambiarElemento(new Elemento<T>(t));
				elementoCambiado=actual.getElemento().getElemento();
				cambio = true;
			}
			i++;
			actual=actual.getSiguiente();
		}
		}else{
			//Se deberia lanzar una excepcion
		}
		return elementoCambiado;
	}
	
	/**
	 * 
	 */
	
	public boolean cambiar(T x, T y) {
		
		boolean cambio = false;
		if(primero==null){
			//Se deberia lanzar una excepcion
		}else{
			NodoLista<T> actual=primero;
			while(actual!=null && !cambio){
				if(actual.getElemento().getElemento().equals(x)){
					actual.cambiarElemento(new Elemento<T>(y));
					cambio = true;
				}
			}
		}
		return cambio;
	}

	/**
	 * 
	 */
	
	public int darLongitud() {
		
		return longitud;
	}

	
	/**
	 * 
	 */
	
	public Elemento<T>[] darArreglo() {
		
		Elemento<T>[] elementos=new Elemento[longitud];
		NodoLista<T> actual=primero;
		int i=0;
		while(actual!=null){
			elementos[i]=actual.getElemento();
			actual=actual.getSiguiente();
			i++;
		}
		return elementos;
	}
	
	/**
	 * 
	 * @param lista
	 * @return
	 */
	public Lista<T> interseccionDeListas(Lista<T> lista){
		Lista<T> listaRetorno=new Lista<T>();
		NodoLista<T> actual=primero;
		NodoLista<T> actual1=lista.darPrimero();
		while(actual!=null){
			while(actual1!=null){
				if(actual.equals(actual1))
					listaRetorno.agregar(actual.getElemento().getElemento());
				actual1=actual1.getSiguiente();
			}
			actual=actual.getSiguiente();
		}
		return listaRetorno;
		
	}
	
	
	public NodoLista<T> darPrimero(){
		return primero;
	}

	
	public Iterator<T> iterator() {
		
		return new IteratorLista<T>(this);
		
	}
	
	public void addAll(Lista<T> Lista){
		//TODO
	}
}
