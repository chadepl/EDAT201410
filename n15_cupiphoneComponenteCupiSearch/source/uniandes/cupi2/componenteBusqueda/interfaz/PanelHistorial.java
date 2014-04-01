package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;

import uniandes.cupi2.componenteBusqueda.webCrawler.Query;



public class PanelHistorial extends JPanel implements ActionListener {
	
	private ComponenteBusquedaPanel principal;
	private Query[] historial;
	
	private DefaultListModel<Query> model;
	private JList listHistorial;
	
	private String ruta;

	/**
	 * Create the panel.
	 */
	public PanelHistorial(ComponenteBusquedaPanel ventana,Query[] nHistorial) {
		principal=ventana;
		historial=nHistorial;
		ruta=principal.darRuta();
		
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 102, 340, 325);
		add(scrollPane);
		
		listHistorial = new JList();
		scrollPane.setViewportView(listHistorial);
		
		JButton btnVolver = new JButton("<-");
		ImageIcon imagen = new ImageIcon(ruta+"volver.png");
		btnVolver.setIcon(imagen);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setBounds(0, 427, 340, 23);
		add(btnVolver);
		
		JLabel lblHistorial = new JLabel(new ImageIcon(ruta+"exploraciones1.png"));
		lblHistorial.setBounds(0, 0, 340, 100);
		add(lblHistorial);

		actualizarLista(nHistorial);
	}
	
	public void actualizarLista(Query[] sitios){ 
	model = new DefaultListModel<Query>();
	    for(Query s : sitios){
	         model.addElement(s);
	    }    
	    listHistorial.setModel(model);     
	    listHistorial.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("volver")){
			principal.volverDesdeHistorial();
		}
		
	}

}
