package mundo;

import java.io.Serializable;

import lista.Lista;
import trie.Trie;

public class Aerolinea implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre de la aerolinea.
	 */
	public String nombre;
	
	/**
	 * Codigo de la aerolinea.
	 */
	public String fs;
	
	/**
	 * Lista de vuelos.
	 */
	public Lista<Vuelo> listaVuelos;
	
	
	
	/**
	 * Constructor de la clase.
	 * @param nNombre nombre de la aerolinea.
	 * @param nPhoneNumber numero de la aerolinea.
	 */
	public Aerolinea(String nNombre,  String nCodigo){
		nombre=nNombre;
		listaVuelos=new Lista<Vuelo>();
		fs=nCodigo;
	}
	
	/**
	 * Cambia el nombre de la arolinea.
	 * @param nNombre nuevo nombre de la aerolinea.
	 */
	public void cambiarNombre(String nNombre){
		nombre=nNombre;
	}
	
	
	/**
	 * Agrega un vuelo a la aerolinea.
	 * @param aAgregar el vuelo a agregar.
	 */
	public void agregarVuelo(Vuelo aAgregar){
		listaVuelos.agregar(aAgregar);
	}
	
	/**
	 * Elimina un vuelo de los vuelos.
	 * @return El vuelo eliminado.
	 */
	public boolean eliminarVuelo(Vuelo aEliminar){
		return listaVuelos.eliminar(aEliminar);
	}
	
	/**
	 * Retorna el nombre de la aerolinea.
	 * @return El nombre de la aerolinea.
	 */
	public String darNombre(){
		return nombre;
	}
	
	
	/**
	 * Retorna el codigo de la aerolinea.
	 * @return El codigo de la aerolinea.
	 */
	public String darCodigo(){
		return fs;
	}
	
	/**
	 * Devuelve la cantidad de vuelos retrasados.
	 * @return La cantidad de vulos retrasados.
	 */
	public int darCantidadVuelosRetrasados(){
		int aRetornar=0;
		for(int i=0;i<listaVuelos.darLongitud();i++){
			Vuelo temp=listaVuelos.dar(i);
			if(temp.darLate15()>0&&temp.darLate30()>0&&temp.darLate45()>0){
				aRetornar++;
			}
		}
		return aRetornar;
	}
}
