package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;

import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;



public class PanelRecursos extends JPanel implements ActionListener{
	
	private ComponenteBusquedaPanel principal;
	private Resource[] recursos;
	private JList listaRecursos;
	
	private DefaultListModel<Resource> model;

	/**
	 * Create the panel.
	 */
	public PanelRecursos(ComponenteBusquedaPanel ventana,Resource[] nRecursos) {
		
		principal=ventana;
		recursos=nRecursos;
		
		setPreferredSize(new Dimension(330, 540));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 287, 440);
		add(scrollPane);
		
		listaRecursos = new JList();
		scrollPane.setViewportView(listaRecursos);
		
		JButton btnVolver = new JButton("<-");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setBounds(144, 475, 39, 29);
		add(btnVolver);
		
		actualizar(recursos);

	}

	private void actualizar(Resource[] recursos) {
	
			model = new DefaultListModel<Resource>();
			    for(Resource s : recursos){
			         model.addElement(s);
			    }    
			    listaRecursos.setModel(model);     
			    listaRecursos.setSelectedIndex(0);
		}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		
		if(comando.equals("volver")){
			principal.volverDesdeRecursos();
		}
		
	}

}
