package arbolBinario;

public class ElementoExistenteException extends Exception {
	
	/**
	 * Excepci������n lanzada cuando existe el elemento en el ������rbol.
	 * @param mensaje Mensaje de la excepci������n.
	 */
	public ElementoExistenteException(String mensaje){
		super(mensaje);
	}
}
