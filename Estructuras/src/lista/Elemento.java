package lista;

import java.io.Serializable;

public class Elemento<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T t;
	
	public Elemento(T e){
		t=e;
	}
	
	public T getElemento(){
		return t;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return t.toString();
	}

}
