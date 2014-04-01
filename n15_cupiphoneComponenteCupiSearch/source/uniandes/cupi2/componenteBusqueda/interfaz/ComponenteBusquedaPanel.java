package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.componenteBusqueda.mundo.Categoria;
import uniandes.cupi2.componenteBusqueda.mundo.ComponenteBusqueda;
import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;

import java.awt.Dimension;
import java.util.Iterator;

public class ComponenteBusquedaPanel extends JPanel {

	
	
	
	public static void main(String[] args) {
		JFrame frim=new JFrame();
		frim.setSize(new Dimension(330,540));
		ComponenteBusquedaPanel f=new ComponenteBusquedaPanel(mundo);
		frim.getContentPane().add(f);
		frim.setVisible(true);
	}
	
	private  static ComponenteBusqueda mundo;
	
	private PanelBienvenida bienvenida;
	private PanelExploracion exploracion;
	private PanelBusqueda busqueda;
	private PanelResultadosBusqueda resultados;
	private PanelHistorial historial;
	private PanelCategorias categorias;
	private PanelRecursos recursos;
	private PanelAgregarCategoria agregar;
	private PanelMostrarRecurso mostrarRecurso;
	
	private String ruta;
	
	private Resource[] respuesta;
	
	/**
	 * Create the panel.
	 */
	public ComponenteBusquedaPanel(ComponenteBusqueda ventana) {
		if (ventana != null) {
			mundo = ventana;
		} else {
			mundo = new ComponenteBusqueda(null);
		}

		ruta = mundo.darRuta();

		setPreferredSize(new Dimension(330, 540));

		bienvenida = new PanelBienvenida(this);
		add(bienvenida);

	}
	
	/**
	 * Indica al panel que se debe terminar la ejecuci�n
	 */
	public void terminar() {
		//componenteContactos.guardar();		
	}
	
	
	//////////////////////////////
	//METODOS PARA MOSTRAR PANELES
	//////////////////////////////
	
	public void mostrarExploracion(){
		remove(bienvenida);
		add(exploracion = new PanelExploracion(this));
	}
	
	public void mostrarBusqueda() {
		remove(bienvenida);
		add(busqueda = new PanelBusqueda(this));
		
	}
	
	public void mostrarCategorias() {
		remove(bienvenida);
		Categoria[] arreglo=mundo.darArregloCategorias();
		add(categorias= new PanelCategorias(this,arreglo));
		
	}
	
	public void mostrarAgregar() {
		remove(categorias);
		add(agregar=new PanelAgregarCategoria(this));
	}

	private void mostrarPanelRescursos() {
		remove(exploracion);
		Resource[] arreglo=mundo.darArregloIndice();
		add(recursos= new PanelRecursos(this,arreglo));
	}

	public void mostrarBusquedaDesdeResultados(){
		remove(resultados);
		add(busqueda=new PanelBusqueda(this));
	}
	
	
	/////////////////////////////////
	//METODOS PARA CAMBIAR DE PANELES
	////////////////////////////////
	
	public void volverDesdeExploracion() {
		remove(exploracion);
		add(bienvenida=new PanelBienvenida(this));
		
	}
	
	public void volverDesdeCategorias() {
		remove(categorias);
		add(bienvenida=new PanelBienvenida(this));
	}
	
	public void volverDesdeRecursos() {
		remove(recursos);
		add(bienvenida=new PanelBienvenida(this));
	}
	
	public void volverDesdeHistorial() {
		remove(historial);
		add(bienvenida=new PanelBienvenida(this));
	}
	
	public void volverDesdeMostrarRecursos() {
		remove(mostrarRecurso);
		add(bienvenida=new PanelBienvenida(this));
	}
	
	public void volverDesdeBusqueda() {
		remove(busqueda);
		add(bienvenida=new PanelBienvenida(this));
	}
	
	public void volverDesdeResultados(){
		remove(resultados);
		add(busqueda = new PanelBusqueda(this));
	}
	
	
	////////////////////////////////////
	
	public void darHistorial() {
		remove(bienvenida);
		add(historial = new PanelHistorial(this,mundo.darHistorialExploraciones2()));
		
	}
	
	
	
	
	public void mostrarRescurso(String thingTagged) {
		remove(resultados);
		add(mostrarRecurso=new PanelMostrarRecurso(this,thingTagged));
		
	}

	

	
	//////////////////////////////////
	//METODOS DE CONEXION CON EL MUNDO
	/////////////////////////////////
	
	
	public void anadirSitio(String text) {
		mundo.agregarSitioFuente(text);
	}
	
	public void iniciarExploracion(int i) {
		try{
		mundo.realizarExploracion(i);
		mostrarPanelRescursos();
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Problemas");
		}
	}
	
	public void buscar(String palabraClave, String criterio, String[] criterios) {
		respuesta=mundo.consultarRecursos(palabraClave, criterio, criterios);
		remove(busqueda);
		add(resultados=new PanelResultadosBusqueda(this,respuesta));
		
	}
	
	public String darEstadisticas(String id) {
		return mundo.darEstadisticasDeExploracion(id).toString();
		
	}
	
	public Resource[] darRecursosXCategoria(Categoria selectedValue) {
		return mundo.darRecursosXCategoria(selectedValue);
	}
	
	public ComponenteBusqueda darMundo(){
		return mundo;
	}
	
	public void agregarCategoria(String nombre,String descripcion){
		mundo.crearCategoria(nombre, descripcion);
		remove(agregar);
		Categoria[] arreglo=mundo.darArregloCategorias();
		add(categorias= new PanelCategorias(this,arreglo));
	}
	

	public String darRuta(){
		return ruta;
	}

	


	

}
