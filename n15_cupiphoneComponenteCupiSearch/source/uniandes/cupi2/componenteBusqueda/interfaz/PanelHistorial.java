package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
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

	/**
	 * Create the panel.
	 */
	public PanelHistorial(ComponenteBusquedaPanel ventana,Query[] nHistorial) {
		principal=ventana;
		historial=nHistorial;
		
		
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 75, 328, 222);
		add(scrollPane);
		
		listHistorial = new JList();
		scrollPane.setViewportView(listHistorial);
		
		JButton btnVolver = new JButton("<-");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setBounds(298, 378, 36, 29);
		add(btnVolver);
		
		JLabel lblHistorial = new JLabel("HISTORIAL");
		lblHistorial.setBounds(119, 35, 94, 16);
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
