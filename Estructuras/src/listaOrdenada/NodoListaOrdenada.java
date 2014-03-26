package listaOrdenada;

import java.io.Serializable;

public class NodoListaOrdenada<T extends Comparable<T>> implements Serializable{
	
	private NodoListaOrdenada<T> siguiente;
	
	private T t;
	
	private ElementoOrdenada<T> elemento; 
	
	public NodoListaOrdenada(T e){
		
		t=e;
		
		siguiente = null;
		
		elemento = new ElementoOrdenada<T>(t);
		
	}
	
	public ElementoOrdenada<T> getElemento() {
		return elemento;
	}
	
	public NodoListaOrdenada<T> getSiguiente() {
		return siguiente;
	}
	
	public void cambiarSiguiente(NodoListaOrdenada<T> n){
		siguiente = n;
	}
	
	public void desconectarSiguiente(){
		siguiente=siguiente.getSiguiente();
	}
	
	public void cambiarElemento(ElementoOrdenada<T> e){
		elemento=e;
	}
	
	
	

}
