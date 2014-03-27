package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelResultadosBusqueda extends JPanel {
	private JComboBox comboUrls;
	private JList listaResultados;

	/**
	 * Create the panel.
	 */
	public PanelResultadosBusqueda() {
		setPreferredSize(new Dimension(330, 540));
		setLayout(null);
		
		JLabel lblResultadosBusqueda = new JLabel("RESULTADOS BUSQUEDA");
		lblResultadosBusqueda.setBounds(69, 56, 211, 16);
		add(lblResultadosBusqueda);
		
		comboUrls = new JComboBox();
		comboUrls.setToolTipText("");
		comboUrls.setBounds(21, 117, 281, 27);
		add(comboUrls);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 190, 281, 262);
		add(scrollPane);
		
		listaResultados = new JList();
		scrollPane.setViewportView(listaResultados);
		
		JButton btnVolver = new JButton("<-");
		btnVolver.setBounds(297, 505, 27, 29);
		add(btnVolver);

	}
}
