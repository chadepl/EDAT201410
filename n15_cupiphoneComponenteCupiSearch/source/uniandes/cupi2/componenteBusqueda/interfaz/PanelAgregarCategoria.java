package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class PanelAgregarCategoria extends JPanel implements ActionListener {
	
	private JTextField textField;
	private ComponenteBusquedaPanel principal;
	private JTextArea textArea;

	private String ruta;
	
	/**
	 * Create the panel.
	 */
	public PanelAgregarCategoria(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		ruta=principal.darRuta();
		setPreferredSize(new Dimension(320, 450));
		setLayout(null);
		
		JLabel lblAgregarCategoria = new JLabel(new ImageIcon(ruta+"categorias1.png"));
		lblAgregarCategoria.setBounds(6, 6, 308, 107);
		add(lblAgregarCategoria);
		
		textField = new JTextField();
		textField.setBounds(0, 164, 320, 46);
		add(textField);
		textField.setColumns(10);
		
		JButton btnAgregarCategoria = new JButton("Agregar Categoria");
		ImageIcon image=new ImageIcon(ruta+"anadir.png");
		btnAgregarCategoria.setIcon(image);
		btnAgregarCategoria.addActionListener(this);
		btnAgregarCategoria.setActionCommand("agregar");
		btnAgregarCategoria.setBounds(6, 371, 308, 73);
		add(btnAgregarCategoria);
		
		JLabel lblDescripcion = new JLabel(new ImageIcon(ruta+"descripcion.png"));
		lblDescripcion.setBounds(6, 209, 308, 54);
		add(lblDescripcion);
		
		JLabel lblNombre = new JLabel(new ImageIcon(ruta+"Nombre.png"));
		lblNombre.setBounds(6, 111, 308, 54);
		add(lblNombre);
		
		textArea = new JTextArea();
		textArea.setBounds(6, 264, 308, 107);
		add(textArea);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("agregar"))
		{
			String nombre=textField.getText();
			String descripcion=textArea.getText();
			principal.agregarCategoria(nombre, descripcion);
		}
	}
}
