package uniandes.cupi2.componenteBusqueda.interfaz;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import uniandes.cupi2.componenteBusqueda.mundo.Categoria;
import uniandes.cupi2.componenteBusqueda.webCrawler.Resource;

public class PanelCategorias extends JPanel implements ActionListener{
	
	private JList listaCategorias;
	private JList listaRecursosXCategoria;
	
	
	private ComponenteBusquedaPanel principal;
	
	private DefaultListModel<Categoria> model;
	
	private DefaultListModel<Resource> model1;
	
	private final static String RUTA="./data/imagenes/";

	/**
	 * Create the panel.
	 */
	public PanelCategorias(ComponenteBusquedaPanel ventana,Categoria[] categorias) {
		
		principal=ventana;
		
		setPreferredSize(new Dimension(340, 450));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 108, 340, 80);
		add(scrollPane);
		
		listaCategorias = new JList();
		scrollPane.setViewportView(listaCategorias);
		
		listaCategorias.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				JList list=(JList)evt.getSource();
				if(evt.getClickCount()==2){
					actualizarRecursos(principal.darRecursosXCategoria((Categoria)list.getSelectedValue()));
				}
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 257, 340, 103);
		add(scrollPane_1);
		
		listaRecursosXCategoria = new JList();
		scrollPane_1.setViewportView(listaRecursosXCategoria);
		
		listaRecursosXCategoria.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				JList list=(JList)evt.getSource();
				if(evt.getClickCount()==2){
					//mostrarDialogo((Colegio) list.getSelectedValue());
					Resource recurso=(Resource) list.getSelectedValue();
					principal.mostrarRescurso(recurso.getThingTagged());
				}
				
			}
		});
		
		JLabel lblCategorias = new JLabel(new ImageIcon(RUTA+"categorias1.png"));
		lblCategorias.setBounds(4, 6, 326, 103);
		add(lblCategorias);
		
		JButton btnNuevaCategoria = new JButton("Nueva Categoria");
		ImageIcon image=new ImageIcon(RUTA+"anadir.png");
		btnNuevaCategoria.setIcon(image);
		btnNuevaCategoria.addActionListener(this);
		btnNuevaCategoria.setActionCommand("NUEVA");
		btnNuevaCategoria.setBounds(0, 190, 340, 70);
		add(btnNuevaCategoria);
		
		JButton btnAadir = new JButton("ANADIR");
		ImageIcon image2=new ImageIcon(RUTA+"anadir.png");
		btnAadir.setIcon(image2);
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anadir");
		btnAadir.setBounds(0, 356, 340, 70);
		add(btnAadir);
		
		JButton button = new JButton("<-");
		ImageIcon image3=new ImageIcon(RUTA+"volver.png");
		button.setIcon(image3);
		button.addActionListener(this);
		button.setActionCommand("VOLVER");
		button.setBounds(0, 427, 340, 23);
		add(button);
		
		
		actualizarCategorias(categorias);
		

	}
	
	private void actualizarCategorias(Categoria[] categorias) {
		
		model = new DefaultListModel<Categoria>();
		    for(Categoria s : categorias){
		         model.addElement(s);
		    }    
		    listaCategorias.setModel(model);     
		    listaCategorias.setSelectedIndex(0);
	}
	
	private void actualizarRecursos(Resource[] recursos) {
		
		model1 = new DefaultListModel<Resource>();
		    for(Resource r : recursos){
		         model1.addElement(r);
		    }    
		    listaRecursosXCategoria.setModel(model1);     
		    listaRecursosXCategoria.setSelectedIndex(0);
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
