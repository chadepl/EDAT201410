package mundo;

import java.io.Serializable;
import java.util.Iterator;

import lista.Lista;
import trie.ITrie;
import trie.Trie;

public class Aeropuerto implements Comparable<Aeropuerto>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public Lista<Vuelo> listaVuelosSaliendo;
	
	/**
	 * Lista de vuelos del aeropuerto.
	 */
	public Lista<Vuelo> listaVuelosEntrando;
	
	/**
	 * Ciudad del aeropuerto.
	 */
	public String ciudad;
	
	/**
	 * Pais del aeropuerto.
	 */
	public String pais;
	
	/**
	 * Calificacion del aeropuerto.
	 */
	public int calificacion;
	
	/**
	 * Latitud de la ubicacion del aeropuerto.
	 */
	public String latitud;
	
	/**
	 * Longitud de la ubicacion del aeropuerto.
	 */
	public String longitud;
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
	public Aeropuerto(String nNombre,String nCodigo, String nCiudad,String nPais, String nLatitud, String nLongitud){
		nombre=nNombre;
		ciudad=nCiudad;
		codigo=nCodigo;
		pais=nPais;
		calificacion=0;
		arbolVuelos=new Trie<Vuelo>();
		listaVuelosEntrando=new Lista<Vuelo>();
		listaVuelosSaliendo=new Lista<Vuelo>();
		longitud=nLongitud;
		latitud=nLatitud;
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
	 * Cambia la calificacion del aeropuerto.
	 * @param nuevaCalificacion nueva calificacion del aeropuerto.
	 */
	public void cambiarCalificacion(int nuevaCalificacion){
		calificacion=nuevaCalificacion;
	}
	
	/**
	 * Agrega un vuelo al aeropuerto.
	 * @param aAgregar El vuelo a agregar al aerpuerto
	 * @return
	 */
	public boolean agregarVueloEntrando(Vuelo aAgregar){	
		return listaVuelosEntrando.agregar(aAgregar);
	}
	
	/**
	 * Agrega un vuelo al aeropuerto.
	 * @param aAgregar El vuelo a agregar al aerpuerto
	 * @return
	 */
	public boolean agregarVueloSaliendo(Vuelo aAgregar){	
		return listaVuelosSaliendo.agregar(aAgregar);
	}
	
	
	
	/**
	 * Retorna el nombre del aeropuerto.
	 * @return El nombre del aeropuerto.
	 */
	public String darNombre(){
		return nombre;
	}
	
	/**
	 * Retorna la latitud del aeropuerto.
	 * @return La latitud del aeropuerto.
	 */
	public String darLatitud(){
		return latitud;
	}
	
	/**
	 * Retorna la longitud del aeropuerto.
	 * @return La longitud del aeropuerto.
	 */
	public String darLongitud(){
		return longitud;
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
	public Iterator<Vuelo> darVuelosEntrando(){
		return listaVuelosEntrando.iterator();
	}
	
	/**
	 * Retorna el iterador de los vuelos.
	 * @return El iterador de los vuelos.
	 */
	public Iterator<Vuelo> darVuelosSaliendo(){
		return listaVuelosSaliendo.iterator();
	}
	
	/**
	 * Retorna la calificacion del aeropuerto.
	 * @return La calificacion del aeropuerto.
	 */
	public int darCalificacion(){
		return calificacion;
	}
	
	public String toString(){
		
		return nombre+" "+codigo+" "+ciudad+" "+pais;
	}

	/**
	 * Metodo de comparacion.
	 */
	public int compareTo(Aeropuerto o) {
		return codigo.compareTo(o.darCodigo());
	}
}
