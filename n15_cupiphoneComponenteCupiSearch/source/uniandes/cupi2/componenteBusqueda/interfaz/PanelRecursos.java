package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;

import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;

import javax.swing.JLabel;



public class PanelRecursos extends JPanel implements ActionListener{
	
	private ComponenteBusquedaPanel principal;
	private Resource[] recursos;
	private JList listaRecursos;
	private final static String RUTA="./data/imagenes/";
	
	private DefaultListModel<Resource> model;

	/**
	 * Create the panel.
	 */
	public PanelRecursos(ComponenteBusquedaPanel ventana,Resource[] nRecursos) {
		setPreferredSize(new Dimension(340, 450));
		setMinimumSize(new Dimension(340, 450));
		
		principal=ventana;
		recursos=nRecursos;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 100, 334, 317);
		add(scrollPane);
		
		listaRecursos = new JList();
		scrollPane.setViewportView(listaRecursos);
		
		JButton btnVolver = new JButton();
		ImageIcon imagen=new ImageIcon(RUTA+"volver.png");
		btnVolver.setIcon(imagen);
		btnVolver.setPreferredSize(new Dimension(350, 30));
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setBounds(10, 414, 324, 18);
		add(btnVolver);
		
		JLabel label = new JLabel(new ImageIcon(RUTA+"recursos.png"));
		label.setPreferredSize(new Dimension(350, 100));
		label.setBounds(0, 6, 334, 94);
		add(label);
		
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
