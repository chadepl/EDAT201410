package mundo;

import java.util.Iterator;

import lista.Lista;
import trie.ITrie;
import trie.Trie;

public class Aeropuerto {
	
	/**
	 * Nombre del aeropuerto.
	 */
	public String nombre;
	
	/**
	 * Arbol de vuelos del aeropuerto.
	 */
	public ITrie<Vuelo> arbolVuelos;
	
	/**
	 * Lista de vuelos del aeropuerto.
	 */
	public Lista<Vuelo> listaVuelos;
	
	/**
	 * Ciudad del aeropuerto.
	 */
	public String ciudad;
	
	/**
	 * Pais del aeropuerto.
	 */
	public String pais;
	
	/**
	 * Codigo del aeropuerto.
	 */
	public String codigo;
	
	/**
	 * Constructor de la clase,
	 * @param nNombre nuevo nombre del aeropuerto. nNombre!=null.
	 * @param nCiudad nueva ciudad del aeropuerto. nCiudad!=null.
	 * @param nCodigoCiudad nuevo codigo de la ciudad del aeropuerto. nCodigoCiudad!=null.
	 * @param nPais nuevo pais del aeropuerto. nPais!=null
	 */
	public Aeropuerto(String nNombre,String nCodigo, String nCiudad,String nPais){
		nombre=nNombre;
		ciudad=nCiudad;
		codigo=nCodigo;
		pais=nPais;
		arbolVuelos=new Trie<Vuelo>();
		listaVuelos=new Lista<Vuelo>();
	}
	
	/**
	 * Cambia el nombre del aeropuerto.
	 * @param nNombre nuevo nombre del aeropuerto.
	 */
	public void cambiarNombre(String nNombre){
		nombre=nNombre;
	}
	
	/**
	 * Cambia la ciudad del aeropuerto.
	 * @param nCiudad nueva ciudad del aeropuerto.
	 */
	public void cambiarCiudad(String nCiudad){
		ciudad=nCiudad;
	}
	
	/**
	 * Cambia el pais del aeropuerto.
	 * @param nPais nuevo pais del aeropuerto.
	 */
	public void cambiarPais(String nPais){
		pais=nPais;
	}
	
	/**
	 * Retorna el nombre del aeropuerto.
	 * @return El nombre del aeropuerto.
	 */
	public String darNombre(){
		return nombre;
	}
	
	/**
	 * Retorna la ciiudad del aeropuerto.
	 * @return La ciudad del aeropuerto.
	 */
	public String darCiudad(){
		return ciudad;
	}
	
	/**
	 * Retorna el pais del aeropuerto.
	 * @return El pais del aeropuerto.
	 */
	public String darPais(){
		return pais;
	}
	
	/**
	 * Retorna el codigo del aeropuerto.
	 * @return El codigo del aeropuerto.
	 */
	public String darCodigo(){
		return codigo;
	}
	
	/**
	 * Retorna el iterador de los vuelos.
	 * @return El iterador de los vuelos.
	 */
	public Iterator<Vuelo> darVuelos(){
		return listaVuelos.iterator();
	}
	
	public String toString(){
		
		return nombre+" "+codigo+" "+ciudad+" "+pais;
	}
}
