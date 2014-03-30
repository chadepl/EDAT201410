package uniandes.cupi2.componenteBusqueda.mundo;



import java.util.Iterator;

import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;
import arbolBinAVL.ArbolBinAVL;
import arbolBinAVL.IArbolBinAVL;

public class Categoria implements Comparable<Categoria>{
	
	/**
	 * Nombre de la categoria.
	 */
	private String nombre;
	
	/**
	 * Descripcion de la categoria.
	 */
	private String descripcion;

	/**
	 * Arbol de recursos.
	 */
	private IArbolBinAVL<Resource> recursos;
	
	/**
	 * Constructor de la categoria.
	 */
	public Categoria(String nNombre, String nDescripcion){
		nombre=nNombre;
		descripcion=nDescripcion;
		recursos= new ArbolBinAVL<Resource>();
	}
	
	/**
	 * Retorna el nombre de la categoria.
	 * @return El nombre de la categoria.
	 */
	public String darNombre(){
		return nombre;
	}
	
	/**
	 * Retnora la descripcion de la categoria.
	 * @return La descripcion de la categoria.
	 */
	public String darDescripcion(){
		return descripcion;
	}
	
	/**
	 * Agrega un recurso al arbol de recursos de la categoria.
	 * @param nRecurso Recurso a agregar.
	 * @return True si se pudo agregar, false en caso contrario.
	 */
	public boolean agregarRecurso(Resource nRecurso){
		return recursos.agregar(nRecurso);
	}
	
	/**
	 * Elimina un recurso del arbol de recursos de la categoria.
	 * @param nRecurso Recurso a eliminar.
	 * @return El objeto eliminado si se encontro o nulo en caso contrario.
	 */
	public Resource eliminarRecurso(Resource nRecurso){
		return recursos.eliminar(nRecurso);
	}
	
	/**
	 * Busca un recurso en el arbol de recursos de la categoria.
	 * @param nRecurso El recurso a buscar.
	 * @return El objeto que se busca, nulo si no se encuentra.
	 */
	public Resource buscarRecurso(Resource nRecurso){
		return recursos.buscar(nRecurso);
	}
	
	/**
	 * Metodo que compara elementos de tipo categoria.
	 */
	public int compareTo(Categoria o) {
		if (nombre.compareTo(o.nombre) > 0)
			return 1;
		else if (nombre.compareTo(o.nombre) < 0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public Resource[] darRecursos(){
		recursos.agregar(new Resource("URL", "Tag", "Que es"));
		Iterator<Resource> i=recursos.iterator();
		Resource[] tempIndice=new Resource[recursos.darPeso()];
		int j=0;
		while(i.hasNext()){
			Resource temp=i.next();
			tempIndice[j]=temp;
			j++;
		}
		return tempIndice;
	}
		
	
	
}
