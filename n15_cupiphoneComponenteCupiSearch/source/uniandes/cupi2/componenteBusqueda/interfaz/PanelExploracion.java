package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class PanelExploracion extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnVolver;
	private JButton btnIniciarExploracion;
	private JList listaSitiosFuente;
	private JButton btnAnadirSitio;
	
	private String ruta;
	
	private ComponenteBusquedaPanel principal;
	
	private DefaultListModel<String> model;
	private JTextField txtProfundidad;

	//Color usado: 75C048
	
	/**
	 * Create the panel.
	 */
	public PanelExploracion(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		ruta=principal.darRuta();
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JLabel lblZonaExploracion = new JLabel(new ImageIcon(ruta+"explorar.png"));
		lblZonaExploracion.setBounds(0, 6, 334, 95);
		add(lblZonaExploracion);
		
		textField = new JTextField("http://");
		textField.setBounds(0, 102, 340, 28);
		add(textField);
		textField.setColumns(10);
		
		btnAnadirSitio = new JButton("");
		ImageIcon imagen=new ImageIcon(ruta+"anadir.png");
		btnAnadirSitio.setIcon(imagen);
		btnAnadirSitio.addActionListener(this);
		btnAnadirSitio.setActionCommand("ANADIR");
		btnAnadirSitio.setBounds(0, 131, 334, 70);
		add(btnAnadirSitio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 199, 334, 151);
		add(scrollPane);
		
		listaSitiosFuente = new JList();
		scrollPane.setViewportView(listaSitiosFuente);
		
		btnIniciarExploracion = new JButton("");
		ImageIcon imagen1=new ImageIcon(ruta+"iniciar.png");
		btnIniciarExploracion.setIcon(imagen1);
		btnIniciarExploracion.addActionListener(this);
		btnIniciarExploracion.setActionCommand("INICIAR");
		btnIniciarExploracion.setBounds(0, 351, 287, 70);
		add(btnIniciarExploracion);
		
		btnVolver = new JButton("");
		ImageIcon imagen2=new ImageIcon(ruta+"volver.png");
		btnVolver.setIcon(imagen2);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(0, 421, 334, 23);
		add(btnVolver);
		
		txtProfundidad = new JTextField();
		txtProfundidad.setBounds(286, 350, 48, 70);
		add(txtProfundidad);
		txtProfundidad.setColumns(10);

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
			textField.setText("http://");
		}else if(comando.equals("INICIAR")){
			int profundidad=Integer.parseInt(txtProfundidad.getText());
			principal.iniciarExploracion(profundidad);
		}else if(comando.equals("VOLVER")){
			principal.volverDesdeExploracion();
		}
		
	}
}
