package mundo;

public class Aerolinea {
	
	/**
	 * Nombre de la aerolinea.
	 */
	public String nombre;
	
	/**
	 * Numero de telefono de la aerolinea.
	 */
	public String phoneNumber;
	
	/**
	 * Constructor de la clase.
	 * @param nNombre nombre de la aerolinea.
	 * @param nPhoneNumber numero de la aerolinea.
	 */
	public Aerolinea(String nNombre, String nPhoneNumber){
		nombre=nNombre;
		phoneNumber=nPhoneNumber;
	}
	
	/**
	 * Cambia el nombre de la arolinea.
	 * @param nNombre nuevo nombre de la aerolinea.
	 */
	public void cambiarNombre(String nNombre){
		nombre=nNombre;
	}
	
	/**
	 * Cambia el numero de la aerolinea.
	 * @param nPhoneNumber nuevo numero de la aerolinea.
	 */
	public void cambiarNumero(String nPhoneNumber){
		phoneNumber=nPhoneNumber;
	}
	
	/**
	 * Retorna el nombre de la aerolinea.
	 * @return El nombre de la aerolinea.
	 */
	public String darNombre(){
		return nombre;
	}
	
	/**
	 * Retorna el numero telefonico de la aerolinea.
	 * @return El numero telefonico de la aerolinea.
	 */
	public String darNumero(){
		return phoneNumber;
	}
}
