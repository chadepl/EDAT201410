package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PanelBienvenida extends JPanel implements ActionListener{

	
	private ComponenteBusquedaPanel principal;
	
	private String ruta;
	
	
	/**
	 * Create the panel.
	 */
	public PanelBienvenida(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		
		ruta=principal.darRuta();
		
		setPreferredSize(new Dimension(320, 450));
		setLayout(null);
		
		JButton btnZonaExploracion = new JButton("Exploracion");
		ImageIcon image=new ImageIcon(ruta+"config.png");
		btnZonaExploracion.setIcon(image);
		btnZonaExploracion.addActionListener(this);
		btnZonaExploracion.setActionCommand("explorar");
		btnZonaExploracion.setBounds(0, 137, 152, 75);
		add(btnZonaExploracion);
		
		JButton btnZonaBusqueda = new JButton("Busqueda");
		ImageIcon image1=new ImageIcon(ruta+"busqueda.png");
		btnZonaBusqueda.setIcon(image1);
		btnZonaBusqueda.addActionListener(this);
		btnZonaBusqueda.setActionCommand("buscar");
		btnZonaBusqueda.setBounds(155, 137, 169, 75);
		add(btnZonaBusqueda);
		
		JButton btnAyuda = new JButton("Ayuda");
		ImageIcon image2=new ImageIcon(ruta+"ayuda.png");
		btnAyuda.setIcon(image2);
		btnAyuda.setPreferredSize(new Dimension(170, 75));
		btnAyuda.addActionListener(this);
		btnAyuda.setActionCommand("ayuda");
		btnAyuda.setBounds(-2, 369, 161, 75);
		add(btnAyuda);
		
		JButton btnAcercaDe = new JButton("Acerca De");
		ImageIcon imagen3=new ImageIcon(ruta+"acercade.png");
		btnAcercaDe.setIcon(imagen3);
		btnAcercaDe.addActionListener(this);
		btnAcercaDe.setActionCommand("acerca");
		btnAcercaDe.setBounds(161, 369, 169, 75);
		add(btnAcercaDe);
		
		JButton btnEstadisticasExploracion = new JButton("Exploraciones");
		ImageIcon image4=new ImageIcon(ruta+"exploraciones.png");
		btnEstadisticasExploracion.setIcon(image4);
		btnEstadisticasExploracion.addActionListener(this);
		btnEstadisticasExploracion.setActionCommand("estadisticas");
		btnEstadisticasExploracion.setBounds(0, 289, 324, 75);
		add(btnEstadisticasExploracion);
		
		JButton btnCategorias = new JButton("Categorias");
		ImageIcon image5=new ImageIcon(ruta+"categorias.png");
		btnCategorias.setIcon(image5);
		btnCategorias.addActionListener(this);
		btnCategorias.setActionCommand("categorias");
		btnCategorias.setBounds(0, 213, 324, 75);
		add(btnCategorias);
		
		JLabel lblCupisearch = new JLabel(new ImageIcon(ruta+"cupiphone.png"));
		lblCupisearch.setBounds(0, 6, 324, 134);
		add(lblCupisearch);

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
		}
		
	}
}
