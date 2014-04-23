package mundo;

import java.util.Date;

public class Vuelo{

	//-----------------------
	//Atributos
	//-----------------------

	/**
	 * Lugar de salida del vuelo.
	 */
	private Aeropuerto origen;

	/**
	 * Lugar a donde llegara el vuelo.
	 */
	private Aeropuerto destino;

	/**
	 * Fecha del vuelo.
	 */
	private Date fechaDeVuelo;

	//-----------------------
	//Constructor
	//-----------------------
	/**
	 * Constructor de la clase.
	 * @param origen Lugar de salida del vuelo.
	 * @param destino Lugar a donde llegara el vuelo.
	 * @param fechaDeVuelo Fecha de vuelo.
	 */
	public Vuelo(Aeropuerto nOrigen, Aeropuerto nDestino, Date nFechaDeVuelo){
		origen=nOrigen;
		destino=nDestino;
		fechaDeVuelo=nFechaDeVuelo;
	}

	//-----------------------
	//Metodos
	//-----------------------
	
	/**
	 * Cambia el origen del vuelo.
	 * @param nOrgien
	 */
	public void cambiarOrigen(Aeropuerto nOrgien){
		origen=nOrgien;
	}

	/**
	 * Cambia el destino del vuelo.
	 * @param nDestino
	 */
	public void cambiarDestino(Aeropuerto nDestino){
		destino=nDestino;
	}

	/**
	 * Cambia la fecha del vuelo.
	 * @param nFechaDeVuelo 
	 */
	public void cambiarFechaDeVuelo(Date nFechaDeVuelo){
		fechaDeVuelo=nFechaDeVuelo;
	}

	/**
	 * Retorna el origen del vuelo.
	 * @return El origen del vuelo.
	 */
	public Aeropuerto darOrigen(){
		return origen;
	}

	/**
	 * Retorna el destino del vuelo.
	 * @return	El destino del vuelo.
	 */
	public Aeropuerto darDestino(){
		return destino;
	}

	/**
	 * Retorna la fecha del vuelo.
	 * @return	La fecha del vuelo.
	 */
	public Date darFechaDeVuelo(){
		return fechaDeVuelo;
	}
}
