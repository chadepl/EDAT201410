package arbolBinAVL;

import lista.Lista;
import arbolBinario.ElementoExistenteException;



public class NodoArbolBinAVL<T extends Comparable<T>>{

	//------------------
	// Atributos
	//------------------

	/**
	 * Elemento que contiene el nodo.
	 */
	public T elemento;

	/**
	 * Hijo izquierdo.
	 */
	public NodoArbolBinAVL<T> izquierda;

	/**
	 * Hijo derecho.
	 */
	public NodoArbolBinAVL<T> derecha;

	/**
	 * Altura del ��rbol nacido del nodo.
	 */
	public int altura;

	/**
	 * Indicador de balance del nodo.
	 */
	public int indicador;

	//------------------
	// Constructor
	//------------------

	/** 
	 * Constructor del nodo.
	 * @param nElemento Elemento del nodo.
	 */
	public NodoArbolBinAVL(T nElemento) {
		elemento=nElemento;
		izquierda=null;
		derecha=null;
		altura=0;
		indicador=0;
	}

	//------------------
	// M��todos
	//------------------

	/**
	 * M��todo encargado de saber si el ��rbol nacido del nodo es AVL.
	 * @return esAVL. True si es AVL, false en caso contrario.
	 */
	public boolean esAVL(){
		boolean esAVL=false;
		if(derecha==null&&izquierda==null)
			esAVL=true;
		else if(derecha!=null&&izquierda!=null){
			calcularAlturaEIndicador();
			if(-1<=indicador&&indicador<=1&&derecha.esAVL()&&izquierda.esAVL()){
				esAVL=true;
			}
		}
		else if(derecha==null){
			if(izquierda.darAltura()<=1)
				esAVL=true;
		}
		else if(izquierda==null){
			if(derecha.darAltura()<=1)
				esAVL=true;
		}
		return esAVL;
	}

	/**
	 * M��todo encargado de desconectar el hijo izquierdo.
	 */
	public NodoArbolBinAVL<T> desconectarIzquierda(){
		izquierda=null;
		return this;
	}

	/**
	 * M��todo encargado de desconectar el hijo derecho.
	 */
	public NodoArbolBinAVL<T> desconectarDerecha(){
		derecha=null;
		return this;
	}

	/**
	 * Balancea el ��rbol nacido de este nodo.
	 * @return El nodo de reemplazo balanceado para este nodo.
	 */
	public NodoArbolBinAVL<T> balancearXAltura(){
		NodoArbolBinAVL<T> temp =null;
		if(izquierda!=null){
			izquierda=izquierda.balancearXAltura();
		}
		if(derecha!=null){
			derecha=derecha.balancearXAltura();
		}
		calcularAlturaEIndicador();
		if(-1<=indicador&&indicador<=1){
			temp= this;
		}
		else if(indicador==2){
			if ( izquierda.indicador == 1 ){ 
				temp= this.rotarDerecha();  
			}	
			else if ( izquierda.indicador == -1 ){
				temp= this.rotarIzquierdaDerecha(); } 
			else{
				temp= this.rotarIzquierdaDerecha(); 
			}
		} 
		else if(indicador==-2){
			if ( derecha.indicador == 1 ){ 
				temp= this.rotarDerechaIzquierda();   
			}
			else if ( derecha.indicador == -1 ){
				temp= this.rotarIzquierda(); } 
			else{
				temp= this.rotarIzquierda(); 
			}
		} 
		return temp;
	}

	/**
	 * M��todo que rota el sub��rbol a la izquierda.
	 * @return
	 */
	private NodoArbolBinAVL<T> rotarIzquierda() {
		NodoArbolBinAVL<T> resp=this;
		if(derecha!=null){
			NodoArbolBinAVL<T> temp=derecha.izquierda;
			NodoArbolBinAVL<T> dTemp=derecha;
			if(temp!=null)dTemp=derecha.desconectarIzquierda();
			derecha=temp;
			dTemp.izquierda=this;
			resp=dTemp;
		}
		return resp;
	}

	/**
	 * M��todo encagado de rotar la derecha e izquierda.
	 * @return El sub��rbol rotado.
	 */
	private NodoArbolBinAVL<T> rotarDerechaIzquierda() {
		if(derecha!=null){
			derecha=derecha.rotarDerecha();
		}
		return this.rotarIzquierda();
	}

