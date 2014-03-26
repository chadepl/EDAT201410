package tablaHashing;

import java.io.Serializable;
import java.security.acl.NotOwnerException;
import java.util.Iterator;

import lista.Elemento;
import lista.Lista;

public class TablaHashing<K,V> implements ITablaHashing<K, V> , Serializable{


	/**
	 * Número de elementos que contiene la tabla.
	 */
	private int tamanio;

	/**
	 * Cantidad máxima que puede tener la tabla antes de hacer un rehash.
	 */
	private int capacidad;

	/**
	 * Valor porcentual de factor de carga. Indica el porcentaje de ocupación de la tabla.
	 */
	private double factorCarga;

	/**
	 * Area primaria de la tabla. A partir de esta se puede interactuar con la tabla hashing.
	 */
	private Lista<NodoTablaHashing<K, V>>[] tabla;
	
	// Constantes
	
	private final static double INCREMENTO=0.2;
	
	private final static double LIMITE=0.7;
	
	private int numeroElementos;

	/**
	 * Constructor de la tabla hashing. 
     * @param nCapacidad. Capacidad máxima de la tabla hashing.
     * @param nLimite. Limite de factor de carga de la tabla hashing.
     * @param nIncremento. valor porcentual correspondiente al valor de incremento de la tabla hashing cada vez que se haga rehash.
	 */
	public TablaHashing(int nCapacidad){
		
		capacidad=nCapacidad;
		numeroElementos=0;
		tabla= new Lista[capacidad];
		inicializarListas(tabla);
	}
	
	

	/**
	 * Traduce la llave que llega por parametro en un indice en la tabla.
	 * @param key Objeto llave. Sobre este objeto se hará el hash.
	 * @return retorna el valor numérico que indica el indice del objeto que tiene en la tabla.
	 */
	public int hash(K key){
		return Math.abs(key.hashCode()%capacidad);
	}

	/**
	 * Método encargado de hacer rehash. Esta acción agranda la capacidad de la tabla.
	 */
	public void reHash(){
		int nuevaCapacidad=(int) (capacidad+(INCREMENTO*capacidad));
		if(esPrimo(nuevaCapacidad)){
			capacidad=nuevaCapacidad;
		}
		else{
			boolean bool=false;
			int proximoPrimo=0;
			for(int i=nuevaCapacidad+1;i<Integer.MAX_VALUE && !bool;i++){
				if(esPrimo(i)){
					proximoPrimo=i;
					bool=true;
				}
			}
			capacidad=proximoPrimo;
		}
		Lista<NodoTablaHashing<K, V>>[] nAP= new Lista[capacidad];
		inicializarListas(nAP);
		int j=0;
		while(j<tabla.length){
			if(!tabla[j].estaVacia()){
				for(int z=0;z<tabla[j].darLongitud();z++){
					K llave=tabla[j].dar(z).darLlave();
					V elemento=tabla[j].dar(z).darElemento();
					doHash(nAP, llave, elemento);
				}
			}
			j++;
		}
		tabla=nAP;
		actualizarFactorCarga();
	}

	/**
     * Método encargado de agregar un elemento a la tabla hashing.
	 * @param k. Llave del nuevo objeto.
     * @param V. Elemento a agregar.
	 * @return returna un valor booleano indicando true si se agrego o false en caso contrario.
	 */
	public boolean agregar(K k, V v)  {
		
		int llave=hash(k);
		boolean agrego=false;
			if(tabla[llave].estaVacia()){
			tabla[llave].agregar(new NodoTablaHashing<K, V>(k, v));
			agrego=true;
			tamanio++;
			numeroElementos++;
				if(tamanio>=(LIMITE*capacidad)){
				reHash();
				}
			}else{
				tabla[llave].agregar(new NodoTablaHashing<K, V>(k, v));
				agrego=true;
				numeroElementos++;
				
			}
		
			return agrego;
				
			
	
	}
	
	public int darNE(){
		return numeroElementos;
	}

