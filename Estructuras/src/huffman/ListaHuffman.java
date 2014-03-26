package huffman;

import java.io.Serializable;

public class ListaHuffman implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private int numeroDeElementos;
	
	private NodoHuffman cab;
	
	/**
	 * Metodo constructor de la lista Huffman que la inicializa vacia
	 */
	public ListaHuffman() {
		
		cab=null;
		
		numeroDeElementos=0;
		
	}
	
	/**
	 * Metodo que se encarga de insertar un nodo de manera ordenada
	 * @param nodo Nodo que se va a insertar
	 */
	public void insertarOrdenado(NodoHuffman nodo){
		
		if(cab==null){
			cab=nodo;
		}else if(nodo.darFrecuencia()<cab.darFrecuencia()){
			cab.insertarAntes(nodo);
			cab=nodo;
		}else{
			NodoHuffman n=cab;
			while(n.darSiguiente()!=null && n.darSiguiente().darFrecuencia()<nodo.darFrecuencia()){
				n=n.darSiguiente();
			}
			n.insertarDespues(nodo);
		}
		numeroDeElementos++;
		
	}
	
	/**
	 * Metodo auxiliar que toma el primer nodo tambien llamado cabeza
	 * @return El nodo que fue tomado 
	 */
	public NodoHuffman tomarPrimero() {
		NodoHuffman n = cab;
		cab = cab.desconectarPrimero();
		numeroDeElementos--;
		return n;
	}
	
	/**
	 * Metodo que se encarga de generar un arbol de Huffman a partir de una lista
	 */
	public void generarArbolHuffman(){
		if(numeroDeElementos==1){
			NodoHuffman nodo=new NodoHuffman(tomarPrimero());
			insertarOrdenado(nodo);
		}else{
			while(numeroDeElementos>1){
				NodoHuffman n1=tomarPrimero();
				NodoHuffman n2=tomarPrimero();
				
				NodoHuffman nuevoNodo=new NodoHuffman(n1,n2);
				insertarOrdenado(nuevoNodo);
			}
		}
		if(cab!=null)
			cab.generarCodigos();
	}

}
