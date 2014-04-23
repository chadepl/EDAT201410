package lista;

public class NodoLista<T> {
	
	private NodoLista<T> siguiente;
	
	private T t;
	
	private Elemento<T> elemento; 
	
	public NodoLista(T e){
		
		t=e;
		
		siguiente = null;
		
		elemento = new Elemento<T>(e);
		
	}
	
	public Elemento<T> getElemento() {
		return elemento;
	}
	
	public NodoLista<T> getSiguiente() {
		return siguiente;
	}
	
	public void cambiarSiguiente(NodoLista<T> n){
		siguiente = n;
	}
	
	public void desconectarSiguiente(){
		siguiente=siguiente.getSiguiente();
	}
	
	public void cambiarElemento(Elemento<T> e){
		elemento=e;
	}
	
	
	

}
