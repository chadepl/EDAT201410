package arbolBinAVL;

import java.util.Iterator;

import arbolBinario.ElementoExistenteException;



public class ArbolBinAVL<T extends Comparable<T>> implements IArbolBinAVL<T>{

	/**
	 * Nodo ra��z del ��rbol.
	 */
	protected NodoArbolBinAVL<T> raiz;

	/**
	 * Inicializa el arbol AVL.
	 */
	public ArbolBinAVL(){
		raiz=null;
	}
	
	/**
	 * Retorna la altura del ��rbol.
	 * @return La altura del ��rbol.
	 */
	public int darAltura() {
		return raiz.darAltura();
	}

	/**
	 * Retorna el peso del ��rbol.
	 * @return El peso del ��rbol.
	 */
	public int darPeso() {
		return raiz.darPeso();
	}

	/**
	 * Busca un elemento en el ��rbol.
	 * @param aBuscar Elemento a buscar en el ��rbol.
	 * @return El elemento buscado. Retorna null en caso de que no exista.
	 */
	public T buscar(T aBuscar) {
		return (raiz!=null)?raiz.buscar(aBuscar):null;
	}

	/**
	 * Agrega un elemento al ��rbol.
	 * @param aInsertar Elemento a insertar en el ��rbol.
	 */
	public boolean agregar(T aInsertar) {
		boolean agrego=true;
		if(raiz==null){
			raiz=new NodoArbolBinAVL<T>(aInsertar);
		}
		else{
			try {
				raiz.agregar(aInsertar);
			} catch (ElementoExistenteException e) {
				agrego=false;
			}
		}
		if(agrego)raiz=raiz.balancearXAltura();
		return agrego;
	}

	/**
	 * Elimina un elemento del arbol.
	 * @param aEliminar. El elemento a eliminar del ��rbol.
	 * @return El elemento borrado del ��rbol. Si no elimino nada retorna null.
	 */
	public T eliminar(T aEliminar) {
		T x=null;
		if(raiz!=null){
			T temporal=raiz.buscar(aEliminar);
			if(temporal!=null){
				NodoArbolBinAVL<T> raizTemp=raiz.eliminar(aEliminar);
				if(raizTemp==null){
					x=raiz.buscar(aEliminar);
					raiz=raizTemp;
				}
				else{
					raiz=raizTemp;
					T eliminado=null;
					if(raiz!=null){
						eliminado=raiz.buscar(aEliminar);
						if(eliminado==null){
							x=temporal;
						}
					}
				}
			}
		}
		return x;
	}

	/**
	 * M��todo que retorna la ra��z del ��rbol.
	 * @return La ra��z del ��rbol.
	 */
	public NodoArbolBinAVL<T> darRaiz(){
		return raiz;
	}
	
	/**
	 * Retorna el iterador del ��rbol en pre orden.
	 * @return El iterador del ��rbol en pre orden.
	 */
	public Iterator<T> iteratorPreOrden() {
		return new IteratorArbolBinAVL<T>(raiz).iteradorPreOrden();
	}

	/**
	 * Retorna el iterador del ��rbol en post orden.
	 * @return El iterador del ��rbol en post orden.
	 */
	public Iterator<T> iteratorPostOrden(){
		return new IteratorArbolBinAVL<T>(raiz).iteradorPostOrden();
	}

	/**
	 * Retorna el iterador del ��rbol en orden.
	 * @return El iterador del ��rbol en orden.
	 */
	public Iterator<T> iterator() {
		return new IteratorArbolBinAVL<T>(raiz).iteradorInOrden();
	}
	
	/**
	 * Retorn el iterador del ��rbol por niveles.
	 * @return El iterador del ��rbol por niveles.
	 */
	public Iterator<T> iteratorPorNiveles(){
		return new IteratorArbolBinAVL<T>(raiz).iteradorPorNiveles();
	}
}
