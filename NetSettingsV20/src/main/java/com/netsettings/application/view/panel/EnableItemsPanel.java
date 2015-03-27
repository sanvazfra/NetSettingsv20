package com.netsettings.application.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import com.netsettings.application.model.DataModel;

public class EnableItemsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpringLayout sprLConfiJustEnabled = new SpringLayout();
	private Object[][] data ={
			{"Casa","10/10/2014"},
			{"Empresa","12/09/2014"}
			}; 
	private String[] columnNames = {"Perfil", "Fecha de creacion"}; 
	private DataModel dtm;
	private String propFileName = "properties.mainw";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private Color colorFondoTabbedPane = new Color(Integer.parseInt(resources.getString("color.r")),
			Integer.parseInt(resources.getString("color.g")), Integer.parseInt(resources.getString("color.b")));
	//elementos graficos 
	private JTable table;
	private JPopupMenu popMenu;
	private JMenuItem itemEliminar;
	private JMenuItem itemActualizar;
	
	public EnableItemsPanel(){
		super();
	}
	
	public void cargarElementos() throws Exception{
		this.setLayout(sprLConfiJustEnabled);
		
		dtm= new DataModel(data,columnNames);
		table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(408, 290));
					
		JScrollPane scrollPane = new JScrollPane(table);
		sprLConfiJustEnabled.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		sprLConfiJustEnabled.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, this);
		
		scrollPane.getViewport().setBackground(colorFondoTabbedPane);
		this.add(scrollPane);
	}
	public void createmenuContextual() throws Exception,NullPointerException,MissingResourceException,ClassCastException{
			if(table != null){
				//inicializamos los elementos
				popMenu = new JPopupMenu();
				itemActualizar = new JMenuItem(resources.getString("tag.mainwindow.habilitar.jmenuitem.actualizar.title"));
				itemEliminar = new JMenuItem(resources.getString("tag.mainwindow.habilitar.jmenuitem.eliminar.title"));
				//agregamos los elementos
				popMenu.add(itemActualizar);
				popMenu.add(itemEliminar);
			}
		}
}
