package arbolBinAVL;

import java.util.Iterator;

import lista.Lista;

public class IteratorArbolBinAVL<T extends Comparable<T>> {
	
	/**
	 * Ra��z del ��rbol a iterar.
	 */
	private NodoArbolBinAVL<T> raiz;
	
	//------------------
	// Constructor
	//------------------
	/**
	 * Construye el iterador a partir de la ra��z del ��rbol a recorrer.
	 * @param nRaiz
	 */
	public IteratorArbolBinAVL(NodoArbolBinAVL<T> nRaiz){
		raiz=nRaiz;
	}
	
	//------------------
	// M��todos
	//------------------
	/**
	 * Retorna el iterador del ��rbol en orden.
	 * @return El iterador del ��rbol en orden.
	 */
	public Iterator<T> iteradorInOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaInOrden(listaTemp);
		return listaTemp.iterator();
	}
	
	/**
	 * Retorna el iterador del ��rbol en pre orden.
	 * @return El iterador del ��rbol en pre orden.
	 */
	public Iterator<T> iteradorPreOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaPreOrden(listaTemp);
		return listaTemp.iterator();
	}
	
	/**
	 * Retorna el iterador del ��rbol en post orden.
	 * @return El iterador del ��rbol en post orden.
	 */
	public Iterator<T> iteradorPostOrden(){
		Lista<T> listaTemp=new Lista<T>();
		raiz.generarListaPostOrden(listaTemp);
		return listaTemp.iterator();
	}
	
	/**
	 * Retorna el iterador del ��rbol en niveles.
	 * @return El iterador del ��rbol en niveles.
	 */
	public Iterator<T> iteradorPorNiveles(){
		Lista<T> listaTemp=new Lista<T>();
		for(int i=raiz.darAltura();i>0;i--){
			raiz.generarListaPorNiveles(listaTemp, i);
		}
		return listaTemp.iterator();
	}
}
