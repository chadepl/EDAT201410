package tablaHashingSimple;

public interface ITablaHashingSimple<K, V> extends Iterable<V>{
	/**
     * M��todo encargado de agregar un elemento a la tabla hashing.
	 * @param k. Llave del nuevo objeto.
     * @param V. Elemento a agregar.
	 * @return returna un valor booleano indicando true si se agrego o false en caso contrario.
	 */
	public boolean agregar(K k, V v);

	/**
	 * M��todo encargado de eliminar el conjunto de elementos que coinciden con la llave pasada por parametro.
     * @param k. Llave del grupo de objetos a eliminar.
	 * @return returna la lista de elementos que coinciden con esta llave.
	 */
	public V eliminar (K k);

	/**
	 * M��todo encargado de buscar el grupo de elementos que coinciden con la llave especificada en el paramentro.
     * @param k. Llave del grupo de objetos a buscar.
	 * @return returna la lista de elementos que coinciden con esta llave.
	 */
	public V buscar (K k);
}
