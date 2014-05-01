package mundo;

import java.io.Serializable;
import java.util.Date;

public class Vuelo implements Serializable{

	//-----------------------
	//Atributos
	//-----------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	/**
	 * Calificacion del vuelo.
	 */
	private double calificacion;
	
	/**
	 * Late 15.
	 */
	private int late15;
	
	/**
	 * Late 30.
	 */
	private int late30;
	/**
	 * Late 15.
	 */
	private int late45;
	
	/**
	 * Numero de vuelos cancelados.
	 */
	public int cancelados;
	
	/**
	 * Codigo del vuelo.
	 */
	public String codigo;

	/**
	 * Ontime del vuelo.
	 */
	private int ontime;
	
	/**
	 * Aerolinea
	 */
	public String aerolinea;
	

	
	//-----------------------
	//Constructor
	//-----------------------
	/**
	 * Constructor de la clase.
	 * @param origen Lugar de salida del vuelo.
	 * @param destino Lugar a donde llegara el vuelo.
	 * @param fechaDeVuelo Fecha de vuelo.
	 */
	public Vuelo(Aeropuerto nOrigen, Aeropuerto nDestino, Date nFechaDeVuelo,  String nCodigo,String nAerolinea, double nCalificacion, int nLate15,int nLate30, int nLate45, int nCancelados, int nOntime){
		origen=nOrigen;
		destino=nDestino;
		fechaDeVuelo=nFechaDeVuelo;
		aerolinea=nAerolinea;
		calificacion=nCalificacion;
		late15=nLate15;
		late30=nLate30;
		late45=nLate45;
		cancelados=nCancelados;
		codigo=nCodigo;
		ontime=nOntime;
	}

	//-----------------------
	//Metodos
	//-----------------------
	
	/**
	 * Cambia la calificacion del vuelo.
	 * @param nCalificacion La nueva calificacion del vuelo.
	 */
	public void cambiarCalificacion(int nCalificacion){
		calificacion=nCalificacion;
	}
	
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
	 * Retorna la calificacion del vuelo.
	 * @return La calificacion del vuelo.
	 */
	public double darCalificacion(){
		return calificacion;
	}
	/**
	 * Retorna la fecha del vuelo.
	 * @return	La fecha del vuelo.
	 */
	public Date darFechaDeVuelo(){
		return fechaDeVuelo;
	}
	
	/**
	 * Retorna el late 15 del vuelo.
	 * @return El late 15 del vuelo.
	 */
	public double darLate15(){
		return late15;
	}
	
	/**
	 * Retorna el late 30 del vuelo.
	 * @return El late 30 del vuelo.
	 */
	public double darLate30(){
		return late30;
	}
	
	/**
	 * Retorna el late 45 del vuelo.
	 * @return El late 45 del vuelo.
	 */
	public double darLate45(){
		return late45;
	}
	
	/**
	 * Retorna la cantidad de vuelos cancelados.
	 * @return La cantidad de vuelos cancelados.
	 */
	public int darCancelados(){
		return cancelados;
	}
	
	/**
	 * Retorna el codigo del vuelo.
	 * @return El codigo del vuelo.
	 */
	public String darCodigo(){
		return codigo;
	}
	
	/**
	 * 
	 * Retorna el ontime del vuelo.
	 * @return El ontime del vuelo.
	 */
	public int darOntime(){
		return ontime;
	}
}
