package tablaHashing;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lista.Lista;

public class IteratorTabla<V> implements Iterator<V>, Serializable{

	private int indice;
	
	private Iterator<NodoTablaHashing<?, V>> iteradorActual;
	
	private Lista<NodoTablaHashing<?, V>> listaActual;

	private	Lista<NodoTablaHashing<?, V>>[] tabla;
	

	public IteratorTabla(Lista<NodoTablaHashing<?, V>>[] nTabla) {
		indice=0;
		tabla=nTabla;
		listaActual=tabla[0];
		iteradorActual=listaActual.iterator();
	}


	private boolean encontrarIterador(){
		if(iteradorActual.hasNext()==true){
			return true;
		}
		else{
			try{
				indice++;
				listaActual = tabla[indice];
				iteradorActual = listaActual.iterator();
				return hasNext();
			}
			catch(Exception e){
				return false;
			}
		}
	}
	/**
	 * @see estructuras.Iterator#hasNext()
	 */
	public boolean hasNext() {
		if(iteradorActual.hasNext()==true){
			return true;
		}
		else{
			return encontrarIterador();
		}
	}
	
	/**
	 * @see estructuras.Iterator#next()
	 */
	public V next() throws NoSuchElementException {
		if(encontrarIterador()){
			return (V) iteradorActual.next().darElemento();
		}
		else{
			throw new NoSuchElementException("No se encuentran mas elementos");
		}
	}
	


	

	public void remove() {
		iteradorActual.remove();
	}
}
