package uniandes.cupi2.componenteBusqueda.app;

import javax.swing.JPanel;

import uniandes.cupi2.componenteBusqueda.interfaz.ComponenteBusquedaPanel;
import uniandes.cupi2.componenteBusqueda.mundo.ComponenteBusqueda;
import uniandes.cupi2.cupIphone.componentes.IAplicacion;
import uniandes.cupi2.cupIphone.core.ICore;



public class ComponenteBusquedaAplicacion implements IAplicacion {
	
	

	/**
	 * Referencia al core del cupiPhone, para localizar otros componentes y acceder al directorio de datos
	 */
	private ICore core;
	
	
	/**
	 * Panel principal del componente
	 */
	private ComponenteBusquedaPanel panel;
	
	
	/**
	 * Clase principal del mundo del componente
	 */
	private ComponenteBusqueda mundo;
	
	/**
	 * Esta aplicaci�n se implementa como un singleton
	 */
	private static ComponenteBusquedaAplicacion instancia;
	
	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darPanelPrincipal()
	 */
	public JPanel darPanelPrincipal() {
		return panel;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#terminarEjecucion()
	 */
	public void terminarEjecucion() {
		panel.terminar();
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#darInstanciaModelo()
	 */
	public Object darInstanciaModelo() {
		return mundo;
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#cambiarCore(uniandes.cupi2.cupIphone.core.ICore)
	 */
	public void cambiarCore(ICore c) {
		core = c;
		
	}

	/* (non-Javadoc)
	 * @see uniandes.cupi2.cupIphone.componentes.IAplicacion#iniciarEjecucion()
	 */
	public void iniciarEjecucion() {
	    mundo = new ComponenteBusqueda(core);
	    panel = new ComponenteBusquedaPanel( mundo);
	}

	/**
	 * M�todo necesario para interactuar con el core
	 * del tel�fono
	 * @return La instancia de la clase
	 */
	public static IAplicacion darInstancia()
	{
		return instancia!=null? instancia: new ComponenteBusquedaAplicacion();
	}

}
