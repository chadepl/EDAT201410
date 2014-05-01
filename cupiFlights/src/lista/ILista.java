package lista;



public interface ILista<T> extends Iterable<T> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean agregar(T t);
	
	/**
	 * 
	 * @param indice
	 * @param t
	 */
	public void agregar(int indice, T t);
	
	/**
	 * 
	 */
	public void clear();
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean contiene(T t);
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public T dar(int i);
	
	/**
	 * 
	 * @return
	 */
	public boolean estaVacia();
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public T eliminar(int indice);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean eliminar(T t);
	
	/**
	 * 
	 * @param indice
	 * @param t
	 * @return
	 */
	public T cambiar(int indice, T t);
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean cambiar(T x,T y);
	
	/**
	 * 
	 * @return
	 */
	public int darLongitud();
	
	/**
	 * 
	 * @return
	 */
	public Elemento<T>[] darArreglo();
	
	public Lista<T> interseccionDeListas(Lista<T> lista);
}
