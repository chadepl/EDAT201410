package uniandes.cupi2.componenteBusqueda.mundo;

import huffman.Texto;
import huffman.TextoCompactadoHuffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import arbolBinAVL.ArbolBinAVL;
import arbolBinAVL.IArbolBinAVL;
import lista.Lista;
import lista.Elemento;
import uniandes.cupi2.componenteBusqueda.webCrawler.Engine;
import uniandes.cupi2.componenteBusqueda.webCrawler.Query;
import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;
import uniandes.cupi2.cupIphone.core.ICore;


public class ComponenteBusqueda implements IComponenteBusqueda{

	private final static String RUTA="./Serializados";

	private ICore core;	

	private TextoCompactadoHuffman comprimido;

	private IArbolBinAVL<Resource> indice;

	private Engine engine;

	private Lista<String> enlaces;

	private IArbolBinAVL<Query> exploraciones;

	private IArbolBinAVL<Categoria> categorias;

	
	
	public ComponenteBusqueda(ICore core){
		this.core=core;
//		File f = new File(core.darDirectorioDatos(), "data.indice");
//    	try{
//    		indice = (ArbolBinAVL<Resource>) new ObjectInputStream(new FileInputStream(f)).readObject();
//    		
//    	}
//    	catch (Exception e){
//    		indice = new ArbolBinAVL<Resource>();
//    	}
		comprimido=null;
		exploraciones=new ArbolBinAVL<Query>();
		categorias=new ArbolBinAVL<Categoria>();
		enlaces=new Lista<String>();
		engine=new Engine();
		indice=new ArbolBinAVL<Resource>();
	}

	/**
	 * 
	 */
	public void guardarComprimido(String texto) throws IOException{
		Texto aComprimir=new Texto(texto);
		comprimido=aComprimir.comprimirHuffman();
		comprimido.salvar(new File(RUTA));

	}

	/**
	 * 
	 * @param URL
	 * @return
	 */
	public boolean agregarSitioFuente(String URL){
		if(enlaces.contiene(URL)){
			return false;
		}
		else{
			enlaces.agregar(URL);
			return true;
		}
	}

