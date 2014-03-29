package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import uniandes.cupi2.componenteBusqueda.mundo.Categoria;

public class PanelCategorias extends JPanel implements ActionListener{
	
	private JList listaCategorias;
	private JList listaRecursosXCategoria;
	
	
	private ComponenteBusquedaPanel principal;
	
	private DefaultListModel<Categoria> model;

	/**
	 * Create the panel.
	 */
	public PanelCategorias(ComponenteBusquedaPanel ventana,Categoria[] categorias) {
		
		principal=ventana;
		
		setPreferredSize(new Dimension(330, 540));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 64, 269, 176);
		add(scrollPane);
		
		listaCategorias = new JList();
		scrollPane.setViewportView(listaCategorias);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 300, 269, 176);
		add(scrollPane_1);
		
		listaRecursosXCategoria = new JList();
		scrollPane_1.setViewportView(listaRecursosXCategoria);
		
		JLabel lblCategorias = new JLabel("CATEGORIAS");
		lblCategorias.setBounds(32, 36, 116, 16);
		add(lblCategorias);
		
		JLabel lblRecursos = new JLabel("RECURSOS");
		lblRecursos.setBounds(32, 272, 88, 16);
		add(lblRecursos);
		
		JButton btnNuevaCategoria = new JButton("Nueva Categoria");
		btnNuevaCategoria.addActionListener(this);
		btnNuevaCategoria.setActionCommand("NUEVA");
		btnNuevaCategoria.setBounds(86, 241, 147, 29);
		add(btnNuevaCategoria);
		
		JButton btnAadir = new JButton("ANADIR");
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anadir");
		btnAadir.setBounds(116, 478, 117, 29);
		add(btnAadir);
		
		JButton button = new JButton("<-");
		button.addActionListener(this);
		button.setActionCommand("VOLVER");
		button.setBounds(296, 505, 34, 29);
		add(button);
		
		
		actualizar(categorias);
		

	}
	
	private void actualizar(Categoria[] categorias) {
		
		model = new DefaultListModel<Categoria>();
		    for(Categoria s : categorias){
		         model.addElement(s);
		    }    
		    listaCategorias.setModel(model);     
		    listaCategorias.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando=e.getActionCommand();
		
		if(comando.equals("NUEVA")){
			principal.mostrarAgregar();
		}else if(comando.equals("ANADIR")){
			
		}else if(comando.equals("VOLVER")){
			principal.volverDesdeCategorias();
		}
		
	}

}
