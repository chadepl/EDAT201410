package uniandes.cupi2.componenteBusqueda.mundo;

import java.io.IOException;
import java.util.Iterator;

import uniandes.cupi2.componenteBusqueda.webCrawler.Query;
import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;



public interface IComponenteBusqueda {

	/**
	 * 
	 * @param URL
	 * @return
	 */
	public boolean agregarSitioFuente(String URL);

	/**
	 * 
	 * @param profundidad
	 * @throws Exception 
	 */
	public void realizarExploracion(int profundidad) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Query darEstadisticasDeExploracion(String id);
	
	/**
	 * 
	 * @return
	 */
	public Query[] darHistorialExploraciones();

	/**
	 * 
	 * @param criterio
	 * @return
	 */
	public Resource[] consultarRecursos(String palabraClave,String criterio1,String[] criterios);
	
	/**
	 * 
	 * @param nNombre
	 * @param nDescripcion
	 * @return
	 */
	public boolean crearCategoria(String nNombre, String nDescripcion);

	/**
	 * 
	 * @param nNombre
	 * @return
	 */
	public Categoria eliminarCategoria(String nNombre);

	/**
	 * 
	 * @param nRecurso
	 * @param nCategoria
	 * @return
	 */
	public boolean agregarRecursoACategoria(Resource nRecurso, String nCategoria);

	/**
	 * 
	 * @param nRecurso
	 * @param nCategoria
	 * @return
	 */
	public Resource eliminarRecursoDeCategoria(Resource nRecurso, String nCategoria);
	
	/**
	 * 
	 * @param texto
	 * @throws IOException
	 */
	public void guardarComprimido(String texto) throws IOException;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String cargarComprimido() throws Exception;
	
	/**
	 * 
	 * @param nExploracion
	 * @return
	 */
	public String mostrarResultadoDeBusqueda(Query nExploracion);
}
