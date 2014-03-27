package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JCheckBox chckbxLinks;
	private JCheckBox chckbxOtros;
	private JRadioButton rdbtnIgual;
	private JRadioButton rdbtnIncluye;
	private JRadioButton rdbtnNoIncluye;
	
	private ComponenteBusquedaPanel principal;

	/**
	 * Create the panel.
	 */
	public PanelBusqueda(ComponenteBusquedaPanel ventana) {
		principal=ventana;
		setPreferredSize(new Dimension(330, 540));
		setLayout(null);
		
		JLabel lblZonaBusqueda = new JLabel("ZONA BUSQUEDA");
		lblZonaBusqueda.setBounds(51, 72, 167, 16);
		add(lblZonaBusqueda);
		
		textField = new JTextField();
		textField.setBounds(51, 140, 225, 28);
		add(textField);
		textField.setColumns(10);
		
		rdbtnIgual = new JRadioButton("Igual");
		rdbtnIgual.setBounds(45, 225, 68, 23);
		add(rdbtnIgual);
		
		rdbtnIncluye = new JRadioButton("Incluye");
		rdbtnIncluye.setBounds(114, 225, 77, 23);
		add(rdbtnIncluye);
		
		rdbtnNoIncluye = new JRadioButton("No Incluye");
		rdbtnNoIncluye.setBounds(189, 225, 99, 23);
		add(rdbtnNoIncluye);
		
		chckbxImagenes = new JCheckBox("Imagenes");
		chckbxImagenes.setBounds(51, 329, 92, 23);
		add(chckbxImagenes);
		
		chckbxLinks = new JCheckBox("Links");
		chckbxLinks.setBounds(162, 329, 128, 23);
		add(chckbxLinks);
		
		chckbxDocumentos = new JCheckBox("Documentos");
		chckbxDocumentos.setBounds(49, 364, 112, 23);
		add(chckbxDocumentos);
		
		chckbxOtros = new JCheckBox("Otros");
		chckbxOtros.setBounds(162, 364, 77, 23);
		add(chckbxOtros);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 292, 280, 12);
		add(separator);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(114, 433, 117, 29);
		add(btnBuscar);
		
		btnVolver = new JButton("<-");
		btnVolver.setBounds(285, 505, 39, 29);
		add(btnVolver);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(45);
		progressBar.setBounds(15, 505, 146, 20);
		add(progressBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
