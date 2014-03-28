package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarCategoria extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private ComponenteBusquedaPanel principal;

	/**
	 * Create the panel.
	 */
	public PanelAgregarCategoria(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JLabel lblAgregarCategoria = new JLabel("AGREGAR CATEGORIA");
		lblAgregarCategoria.setBounds(23, 42, 176, 16);
		add(lblAgregarCategoria);
		
		textField = new JTextField();
		textField.setBounds(23, 121, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(23, 206, 294, 141);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAgregarCategoria = new JButton("Agregar Categoria");
		btnAgregarCategoria.addActionListener(this);
		btnAgregarCategoria.setActionCommand("agregar");
		btnAgregarCategoria.setBounds(100, 379, 143, 29);
		add(btnAgregarCategoria);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(23, 173, 115, 16);
		add(lblDescripcion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 93, 61, 16);
		add(lblNombre);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("agregar"))
		{
			
		}
	}
}
