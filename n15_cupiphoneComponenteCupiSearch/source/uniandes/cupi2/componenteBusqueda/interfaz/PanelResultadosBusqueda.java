package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;

public class PanelResultadosBusqueda extends JPanel implements ActionListener {
	
	private Resource[] recursos;
	private JList listaRecursos;
	
	private DefaultListModel<Resource> model;
	
	private ComponenteBusquedaPanel principal;
	
	private String ruta;
	

	/**
	 * Create the panel.
	 */
	public PanelResultadosBusqueda(ComponenteBusquedaPanel ventana,Resource[] nRecursos) {
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		principal=ventana;
		ruta=principal.darRuta();
		recursos=nRecursos;
		
		JLabel lblResultadosBusqueda = new JLabel("RESULTADOS BUSQUEDA");
		lblResultadosBusqueda.setIcon(new ImageIcon(ruta+"resultados.png"));
		lblResultadosBusqueda.setBounds(6, 6, 318, 99);
		add(lblResultadosBusqueda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 104, 340, 311);
		add(scrollPane);
		
		listaRecursos = new JList();
		scrollPane.setViewportView(listaRecursos);
		
		listaRecursos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				JList list=(JList)evt.getSource();
				if(evt.getClickCount()==2){
					Resource recurso=(Resource) list.getSelectedValue();
					principal.mostrarRescurso(recurso.getThingTagged());
				}
				
			}
		});
		
		JButton btnVolver = new JButton("<-");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setIcon(new ImageIcon(ruta+"volver.png"));
		btnVolver.setBounds(0, 415, 340, 29);
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
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("volver")){
			principal.volverDesdeResultados();
		}
		
	}
}
