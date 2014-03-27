package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class PanelExploracion extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnDudas;
	private JButton btnVolver;
	private JButton btnIniciarExploracion;
	private JList listaSitiosFuente;
	private JButton btnAnadirSitio;
	
	private ComponenteBusquedaPanel principal;
	
	private DefaultListModel<String> model;

	/**
	 * Create the panel.
	 */
	public PanelExploracion(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JLabel lblZonaExploracion = new JLabel("ZONA EXPLORACION");
		lblZonaExploracion.setBounds(38, 50, 169, 16);
		add(lblZonaExploracion);
		
		textField = new JTextField("");
		textField.setBounds(38, 78, 254, 28);
		add(textField);
		textField.setColumns(10);
		
		btnAnadirSitio = new JButton("A\u00F1adir a Sitios Fuente");
		btnAnadirSitio.addActionListener(this);
		btnAnadirSitio.setActionCommand("ANADIR");
		btnAnadirSitio.setBounds(73, 131, 181, 29);
		add(btnAnadirSitio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 172, 254, 124);
		add(scrollPane);
		
		listaSitiosFuente = new JList();
		scrollPane.setViewportView(listaSitiosFuente);
		
		btnIniciarExploracion = new JButton("Iniciar Exploracion");
		btnIniciarExploracion.addActionListener(this);
		btnIniciarExploracion.setActionCommand("INICIAR");
		btnIniciarExploracion.setBounds(93, 319, 161, 29);
		add(btnIniciarExploracion);
		
		btnVolver = new JButton("<-");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(277, 369, 37, 29);
		add(btnVolver);
		
		btnDudas = new JButton("?");
		btnDudas.setBounds(17, 369, 31, 29);
		add(btnDudas);

	}
	
	public void actualizarLista(String[] sitios){ 
	model = new DefaultListModel<String>();
	    for(String s : sitios){
	         model.addElement(s);
	    }    
	    listaSitiosFuente.setModel(model);     
	    listaSitiosFuente.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("ANADIR")){
			principal.anadirSitio(textField.getText());
			actualizarLista(principal.darMundo().darArregloSitios());
		}else if(comando.equals("INICIAR")){
			principal.iniciarExploracion(1);
		}else if(comando.equals("VOLVER")){
			principal.volverDesdeExploracion();
		}
		
	}
}
