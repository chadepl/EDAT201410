package arbolBinario;

import java.util.Iterator;

public interface IArbolBinario	<T extends Comparable<T>> extends Iterable<T>{
	
	/**
	 * Retorna la altura del ������rbol.
	 * @return La altura del ������rbol.
	 */
	public int darAltura();
	
	/**
	 * Retorna el peso del ������rbol.
	 * @return El peso del ������rbol.
	 */
	public int darPeso();
	
	/**
	 * Busca un elemento en el ������rbol.
	 * @param aBuscar Elemento a buscar en el ������rbol.
	 * @return El elemento buscado.
	 */
	public T buscar(T aBuscar);
	
	/**
	 * Insterta un elemento en el ������rbol.
	 * @param aInsertar Elemento a instertar.
	 */
	public boolean agregar(T aInsertar);

	/**
	 * Elimina un elemento del ������rbol.
	 * @param aEliminar Elemento a eliminar.
	 * @return El ele ento eliminado.
	 */
	public T eliminar(T aEliminar);
}
