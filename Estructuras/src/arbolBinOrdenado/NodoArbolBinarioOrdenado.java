package arbolBinOrdenado;

import lista.Lista;
import arbolBinario.ElementoExistenteException;



public class NodoArbolBinarioOrdenado<T extends Comparable<T>> {

	/**
	 * Elemento que contiene el nodo.
	 */
	private T elemento;

	/**
	 * Hijo derecho.
	 */
	private NodoArbolBinarioOrdenado<T> derecha;

	/**
	 * Hijo izquierdo.
	 */
	private NodoArbolBinarioOrdenado<T> izquierda;

	/**
	 * Constructor del nodo de arbol binario.
	 * @param nElemento El elemento del nodo.
	 */
	public NodoArbolBinarioOrdenado(T nElemento) {
		elemento=nElemento;
		derecha=null;
		izquierda=null;
	}

	/**
	 * Retorna la altura del ��rbol nacido apartir del nodo.
	 * @return La altura del ��rbol nacido apartir del nodo.
	 */
	public int darAltura(){
		int aD=(derecha==null)?0:derecha.darAltura();
		int aI=(izquierda==null)?0:izquierda.darAltura();
		return 1+(Math.max(aD, aI));
	}

	/**
	 * Retorna el peso del ��rbol nacido apartir del nodo.
	 * @return El peso del ��rbol nacido apartir del nodo.
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
	 * Agrega un elemento al ��rbol nacido de este nodo.
	 * @param add Elemento a agregar.
	 * @throws ElementoExistenteException En caso de que ya exista el elemento en el arbol nacido del nodo.
	 */
	public void agregar(T add) throws ElementoExistenteException{
		if(elemento.compareTo(add)<0){
			if(derecha!=null)
				derecha.agregar(add);
			else
				derecha=new NodoArbolBinarioOrdenado<T>(add);
		}
		else if(elemento.compareTo(add)>0){
			if(izquierda!=null)
				izquierda.agregar(add);
			else
				izquierda=new NodoArbolBinarioOrdenado<T>(add);
		}
		else
			throw new ElementoExistenteException("Este elemento ya existe");
	}

	/**
	 * Elimina un elemento del ��rbol que comienza en este nodo.
	 * @param aEliminar elemento que se va a eliminar.
	 * @return el ��rbol de nodos despu��s de eliminar el nodo indicado
	 */
	public NodoArbolBinarioOrdenado<T> eliminar( T aEliminar )
	{
		if(izquierda==null&&derecha==null)
			return null;
		if(elemento.compareTo(aEliminar)==0){
			if(izquierda==null)
				return derecha;
			if(derecha==null)
				return izquierda;
			NodoArbolBinarioOrdenado<T> x=derecha.darMenor();
			derecha=derecha.eliminar(aEliminar);

			x.izquierda=izquierda;
			x.derecha=derecha;
			return x;
		}
		else if(elemento.compareTo(aEliminar)<0){
			if(izquierda!=null)
				izquierda=izquierda.eliminar(aEliminar);
		}
		else{
			if(derecha!=null)
				derecha=derecha.eliminar(aEliminar);
		}
		return this;
	}

	/**
	 * Retorna el menor elemento del ��rbol nacido del nodo.
	 * @return El menor elemento del ��rbol nacido del nodo.
	 */
	private NodoArbolBinarioOrdenado<T> darMenor() {
		return (izquierda==null)?this:izquierda.darMenor();
	}

	/**
	 * Busca un elemento en el arbol
	 * @param aBuscar Elemento a buscar.
	 * @return El elemento buscado.
	 */
	public T buscar(T aBuscar){
		int x=this.darElemento().compareTo(aBuscar);
		T element=null;
		if(x==0){
			element=this.darElemento();
		}
		else if(x>0&&izquierda!=null){
			element=izquierda.buscar(aBuscar);
		}
		else if(x<0&&derecha!=null){
			element=derecha.buscar(aBuscar);
		}
		return element;
	}
	
	/**
	 * Recopila los elementos T del sub��rbol en orden en la lista pasada por parametro.
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
	 * Recopila los elementos T del sub��rbol en pre orden en la lista pasada por parametro.
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
	 * Recopila los elementos T del sub��rbol en post orden en la lista pasada por parametro.
	 * @param leLista La lista La lista donde se recopila los elementos T.
	 */
	public void generarListaPostOrden(Lista<T> leLista){
		if(izquierda!=null)
			izquierda.generarListaInOrden(leLista);
		if(derecha!=null)
			derecha.generarListaInOrden(leLista);
		leLista.agregar(elemento);
	}
}
