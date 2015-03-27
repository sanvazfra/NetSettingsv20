package com.netsettings.application.view;

import java.awt.Color;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.netsettings.application.controller.CommonController;
import com.netsettings.application.controller.LoggerUtil;
import com.netsettings.application.controller.MenuHandler;
import com.netsettings.application.view.panel.ConfigRapidaPanel;
import com.netsettings.application.view.panel.EnableItemsPanel;
/**
 * 
 * @author Francisco Santos Vazquez
 * @since 14/02/2015
 * @version 2.0
 * 
 */
public class MainWindowImp extends JFrame implements MainWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//getLogger Class 
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private String propFileName = "properties.mainw";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private String sDirectorioTrabajo;
	private CommonController commonHand = new CommonController();
	//Objetos graficos
	private JTabbedPane jtPane = new JTabbedPane();
	private ConfigRapidaPanel panelConfigRap = new ConfigRapidaPanel(this);
	private EnableItemsPanel panelEnabledItems = new EnableItemsPanel();
	private JMenuBar barraHerramientas = new JMenuBar();
	private JMenu menuArchivo;
	private JMenuItem itemNuevoPerifl,	itemActualizar, itemSalirApp;
	private MenuHandler menuHandler = new MenuHandler(this);
		
	//color de fondo de pestañas
	private Color colorFondoTabbedPane = new Color(Integer.parseInt(resources.getString("color.r")),
			Integer.parseInt(resources.getString("color.g")), Integer.parseInt(resources.getString("color.b")));
	
	public MainWindowImp(){
		setTitle(resources.getString("tag.mainwindow.title"));
		setSize(420,400);
		setLocation(250,250);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setsDirectorioTrabajo(System.getProperty(
					resources.getString("config.currentlocation")));
		cargaItemsConfigRapida();
		cargaItemsHabilitarPerfil();
		jtPane.addTab(resources.getString("tag.mainwindow.tab.habilitar.title"),panelEnabledItems);
		jtPane.addTab(resources.getString("tag.mainwindow.tab.configrapida.title"),panelConfigRap);
		creaMenuBar();
		creaMenuContextual();
		setJMenuBar(barraHerramientas);
		panelConfigRap.setBackground(colorFondoTabbedPane);
		UIManager.put("TabbedPane.contentAreaColor", colorFondoTabbedPane);
		getContentPane().setBackground(colorFondoTabbedPane);
		getContentPane().add(jtPane);
		logger.infoMessage("*****************Pantalla MainWindow completa *********************");
	}
	
	public void llenarTabla() {
		// TODO Auto-generated method stub
		
	}

	public void cargaItemsConfigRapida() {
		try{
			panelConfigRap.cargarElementos();
			logger.infoMessage("*****************Modulo configuracion rapida inicializada*********************");
		}catch(Exception e){
			logger.severeError("Error al cargar los elementos de configuracion rapida: " 
						+ e.toString() , e);
			exitApp(1);
		}
	}

	public void cargaItemsHabilitarPerfil() {
		try{
			panelEnabledItems.cargarElementos();
			logger.infoMessage("*****************Modulo Habilitar elementos inicializada*********************");
		}catch(Exception e){
			logger.severeError("Error al cargar el panel para activar perfiles: " + 
						e.toString(), e);
			exitApp(1);
		}
	}

	public void creaMenuBar() {
		if(barraHerramientas != null){
			try{
				//inicializamos los elementos
				menuArchivo = new JMenu(resources.getString("tag.mainwindow.habilitar.jmenu.title"));
				itemNuevoPerifl = new JMenuItem(resources.getString("tag.mainwindow.habilitar.jmenuitem.new.title"));
				itemNuevoPerifl.setActionCommand(resources.getString("command.mostrarnuevoperfil"));
				itemNuevoPerifl.addActionListener(menuHandler);
				itemActualizar = new JMenuItem(resources.getString("tag.mainwindow.habilitar.jmenuitem.actualizar.title"));
				itemSalirApp = new JMenuItem(resources.getString("tag.mainwindow.habilitar.jmenuitem.salir.title"));
				//agregamos los elemento inicializados
				menuArchivo.add(itemNuevoPerifl);
				menuArchivo.add(itemActualizar);
				menuArchivo.add(itemSalirApp);
				barraHerramientas.add(menuArchivo);
				logger.infoMessage("*****************Barra de herramientas inicializada*********************");
			}catch(NullPointerException ex){
				logger.severeError("No se econtro el archivo " +	
								ex.toString(), ex);
				exitApp(1);
			}catch(MissingResourceException ex){
				logger.severeError("No se encontro el recurso " +	
						ex.toString(), ex);
				exitApp(1);
			}catch(ClassCastException ex){
				logger.severeError("El recurso no es string " +	
						ex.toString(), ex);
				exitApp(1);
			}
			catch(Exception ex){
				logger.severeError("Error inesperado " +	
						ex.toString(), ex);
				exitApp(1);
			}
		}	
	}

	public void creaMenuContextual() {
		if(panelEnabledItems != null){
			try {
				panelEnabledItems.createmenuContextual();
				logger.infoMessage("*****************Menu contextual inicializado*********************");
			} catch(NullPointerException ex){
				logger.severeError("No se econtro el archivo " +	
						ex.toString(), ex);
				exitApp(1);
			}catch(MissingResourceException ex){
				logger.severeError("No se encontro el recurso " +	
						ex.toString(), ex);
				exitApp(1);
			}catch(ClassCastException ex){
				logger.severeError("El recurso no es string " +	
						ex.toString(), ex);
				exitApp(1);
			}
			catch(Exception ex){
				logger.severeError("Error inesperado " +	
						ex.toString(), ex);
				exitApp(1);
			}
		}
	}

	/**
	 * @return the sDirectorioTrabajo
	 */
	public String getsDirectorioTrabajo() {
		return sDirectorioTrabajo;
	}
	/**
	 * @param sDirectorioTrabajo the sDirectorioTrabajo to set
	 */
	public void setsDirectorioTrabajo(String sDirectorioTrabajo) {
		this.sDirectorioTrabajo = sDirectorioTrabajo;
	}

	public void mostrarNewProfile() {
		NewProfile newProfile = NewProfileImp.getIntance();
		NewProfileImp newProfileImp = (NewProfileImp)newProfile;
		newProfileImp.mostrarVentana(true);
	}
	
	@Override
	public void exitApp(int flagStatus) {
		switch (flagStatus) {
		case 0:
				commonHand.salirApp(flagStatus);
			break;
		case 1:
				JOptionPane.showMessageDialog(null, resources.getString("msg.exit.error"),"Error", JOptionPane.ERROR_MESSAGE);
				logger.severeError("La aplicacion inicio con errores y finalizo el proceso!!!",null);
				commonHand.salirApp(flagStatus);
			break;
		}
	}

	@Override
	public void exitVentana(int flagStatus) {
		switch (flagStatus) {
		case 0:
			commonHand.salirWindow(this);
		break;
		case 1:
			logger.severeError("La ventana " + this.getClass().getCanonicalName() + " inicio con errores y finalizo el proceso!!!",null);
			commonHand.salirWindow(this);
		}
	}
	
	/**
	 * Flag ayuda saber si se abrira la ventana de la clase o una secundaria
	 */
	@Override
	public void mostrarVentana(boolean flag) {
		if(flag){
			this.setVisible(true);
		}else{
			mostrarNewProfile();
		}
	}

}
