package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
	
	private ButtonGroup grupo;
	
	
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
		
		grupo=new ButtonGroup();
		
		textField = new JTextField(" ");
		textField.setBounds(0, 157, 334, 28);
		add(textField);
		textField.setColumns(10);
		
		rdbtnIgual = new JRadioButton("Igual");
		rdbtnIgual.setActionCommand("igual");
		rdbtnIgual.setBounds(51, 197, 68, 23);
		add(rdbtnIgual);
		grupo.add(rdbtnIgual);
		
		rdbtnIncluye = new JRadioButton("Incluye");
		rdbtnIncluye.setActionCommand("contiene");
		rdbtnIncluye.setBounds(114, 197, 77, 23);
		add(rdbtnIncluye);
		grupo.add(rdbtnIncluye);
		
		rdbtnNoIncluye = new JRadioButton("No Incluye");
		rdbtnNoIncluye.setActionCommand("nocontiene");
		rdbtnNoIncluye.setBounds(191, 197, 99, 23);
		add(rdbtnNoIncluye);
		grupo.add(rdbtnNoIncluye);
		
		chckbxImagenes = new JCheckBox("Imagenes");
		chckbxImagenes.setActionCommand("img");
		chckbxImagenes.setBounds(51, 256, 92, 23);
		add(chckbxImagenes);
		
		chckbxDocumentos = new JCheckBox("Texto");
		chckbxDocumentos.setActionCommand("h1");
		chckbxDocumentos.setBounds(180, 256, 112, 23);
		add(chckbxDocumentos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 232, 280, 12);
		add(separator);
		
		btnBuscar = new JButton();
		ImageIcon imagen = new ImageIcon(RUTA+"btnbuscar.png");
		btnBuscar.setIcon(imagen);
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand("buscar");
		btnBuscar.setBounds(0, 291, 334, 81);
		add(btnBuscar);
		
		btnVolver = new JButton();
		ImageIcon imagen1 = new ImageIcon(RUTA+"volver.png");
		btnVolver.setIcon(imagen1);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		btnVolver.setBounds(0, 373, 334, 29);
		add(btnVolver);
		
		labelCriterio = new JLabel(new ImageIcon(RUTA+"palabraclave.png"));
		labelCriterio.setBounds(6, 107, 328, 38);
		add(labelCriterio);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		
		if(comando.equals("buscar")){
			System.out.println(chckbxDocumentos.isSelected()?chckbxDocumentos.getActionCommand():"No hay nada");
			System.out.println(grupo.getSelection().getActionCommand());
			System.out.println(textField.getText());
			
		}else if(comando.equals("volver")){
			
		}
		
	}
}
