package lista;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorLista<T> implements Iterator<T>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NodoLista<T> proximo ;
	
	private NodoLista<T> anteriorAlProximo;
	
	private NodoLista<T> anteriorAnterior;
	
	public IteratorLista(Lista<T> nLista){
		
		proximo=nLista.darPrimero();
		
		anteriorAlProximo=null;
		
		anteriorAnterior=null;
		
	}
	
	public boolean hasNext() {
		return proximo!=null;
	}

	public T next() throws NoSuchElementException {
		if(proximo==null){
			throw  new NoSuchElementException("No hay mas elementos");
		}
		T elemento = proximo.getElemento().getElemento();
		anteriorAnterior=anteriorAlProximo;
		anteriorAlProximo=proximo;
		proximo=proximo.getSiguiente();
		
		
		return elemento;
	}
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
