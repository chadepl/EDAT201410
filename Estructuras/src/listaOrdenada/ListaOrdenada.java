package listaOrdenada;

import java.io.Serializable;

public class ListaOrdenada<T extends Comparable<T>> implements IListaOrdenada<T>, Serializable {
	
	
	private NodoListaOrdenada<T> primero;
	
	private NodoListaOrdenada<T> ultimo;
	
	private int longitud;
	
	public ListaOrdenada(){
		
		primero = null;
		
		ultimo = null;
		
		longitud = 0;
		
	}

	@Override
	public boolean agregar(T t) {
		NodoListaOrdenada<T> agregando = new NodoListaOrdenada<T>(t);
		boolean agrego = false;
		if(primero==null){
			primero=agregando;
			ultimo=agregando;
			agrego=true;
			longitud++;
		}else{
			NodoListaOrdenada<T> actual=primero;
			if(agregando.getElemento().getElemento().compareTo(primero.getElemento().getElemento())==-1){
				agregando.cambiarSiguiente(actual);
				primero=agregando;
				agrego=true;
				longitud++;
			}else{
			while(actual.getSiguiente()!=null && !agrego){
				if(agregando.getElemento().getElemento().compareTo(actual.getSiguiente().getElemento().getElemento())==-1){
						agregando.cambiarSiguiente(actual.getSiguiente());
						actual.cambiarSiguiente(agregando);
						agrego=true;
						longitud++;
					}
					agrego=true;
				}
				actual=actual.getSiguiente();
			}
			
		}
		return agrego;
	}

	
	@Override
	public void agregar(int indice, T t) {
		int i = 0;
		NodoListaOrdenada<T> actual=primero;
		NodoListaOrdenada<T> agregando = new NodoListaOrdenada<T>(t);
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
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if(primero!=null){
			primero=null;
		}
		
	}

	/**
	 * 
	 */
	@Override
	public boolean contiene(T t) {
		// TODO Auto-generated method stub
		NodoListaOrdenada<T> actual=primero;
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
	@Override
	public T dar(int i) {  //Manejo de Excepciones
		// TODO Auto-generated method stub
		int indice=0;
		NodoListaOrdenada<T> actual=primero;
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
	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		if(primero==null)
			return true;
		else
			return false;
		
	}

	/**
	 * 
	 */
	@Override
	public T eliminar(int indice) {
		// TODO Auto-generated method stub
		T eliminar=null;
		if(primero == null){
			
		}else if(primero != null && indice==0){
			eliminar= primero.getElemento().getElemento();
			primero=primero.getSiguiente();
			longitud--;
		}else{
			NodoListaOrdenada<T> actual=primero;
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
	@Override
	public boolean eliminar(T t) {
		// TODO Auto-generated method stub
		boolean elimino=false;
		if(primero==null){
			
		}else if(primero!=null && primero.getElemento().getElemento().equals(t)){
			primero=primero.getSiguiente();
			elimino=true;
			longitud--;
		}else{
			NodoListaOrdenada<T> actual=primero;
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
	@Override
	public T cambiar(int indice, T t) {
		// TODO Auto-generated method stub
		T elementoCambiado=null;
		if(indice<=(longitud-1)){
		NodoListaOrdenada<T> actual=primero;
		int i=0;
		boolean cambio = false;
		while(actual!=null && !cambio){
			if(i==indice){
				actual.cambiarElemento(new ElementoOrdenada<T>(t));
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
	@Override
	public boolean cambiar(T x, T y) {
		// TODO Auto-generated method stub
		boolean cambio = false;
		if(primero==null){
			//Se deberia lanzar una excepcion
		}else{
			NodoListaOrdenada<T> actual=primero;
			while(actual!=null && !cambio){
				if(actual.getElemento().getElemento().equals(x)){
					actual.cambiarElemento(new ElementoOrdenada<T>(y));
					cambio = true;
				}
			}
		}
		return cambio;
	}

	/**
	 * 
	 */
	@Override
	public int darLongitud() {
		// TODO Auto-generated method stub
		return longitud;
	}

	
	/**
	 * 
	 */
	@Override
	public ElementoOrdenada<T>[] darArreglo() {
		// TODO Auto-generated method stub
		ElementoOrdenada<T>[] elementos=new ElementoOrdenada[longitud-1];
		NodoListaOrdenada<T> actual=primero;
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
	public ListaOrdenada<T> interseccionDeListas(ListaOrdenada<T> lista){
		ListaOrdenada<T> listaRetorno=new ListaOrdenada<T>();
		NodoListaOrdenada<T> actual=primero;
		NodoListaOrdenada<T> actual1=lista.darPrimero();
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
	
	
	public NodoListaOrdenada<T> darPrimero(){
		return primero;
	}
	

}