	/**
	 * 
	 * @param profundidad
	 * @throws Exception 
	 */
	public void realizarExploracion(int profundidad) throws Exception{
		String[] tempStrings=new String[enlaces.darLongitud()];
		for(int i=0;i<tempStrings.length;i++){
			tempStrings[i]=enlaces.dar(i);
		}
		Query tempQuery=engine.explore(tempStrings, profundidad);
		Lista<Resource> tempResources=tempQuery.getResources();
		Iterator<Resource> i=tempResources.iterator();
		while(i.hasNext()){
			Resource temp=i.next();
			indice.agregar(temp);
		}
		exploraciones.agregar(tempQuery);
		enlaces.clear();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Query darEstadisticasDeExploracion(String id){
		Query temp=null;
		Iterator<Query> i=exploraciones.iterator();
		while(i.hasNext()){
			Query tempExp=i.next();
			if(tempExp.toString().equals(id)){
				temp=tempExp;
			}
		}
		return temp;
	}

	/**
	 * 
	 * @return
	 */
	public Query[] darHistorialExploraciones(){
		Query[] temp=new Query[exploraciones.darPeso()];
		int i=0;
		Iterator<Query> iter=exploraciones.iterator();
		while(iter.hasNext()){
			Query temporal=iter.next();
			temp[i]=temporal;
			i++;
		}
		return temp;
	}
	
	public Query[] darHistorialExploraciones2(){
		Query[] temp=new Query[engine.getHistory().darLongitud()];
		int i=0;
		Iterator<Query> iter=engine.getHistory().iterator();
		while(iter.hasNext()){
			Query temporal=iter.next();
			temp[i]=temporal;
			i++;
		}
		return temp;
	}

	/**
	 * 
	 * @param nNombre
	 * @param nDescripcion
	 * @return
	 */
	public boolean crearCategoria(String nNombre, String nDescripcion){
		Categoria temp=new Categoria(nNombre, nDescripcion);
		boolean bool=categorias.agregar(temp);
//		if(bool)rgstr.grabarCategoria(categorias.buscar(temp));
		return bool;
	}

	/**
	 * 
	 * @param nNombre
	 * @return
	 */
	public Categoria eliminarCategoria(String nNombre){
		Categoria x=null;
		Iterator<Categoria> i=categorias.iterator();
		while(i.hasNext()){
			Categoria temp=i.next();
			if(temp.darNombre().equals(nNombre)){
				x=(categorias.eliminar(temp));
			}
		}
		return x;
	}

	/**
	 * 
	 * @param nRecurso
	 * @param nCategoria
	 * @return
	 */
	public boolean agregarRecursoACategoria(Resource nRecurso, String nCategoria){
		boolean bool=false;
		Categoria cat=null;
		Iterator<Categoria> i=categorias.iterator();
		while(i.hasNext()){
			Categoria temp=i.next();
			if(temp.darNombre().equals(nCategoria)){
				cat=temp;
			}
		}
		if(cat!=null){
			bool=cat.agregarRecurso(nRecurso);
//			if(bool)rgstr.registarCategoria(cat);
		}
		return bool;
	}

	/**
	 * 
	 * @param nRecurso
	 * @param nCategoria
	 * @return
	 */
	public Resource eliminarRecursoDeCategoria(Resource nRecurso, String nCategoria){
		Resource rsrc=null;
		Categoria cat=null;
		Iterator<Categoria> i=categorias.iterator();
		while(i.hasNext()){
			Categoria temp=i.next();
			if(temp.darNombre().equals(nCategoria)){
				cat=temp;
			}
		}
		if(cat!=null){
			rsrc=cat.eliminarRecurso(nRecurso);
		}
		return rsrc;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String cargarComprimido() throws Exception{
		Texto compreso=comprimido.descomprimir();
		return compreso.toString();
	}

	/**
	 * 
	 */
	@Override
	public Iterator<Resource> consultarRecursos(String criterio) {
		Lista<Resource> list=new Lista<Resource>();
		Iterator<Resource> i=indice.iterator();
		while(i.hasNext()){
			Resource temp=i.next();
			if(temp.toString().equals(criterio)){
				list.agregar(temp);
			}
		}
		return list.iterator();
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] darArregloSitios(){
		Iterator<String> i=enlaces.iterator();
		String[] tempEnlaces=new String[enlaces.darLongitud()];
		int j=0;
		while(i.hasNext()){
			String temp=i.next();
			tempEnlaces[j]=temp;
			j++;
		}
		return tempEnlaces;
	}

	/**
	 * 
	 * @return
	 */
	public Resource[] darArregloIndice(){
		Iterator<Resource> i=indice.iterator();
		Resource[] tempIndice=new Resource[indice.darPeso()];
		int j=0;
		while(i.hasNext()){
			Resource temp=i.next();
			tempIndice[j]=temp;
			j++;
		}
		return tempIndice;
	}
	
	/**
	 * 
	 * @return
	 */
	public Categoria[] darArregloCategorias(){
		Iterator<Categoria> i=categorias.iterator();
		Categoria[] tempIndice=new Categoria[categorias.darPeso()];
		int j=0;
		while(i.hasNext()){
			Categoria temp=i.next();
			tempIndice[j]=temp;
			j++;
		}
		return tempIndice;
	}
	
	
	@Override
	public String mostrarResultadoDeBusqueda(Query nExploracion) {
		return (exploraciones.buscar((Query) nExploracion)!=null)?exploraciones.buscar((Query) nExploracion).toString():"";
	}

	public void guardar(){
		File f = new File(core.darDirectorioDatos(), "datos.indice");
		try{
			new ObjectOutputStream(new FileOutputStream(f)).writeObject(indice);    		
		}
		catch (Exception e) {
			System.err.println("No se pudo guardar los datos");
			e.printStackTrace();
		}
	}
	
	public ArbolBinAVL<Categoria> darCategorias(){
		return null;
		
	}

}
