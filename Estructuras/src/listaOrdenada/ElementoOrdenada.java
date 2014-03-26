package listaOrdenada;

import java.io.Serializable;

public class ElementoOrdenada<T extends Comparable<T>> implements Serializable {
	
	private T t;
	
	public ElementoOrdenada(T e){
		t=e;
	}
	
	public T getElemento(){
		return t;
	}

}