	/**
	 * Método encargado de buscar el grupo de elementos que coinciden con la llave especificada en el paramentro.
     * @param k. Llave del grupo de objetos a buscar.
	 * @return returna la lista de elementos que coinciden con esta llave.
	 */
	public Lista<V> buscar(K key){
		int llave = hash(key);
		Lista<V> aRetornar=null;
		if(!tabla[llave].estaVacia()){
			aRetornar=new Lista<V>();
			Elemento<NodoTablaHashing<K, V>>[] arregloTemp = tabla[llave].darArreglo();
			int i=0;
			while(i<arregloTemp.length){
				aRetornar.agregar(arregloTemp[i].getElemento().darElemento());
				i++;
			}
		}
		return aRetornar;
	}

	/**
	 * Método encargado de eliminar el conjunto de elementos que coinciden con la llave pasada por parametro.
     * @param k. Llave del grupo de objetos a eliminar.
	 * @return returna la lista de elementos que coinciden con esta llave.
	 */
	public boolean eliminar(K k,V v) {
		Lista<V> temp=buscar(k);
		return temp.eliminar(v);
	}

	/**
	 * Método encargado de eliminar el conjunto de elementos que coinciden con la llave pasada por parametro.
	 * @return returna el iterador de la tabla.
	 */
	public Iterator<V> iterator() {
		return new IteratorTabla(tabla);
	}

	/**
	 * Este método retorna la capcidad de la tabla.
	 * @return capacidad. La capacidad de la tabla.
	 */
	public int darCapacidad(){
		return capacidad;
	}

	/**
	 * Método encargado de retornar el tamaño de la tabla.
	 * @return tamanio. tamaño de la tabla.
	 */
	public int darTamanio() {
		return tamanio;
	}

	/**
	 * Método auxiliar que indica si el valor ingresado por parametro es booleano.
	 * @param numero. El número motivo de la consulta.
	 * @return esPrimo. Retorna un valor booleando que indica si el número del parametro es primo o si no.
	 */
	private boolean esPrimo(int numero){
		int desde = 2;
		int hasta = numero;
		boolean esPrimo=false;

		for (int i = desde; i <= hasta; i++) {
			esPrimo = true;

			for (int j = 2; j <= Math.sqrt(i) && esPrimo; j++) {
				if (i % j == 0) {
					esPrimo = false;
				}
			}
		}
		return esPrimo;
	}

	/**
	 * Método auxiliar necesario para buscar en una tabla una lista de elementos.
	 * @param nTabla tabla a la cual se le ejecutara la busqueda.
	 * @param key llave por la cual se buscara el conjunto de lementos.
	 * @return aRetornar. Lista con los elementos culla llave es la misma.
	 */
	private Lista<V> buscarHash(Lista<NodoTablaHashing<K, V>>[] nTabla, K key){
		int llave = hash(key);
		Lista<V> aRetornar=null;
		if(nTabla[llave]!=null){
			aRetornar=new Lista<V>();
			Elemento<NodoTablaHashing<K, V>>[] arregloTemp = nTabla[llave].darArreglo();
			int i=0;
			while(i<arregloTemp.length){
				aRetornar.agregar(arregloTemp[i].getElemento().darElemento());
				i++;
			}
		}
		return aRetornar;
	}

	/**
	 * Método auxiliar encargado de actualizar el factor de carga.
	 */
	private void actualizarFactorCarga(){
		factorCarga=tamanio/capacidad;
	}

	/**
	 * Método encargado de actualizar la tabla en caso de que se llegue a necesitar el hash.
	 * @param nTabla nueva tabla en la cual se agregara los datos de la tabla anterior.
	 * @param k llave el elemento a agregar.
	 * @param v elemento a agregar.
	 */
	private void doHash( Lista<NodoTablaHashing<K, V>>[] nTabla, K k, V v) {
		int llave=hash(k);
		if(buscarHash(nTabla, k)==null)
			nTabla[llave]=new Lista<NodoTablaHashing<K, V>>();
		nTabla[llave].agregar(new NodoTablaHashing<K, V>(k, v));
	}

	
	public void inicializarListas(Lista<NodoTablaHashing<K, V>>[] nTabla){
		for(int i=0;i<capacidad;i++){
			nTabla[i]=new Lista<NodoTablaHashing<K, V>>();
		}
	}
	

	
}