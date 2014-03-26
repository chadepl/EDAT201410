package arbolBinario;

import lista.Lista;




public class NodoArbolBinario<T extends Comparable<T>> {

	/**
	 * Elemento que contiene el nodo.
	 */
	private T elemento;

	/**
	 * Hijo derecho.
	 */
	private NodoArbolBinario<T> derecha;

	/**
	 * Hijo izquierdo.
	 */
	private NodoArbolBinario<T> izquierda;

	/**
	 * Constructor del nodo de arbol binario.
	 * @param nElemento El elemento del nodo.
	 */
	public NodoArbolBinario(T nElemento) {
		elemento=nElemento;
		derecha=null;
		izquierda=null;
	}

	/**
	 * Retorna la altura del ������rbol nacido apartir del nodo.
	 * @return La altura del ������rbol nacido apartir del nodo.
	 */
	public int darAltura(){
		int aD=(derecha==null)?0:derecha.darAltura();
		int aI=(izquierda==null)?0:izquierda.darAltura();
		return 1+(Math.max(aD, aI));
	}

	/**
	 * Retorna el peso del ������rbol nacido apartir del nodo.
	 * @return El peso del ������rbol nacido apartir del nodo.
	 */
	public int darPeso(){
		int pD=(derecha==null)?0:derecha.darPeso();
		int pI=(izquierda==null)?0:izquierda.darPeso();
		return pI+pD+1;
	}

	/**
	 * Retorna el elemento del nodo.
	 * @return El elemento del nodo.
	 */
	public T darElemento(){
		return elemento;
	}

	/**
	 * Agrega un elemento al árbol nacido de este nodo.
	 * @param add Elemento a agregar.
	 * @throws ElementoExistenteException En caso de que ya exista el elemento en el arbol nacido del nodo.
	 */
	public boolean agregar(T add){
		boolean rsltd=false;
		if(izquierda==null){
			izquierda=new NodoArbolBinario<T>(add);
			rsltd=true;
		}
		else if(derecha==null){
			derecha=new NodoArbolBinario<T>(add);
			rsltd=true;
		}
		else{
			boolean temp=izquierda.agregar(add);
			if(!temp)
				temp=derecha.agregar(add);
			rsltd=temp;
		}
		return rsltd;
	}

	/**
	 * Elimina un elemento del árbol que comienza en este nodo.
	 * @param aEliminar elemento que se va a eliminar.
	 * @return el árbol de nodos después de eliminar el nodo indicado
	 */
	public NodoArbolBinario<T> eliminar( T aEliminar )
	{
		if(izquierda==null&&derecha==null)
			return null;
		if(elemento.equals(aEliminar)){
			if(izquierda==null)
				return derecha;
			if(derecha==null)
				return izquierda;
			NodoArbolBinario<T> x=derecha.darMenor();
			derecha=derecha.eliminar(aEliminar);

			x.izquierda=izquierda;
			x.derecha=derecha;
			return x;
		}
		else if(izquierda!=null&&izquierda.buscar(aEliminar)!=null){
			izquierda=izquierda.eliminar(aEliminar);
		}
		else{
			if(derecha!=null)
				derecha=derecha.eliminar(aEliminar);
		}
		return this;
	}

	/**
	 * Retorna el menor elemento del ������rbol nacido del nodo.
	 * @return El menor elemento del ������rbol nacido del nodo.
	 */
	private NodoArbolBinario<T> darMenor() {
		return (izquierda==null)?this:izquierda.darMenor();
	}

	/**
	 * Busca un elemento en el arbol
	 * @param aBuscar Elemento a buscar.
	 * @return El elemento buscado.
	 */
	public T buscar(T aBuscar){

		T element=null;
		T tempIzq=null;
		T tempDer=null;
		if(elemento.equals(aBuscar)){
			element=this.darElemento();
		}
		if(izquierda!=null){
			tempIzq=izquierda.buscar(aBuscar);
		}
		if(derecha!=null){
			tempDer=derecha.buscar(aBuscar);
		}
		if(element!=null)
			return element;
		else if(tempIzq!=null){
			return tempIzq;
		}
		else if(tempDer!=null){
			return tempDer;
		}
		else return null;
	}

	/**
	 * Recopila los elementos T del subárbol en orden en la lista pasada por parametro.
	 * @param leLista La lista La lista donde se recopila los elementos T.
	 */
	public void generarListaInOrden(Lista<T> leLista){
		if(izquierda!=null)
			izquierda.generarListaInOrden(leLista);
		leLista.agregar(elemento);
		if(derecha!=null)
			derecha.generarListaInOrden(leLista);
	}

	/**
	 * Recopila los elementos T del sub������rbol en pre orden en la lista pasada por parametro.
	 * @param leLista La lista La lista donde se recopila los elementos T.
	 */
	public void generarListaPreOrden(Lista<T> leLista){
		leLista.agregar(elemento);
		if(izquierda!=null)
			izquierda.generarListaInOrden(leLista);
		if(derecha!=null)
			derecha.generarListaInOrden(leLista);
	}

	/**
	 * Recopila los elementos T del subárbol en post orden en la lista pasada por parametro.
	 * @param leLista La lista La lista donde se recopila los elementos T.
	 */
	public void generarListaPostOrden(Lista<T> leLista){
		if(izquierda!=null)
			izquierda.generarListaInOrden(leLista);
		if(derecha!=null)
			derecha.generarListaInOrden(leLista);
		leLista.agregar(elemento);
	}

	public NodoArbolBinario<T> darDerecho() {

		return derecha;
	}

	public NodoArbolBinario<T> darIzquierdo() {

		return izquierda;
	}

	public boolean esHoja() {
		// TODO Auto-generated method stub
		return derecha==null && izquierda==null;
	}

	public void unirDerecho(NodoArbolBinario<T> aNodo) {
		derecha=aNodo;

	}

	public void unirIzquierdo(NodoArbolBinario<T> aNodo) {
		izquierda=aNodo;

	}

	public void asignarElemento(T character) {
		elemento=character;

	}
}
