package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class PanelBusqueda extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JCheckBox chckbxImagenes;
	private JCheckBox chckbxDocumentos;
	private JRadioButton rdbtnIgual;
	private JRadioButton rdbtnIncluye;
	private JRadioButton rdbtnNoIncluye;
	private final static String RUTA="./data/imagenes/";
	
	private ComponenteBusquedaPanel principal;
	private JLabel labelCriterio;

	/**
	 * Create the panel.
	 */
	public PanelBusqueda(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JLabel lblZonaBusqueda = new JLabel(new ImageIcon(RUTA+"buscar.png"));
		lblZonaBusqueda.setBounds(0, 6, 334, 108);
		add(lblZonaBusqueda);
		
		textField = new JTextField();
		textField.setBounds(0, 157, 334, 28);
		add(textField);
		textField.setColumns(10);
		
		rdbtnIgual = new JRadioButton("Igual");
		rdbtnIgual.setBounds(51, 197, 68, 23);
		add(rdbtnIgual);
		
		rdbtnIncluye = new JRadioButton("Incluye");
		rdbtnIncluye.setBounds(114, 197, 77, 23);
		add(rdbtnIncluye);
		
		rdbtnNoIncluye = new JRadioButton("No Incluye");
		rdbtnNoIncluye.setBounds(191, 197, 99, 23);
		add(rdbtnNoIncluye);
		
		chckbxImagenes = new JCheckBox("Imagenes");
		chckbxImagenes.setBounds(51, 256, 92, 23);
		add(chckbxImagenes);
		
		chckbxDocumentos = new JCheckBox("Texto");
		chckbxDocumentos.setBounds(180, 256, 112, 23);
		add(chckbxDocumentos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 232, 280, 12);
		add(separator);
		
		btnBuscar = new JButton();
		ImageIcon imagen = new ImageIcon(RUTA+"btnbuscar.png");
		btnBuscar.setIcon(imagen);
		btnBuscar.setBounds(0, 291, 334, 81);
		add(btnBuscar);
		
		btnVolver = new JButton();
		ImageIcon imagen1 = new ImageIcon(RUTA+"volver.png");
		btnVolver.setIcon(imagen1);
		btnVolver.setBounds(0, 373, 334, 29);
		add(btnVolver);
		
		labelCriterio = new JLabel(new ImageIcon(RUTA+"palabraclave.png"));
		labelCriterio.setBounds(6, 107, 328, 38);
		add(labelCriterio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
