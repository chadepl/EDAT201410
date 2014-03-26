package tablaHashingSimple;

import java.io.Serializable;
import java.util.Iterator;

public class IteratorTablaSimple<V> implements Iterator<V>, Serializable {
	
	private int posicion;
	private NodoTablaHashing<?, V>[] tabla;
	public IteratorTablaSimple(NodoTablaHashing<?, V>[] aP){
		posicion=0;
		tabla=aP;
	}
	
	public boolean hasNext() {
		boolean bool=false;
		for(int i=posicion;i<tabla.length&&!bool;i++){
			if(tabla[posicion]!=null)bool=true;
		}
		return bool;
	}

	public V next() {
		V x=null;
		if(tabla[posicion]!=null)
			x=tabla[posicion].darElemento();
		else{
			for(int i=posicion;i<tabla.length&&x==null;i++)
				if(tabla[posicion]!=null)x=tabla[posicion].darElemento();
		}
		posicion++;
		return x;
	}

	public void remove() {
		tabla[posicion]=null;
	}

}