	/**
	 * M��todo que rota el sub��rbol a la derecha.
	 * @return El sub��rbol rotado.
	 */
	private NodoArbolBinAVL<T> rotarDerecha() {
		NodoArbolBinAVL<T> resp=this;
		if(izquierda!=null){
			NodoArbolBinAVL<T> temp=izquierda.derecha;
			NodoArbolBinAVL<T> iTemp=izquierda;
			if(temp!=null)iTemp=izquierda.desconectarDerecha();
			izquierda=temp;
			iTemp.derecha=this;
			resp=iTemp;
		}
		return resp;
	}

	/**
	 * M��todo que rota el sub��rbol a izquierda y posteriormente a derecha.
	 * @return El subarbol rotado.
	 */
	private NodoArbolBinAVL<T> rotarIzquierdaDerecha() {
		if(izquierda!=null){
			izquierda=izquierda.rotarIzquierda();
		}
		return rotarDerecha();
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
				derecha=new NodoArbolBinAVL<T>(add);
		}
		else if(elemento.compareTo(add)>0){
			if(izquierda!=null)
				izquierda.agregar(add);
			else
				izquierda=new NodoArbolBinAVL<T>(add);
		}
		else
			throw new ElementoExistenteException("Este elemento ya existe");
	}

	/**
	 * M��todo encargado de calcular la altura y el indice del ��rbol nacido de este nodo.
	 */
	public void calcularAlturaEIndicador(){
		altura=darAltura();
		indicador=calcularIndicador();
	}

	/**
	 * M��todo encargado de c��lcular el indicador de balance del nodo.
	 * @return El indicador de balance del nodo.
	 */
	private int calcularIndicador() {
		int iI=0;
		int iD=0;
		if(derecha!=null){
			iD=derecha.darAltura();
			derecha.indicador=derecha.calcularIndicador();
		}
		if(izquierda!=null){
			iI=izquierda.darAltura();
			izquierda.indicador=izquierda.calcularIndicador();
		}
		return iI-iD;
	}

	/**
	 * Elimina un elemento del ��rbol que comienza en este nodo.
	 * @param aEliminar elemento que se va a eliminar.
	 * @return el ��rbol de nodos despu��s de eliminar el nodo indicado
	 */
	public NodoArbolBinAVL<T> eliminar( T aEliminar )
	{
		if(izquierda==null&&derecha==null)
			return null;
		if(elemento.compareTo(aEliminar)==0){
			if(izquierda==null)
				return derecha;
			if(derecha==null)
				return izquierda;
			NodoArbolBinAVL<T> x=derecha.darMenor();
			derecha=derecha.eliminar(aEliminar);

			x.izquierda=izquierda;
			x.derecha=derecha;
			return x;
		}
		else if(elemento.compareTo(aEliminar)>0){
			if(izquierda!=null){
				izquierda=izquierda.eliminar(aEliminar);
			}
		}
		else if(elemento.compareTo(aEliminar)<0){
			if(derecha!=null){
				derecha=derecha.eliminar(aEliminar);
			}
		}
		return this;
	}

	/**
	 * Retorna el menor elemento del ��rbol nacido del nodo.
	 * @return El menor elemento del ��rbol nacido del nodo.
	 */
	private NodoArbolBinAVL<T> darMenor() {
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
	 * @param leLista La lista
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
	 * @param leLista La lista
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
	 * @param leLista La lista
	 */
	public void generarListaPostOrden(Lista<T> leLista){
		if(izquierda!=null)
			izquierda.generarListaInOrden(leLista);
		if(derecha!=null)
			derecha.generarListaInOrden(leLista);
		leLista.agregar(elemento);
	}

	/**
	 * Recopila los elementos T del s��barbol en niveles a partir de nivel.
	 * @param leLista la Lista a la que se va agregar.
	 * @param nivel nivel del ��rbol a buscar.
	 */
	public void generarListaPorNiveles(Lista<T> leLista, int nivel){
		if(nivel==darAltura()){
			Lista<T> temp=new Lista<T>();
			temp.agregar(elemento);
		}
		else if(nivel==darAltura()-1){
			Lista<T> temp=new Lista<T>();
			if(izquierda!=null)
				temp.agregar(izquierda.darElemento());
			if(derecha!=null)
			temp.agregar(derecha.darElemento());
		}
		else if(nivel<darAltura()-1){
			izquierda.generarListaPorNiveles(leLista, nivel);
			derecha.generarListaPorNiveles(leLista, nivel);
		}
	}
}


