package mundo;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

public interface ICupiFlight {
	
	/**
	 * Carga la informacion de 50 aeropuertos como minimo.
	 */
	public void cargarInformacionBase() throws IOException;
	
	/**
	 * Agrega un aeropuerto al sistema.
	 * @param codigo Codigo del aeropuerto a eliminar.
	 * @return True si se pudo arreglar. Falso en caso contrario.
	 */
	public Aeropuerto agregarAeropuerto(String codigo) throws IOException;
	
	/**
	 * Elimina un aeropuerto del sistema.
	 * @param codigo Codigo del aeropuerto a eliminar.
	 * @return El elemento eliminado si se pudo realizar la accion. Null en caso contrario.
	 */
	public Aeropuerto eliminarAeropuerto(String codigo);
	
	/**
	 * Califica un aeropuerto del sistema.
	 * @param calificacion Calificacion del sistema. calificacion>=0. calificacion<=5.
	 */
	public void calificarAeropuerto(int calificacion);
	
	/**
	 * * Consulta la calificacion de un aeropuerto.
	 * @param aInvestigar aeropuerto a consultar su calificacion.
	 * @return La calificacion del aeropuerto.
	 */
	public int consultarCalificacion(Aeropuerto aInvestigar);
	
	/**
	 * Consulta las fechas del sistema.
	 * @return Las fechas del sistema.
	 */
	public Iterator<Date> fechasDelSistema();
	
	/**
	 * Consultar los aeropuertos del sistema.
	 * @return Los aeropuertos del sistema.
	 */
	public Iterator<Aeropuerto> consultarAeropuertos();
	
	/**
	 * Consultar los vuelos de un aeropuerto en la fecha dada.
	 * @param aBuscar El aeropueto a buscar los vuelos.
	 * @param fecha La fecha de busqueda.
	 * @return Los vuelos del aeropuerto en la fecha dada.
	 */
	public Iterator<Vuelo> consultarVuelos(Aeropuerto aBuscar, Date fecha);
	
	/**
	 * Metodo auxiliar para consultar los vuelos a tiempo entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos a tiempo para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosATiempo(Date fechaInicial, Date fechaFinal);
	
	/**
	 * Metodo auxiliar para consultar los vuelos cancelados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos cancelados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosCancelados(Date fechaInicial, Date fechaFinal);
	
	/**
	 * Metodo auxiliar para consultar los vuelos retrasados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos retrasados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosRetrasados(Date fechaInicial, Date fechaFinal);
	
	/**
	 * Buscar vuelos segun un rango de calificacion.
	 * @param calificacionInicial Calificacion inicial de filtrado.
	 * @param calificacionFinal Calificacion final de filtrado.
	 * @return Los vuelos dentro del rango especificado.
	 */
	public Iterator<Vuelo> buscarVuelosRangoCalificacion(int calificacionInicial, int calificacionFinal);
	
	/**
	 * Busca las aerolineas con mas vuelos retrasados.
	 * @return Las aerolineas con mas vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMasVuelosRetrasados();
	
	/**
	 * Busca las aerolineas con menos vuelos retrasados.
	 * @return Las aerolineas con menos vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMenosVuelosRetrasados();
	
	/**
	 * Muestra el mapa segun tardanza.
	 */
	public void mostrarMapaTardanza();
}
