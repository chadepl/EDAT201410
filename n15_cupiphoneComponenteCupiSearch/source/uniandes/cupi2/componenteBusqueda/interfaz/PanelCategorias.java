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
	
	private String ruta;

	/**
	 * Create the panel.
	 */
	public PanelCategorias(ComponenteBusquedaPanel ventana,Categoria[] categorias) {
		
		principal=ventana;
		ruta=principal.darRuta();
		setPreferredSize(new Dimension(320, 450));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 108, 310, 80);
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
		scrollPane_1.setBounds(4, 258, 310, 103);
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
		
		JLabel lblCategorias = new JLabel(new ImageIcon(ruta+"categorias1.png"));
		lblCategorias.setBounds(4, 6, 310, 103);
		add(lblCategorias);
		
		JButton btnNuevaCategoria = new JButton("Nueva Categoria");
		ImageIcon image=new ImageIcon(ruta+"anadir.png");
		btnNuevaCategoria.setIcon(image);
		btnNuevaCategoria.addActionListener(this);
		btnNuevaCategoria.setActionCommand("NUEVA");
		btnNuevaCategoria.setBounds(4, 186, 310, 70);
		add(btnNuevaCategoria);
		
		JButton btnAadir = new JButton("ANADIR");
		ImageIcon image2=new ImageIcon(ruta+"anadir.png");
		btnAadir.setIcon(image2);
		btnAadir.addActionListener(this);
		btnAadir.setActionCommand("anadir");
		btnAadir.setBounds(4, 357, 310, 70);
		add(btnAadir);
		
		JButton button = new JButton("<-");
		ImageIcon image3=new ImageIcon(ruta+"volver.png");
		button.setIcon(image3);
		button.addActionListener(this);
		button.setActionCommand("VOLVER");
		button.setBounds(4, 427, 314, 23);
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
