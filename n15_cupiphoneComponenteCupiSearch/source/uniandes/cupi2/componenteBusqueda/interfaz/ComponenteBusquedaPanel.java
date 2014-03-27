package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.componenteBusqueda.mundo.ComponenteBusqueda;
import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;

import java.awt.Dimension;
import java.util.Iterator;

public class ComponenteBusquedaPanel extends JPanel {

	
	
//	public static void main(String[] args) {
//		JFrame frim=new JFrame();
//		frim.setSize(new Dimension(330,540));
//		ComponenteBusquedaPanel f=new ComponenteBusquedaPanel();
//		frim.getContentPane().add(f);
//		frim.setVisible(true);
//	}
	
	private   ComponenteBusqueda mundo;
	
	private PanelBienvenida bienvenida;
	private PanelExploracion exploracion;
	private PanelBusqueda busqueda;
	private PanelResultadosBusqueda resultados;
	private PanelHistorial historial;
	private PanelCategorias categorias;
	private PanelRecursos recursos;
	
	
	
	
	/**
	 * Create the panel.
	 */
	public ComponenteBusquedaPanel(ComponenteBusqueda ventana) {
		mundo=ventana;
		//mundo=new ComponenteBusqueda();
		
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
		add(categorias= new PanelCategorias(this));
		
	}
	
	public void mostrarRecursos() {
		remove(bienvenida);
		//TODO
		add(recursos= new PanelRecursos(this,null));
	}
	
	
	private void mostrarPanelRescursos() {
		remove(exploracion);
		Resource[] arreglo=mundo.darArregloIndice();
		add(recursos= new PanelRecursos(this,arreglo));
	}
	
	
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
	
	public void darHistorial() {
		remove(bienvenida);
		add(historial = new PanelHistorial(this,mundo.darHistorialExploraciones2()));
		
	}

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

	

	public String darEstadisticas(String id) {
		return mundo.darEstadisticasDeExploracion(id).toString();
		
	}

	
	public ComponenteBusqueda darMundo(){
		return mundo;
	}

	

	

	


	

}
