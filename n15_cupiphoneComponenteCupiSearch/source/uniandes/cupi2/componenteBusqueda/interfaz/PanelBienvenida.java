package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PanelBienvenida extends JPanel implements ActionListener{

	
	private ComponenteBusquedaPanel principal;
	
	/**
	 * Create the panel.
	 */
	public PanelBienvenida(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JLabel lblBienvenidoA = new JLabel("BIENVENIDO A...");
		lblBienvenidoA.setBounds(45, 19, 138, 16);
		add(lblBienvenidoA);
		
		JLabel lblCupisearch = new JLabel("CUPISEARCH");
		lblCupisearch.setBounds(150, 47, 124, 16);
		add(lblCupisearch);
		
		JButton btnZonaExploracion = new JButton("Zona Exploracion");
		btnZonaExploracion.addActionListener(this);
		btnZonaExploracion.setActionCommand("explorar");
		btnZonaExploracion.setBounds(83, 75, 163, 29);
		add(btnZonaExploracion);
		
		JButton btnZonaBusqueda = new JButton("Zona Busqueda");
		btnZonaBusqueda.addActionListener(this);
		btnZonaBusqueda.setActionCommand("buscar");
		btnZonaBusqueda.setBounds(83, 116, 163, 29);
		add(btnZonaBusqueda);
		
		JButton btnHistorialDeExploraciones = new JButton("Historial de Exploraciones");
		btnHistorialDeExploraciones.addActionListener(this);
		btnHistorialDeExploraciones.setActionCommand("historial");
		btnHistorialDeExploraciones.setBounds(74, 198, 200, 29);
		add(btnHistorialDeExploraciones);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(this);
		btnAyuda.setActionCommand("ayuda");
		btnAyuda.setBounds(108, 239, 117, 29);
		add(btnAyuda);
		
		JButton btnAcercaDe = new JButton("Acerca De");
		btnAcercaDe.addActionListener(this);
		btnAcercaDe.setActionCommand("acerca");
		btnAcercaDe.setBounds(108, 280, 117, 29);
		add(btnAcercaDe);
		
		JButton btnEstadisticasExploracion = new JButton("Estadisticas Exploracion");
		btnEstadisticasExploracion.addActionListener(this);
		btnEstadisticasExploracion.setActionCommand("estadisticas");
		btnEstadisticasExploracion.setBounds(58, 321, 216, 29);
		add(btnEstadisticasExploracion);
		
		JButton btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(this);
		btnCategorias.setActionCommand("categorias");
		btnCategorias.setBounds(108, 157, 117, 29);
		add(btnCategorias);
		
		JButton btnRecursos = new JButton("Recursos");
		btnRecursos.addActionListener(this);
		btnRecursos.setActionCommand("recursos");
		btnRecursos.setBounds(108, 362, 117, 29);
		add(btnRecursos);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("explorar")){
			principal.mostrarExploracion();
		}else if(comando.equals("buscar")){
			principal.mostrarBusqueda();
		}else if(comando.equals("historial")){
			principal.darHistorial();
		}else if(comando.equals("ayuda")){
			JOptionPane.showMessageDialog(this, "Ayuda");
		}else if(comando.equals("acerca")){
			JOptionPane.showMessageDialog(this, "Acerca De");
		}else if(comando.equals("estadisticas")){
			principal.darHistorial();
		}else if(comando.equals("categorias")){
			principal.mostrarCategorias();
		}else if(comando.equals("recursos")){
			principal.mostrarRecursos();
		}
		
	}
}
