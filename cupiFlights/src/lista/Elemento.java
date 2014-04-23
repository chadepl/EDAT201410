package lista;

public class Elemento<T> {
	
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
