package tablaHashingSimple;

import java.io.Serializable;
import java.util.Iterator;

public class TablaHashingSimple<K, V> implements ITablaHashingSimple<K, V>,Serializable{

	public static final double INCREMENTO=0.3;

	public static final double LIMITE=0.7;

	public NodoTablaHashing<K, V>[] areaPrimaria;

	public int capacidad;

	public int tamanio;

	public double factorCarga;

	public TablaHashingSimple(int nCapacidad){
		capacidad=nCapacidad;
		tamanio=0;
		factorCarga=0.0;
		areaPrimaria=new NodoTablaHashing[capacidad];
	}

	public int hash(K key){
		return Math.abs(key.hashCode()%capacidad);
	}
	public boolean agregar(K k, V v) {
		if((tamanio+1)/capacidad>LIMITE)reaHash();
		int llave=hash(k);
		boolean bool=false;
		if(areaPrimaria[hash(k)]!=null){
			int i=llave;
			while(i<areaPrimaria.length&&!bool){
				if(areaPrimaria[i]==null){
					areaPrimaria[i]=new NodoTablaHashing<K, V>(k, v); bool=true;
					actualizarFactorDeCarga();
					tamanio++;
				}
				i++;
			}
			for(int j=0;j<llave&&!bool;j++){
				if(areaPrimaria[j]==null){
					areaPrimaria[j]=new NodoTablaHashing<K, V>(k, v); bool=true;
					actualizarFactorDeCarga();
					tamanio++;
				}
			}
		}
		else{
			areaPrimaria[llave]=new NodoTablaHashing<K, V>(k, v); bool=true;
			actualizarFactorDeCarga();
			tamanio++;
		}
		return bool;
	}

	public V eliminar(K k) {
		int llave=hash(k);
		V x=null;
		if(areaPrimaria[llave]!=null){
			if(areaPrimaria[llave].darLlave().equals(k)){
				areaPrimaria[llave]=null;
				x=areaPrimaria[llave].darElemento();
				tamanio--;
				actualizarFactorDeCarga();
			}
			else{
				for(int i=llave;i<areaPrimaria.length&&x==null;i++){
					if(areaPrimaria[i].darLlave().equals(k)){
						x=areaPrimaria[i].darElemento();
						areaPrimaria[i]=null;
						tamanio--;
						actualizarFactorDeCarga();
					}
				}
				for(int j=0;j<llave&&x==null;j++){
					if(areaPrimaria[j].darLlave().equals(k)){
						x=areaPrimaria[j].darElemento();
						areaPrimaria[j]=null;
						tamanio--;
						actualizarFactorDeCarga();

					}
				}
			}
		}
		return x;
	}

	public V buscar(K k) {
		int llave=hash(k);
		V x=null;
		if(areaPrimaria[llave]!=null){
			if(areaPrimaria[llave].darLlave().equals(k)){
				x=areaPrimaria[llave].darElemento();
			}
			else{
				for(int i=llave;i<areaPrimaria.length&&x==null;i++){
					if(areaPrimaria[i].darLlave().equals(k))x=areaPrimaria[i].darElemento();
				}
				for(int j=0;j<llave&&x==null;j++){
					if(areaPrimaria[j].darLlave().equals(k))x=areaPrimaria[j].darElemento();
				}
			}
		}
		return x;
	}

	private void reaHash() {
		int nuevaCapacidad=(int) (capacidad+(INCREMENTO*capacidad));
		if(esPrimo(nuevaCapacidad)){
			capacidad=nuevaCapacidad;
		}
		else{
			boolean bool=false;
			int proximoPrimo=0;
			for(int i=nuevaCapacidad+1;i<Integer.MAX_VALUE&&!bool;i++){
				if(esPrimo(i)){
					proximoPrimo=i;
					bool=true;
				}
			}
			capacidad=proximoPrimo;
		}
		NodoTablaHashing<K, V>[] nAP= new NodoTablaHashing[capacidad];
		doHash(nAP);
		areaPrimaria=nAP;
	}
	
	private boolean esPrimo(int numero) {
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

	private void doHash(NodoTablaHashing<K, V>[] nAP) {
		for(int i=0;i<areaPrimaria.length;i++){
			if(areaPrimaria[i]!=null){
				agregarALista(nAP, areaPrimaria[i].darLlave(), areaPrimaria[i].darElemento());
			}
		}
	}
	
	private boolean agregarALista(NodoTablaHashing<K,V>[] aP, K k, V v) {
		int llave=hash(k);
		boolean bool=false;
		if(aP[hash(k)]!=null){
			int i=llave;
			while(i<aP.length&&!bool){
				if(aP[i]==null){
					aP[i]=new NodoTablaHashing<K, V>(k, v); bool=true;
				}
				i++;
			}
			for(int j=0;j<llave&&!bool;j++){
				if(aP[j]==null){
					aP[j]=new NodoTablaHashing<K, V>(k, v); bool=true;
				}
			}
		}
		else{
			aP[llave]=new NodoTablaHashing<K, V>(k, v); bool=true;
		}
		return bool;
	}

	private void actualizarFactorDeCarga() {
		factorCarga=tamanio/capacidad;
	}

	public Iterator<V> iterator() {
		return new IteratorTablaSimple(areaPrimaria);
	}
}
