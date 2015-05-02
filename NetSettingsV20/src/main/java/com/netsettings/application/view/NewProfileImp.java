package com.netsettings.application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.netsettings.application.controller.CommonController;
import com.netsettings.application.controller.LoggerUtil;
import com.netsettings.application.controller.ThreadOp;
import com.netsettings.application.model.Interfaz;
import com.netsettings.application.model.Red;
import com.netsettings.application.view.panel.ConfigIPpanel;
import com.netsettings.application.view.panel.ConfigProxyPanel;

public class NewProfileImp extends JFrame implements NewProfile{
	
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private static  NewProfileImp instanceNewProfil = null;
	private String propFileName = "properties.newp";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private CommonController commonHand = new CommonController();
	private Color colorFondoTabbedPane = new Color(Integer.parseInt(resources.getString("color.r")),
			Integer.parseInt(resources.getString("color.g")), Integer.parseInt(resources.getString("color.b")));
	private  boolean noError= false;
	private int countThread = 0;
	private ArrayList<Interfaz> listaInterfaces = null;
	private ArrayList<Red> listaRedes= null;
	private DefaultComboBoxModel<String> modeRedes;
	private DefaultComboBoxModel<String> modeInterface;
	//Elementos graficos
	//Layouts
	private BorderLayout borderL = new BorderLayout();
	private GridLayout gridL = new GridLayout(2,1);
	private GridLayout gridLHeaderFooter = new GridLayout(1,1);
	//contenedores
	private static Container mainContainer;
	private static Container panelsContainer = new Container();
	private static Container buttonsContainer = new Container();
	private static Container titleContainer = new Container();
	private ConfigIPpanel panelIp = new ConfigIPpanel(this);
	private ConfigProxyPanel panelProxy = new ConfigProxyPanel(this);
	private JPanel panelButtons = new JPanel();
	private JPanel panelTitle = new JPanel();
	private JButton btnGuardar = new JButton(resources.getString("tag.newprofile.buttoncontainer.save"));
	private JButton btnCancelar = new JButton(resources.getString("tag.newprofile.buttoncontainer.cancel"));
	private JLabel lblTitulo = new JLabel(resources.getString("tag.newprofile.titlecontainer.title"));
	
	private NewProfileImp(){
		setTitle("timeStamp: " + System.currentTimeMillis());
		setSize(570,650);
		setLocation(400,50);
		setResizable(true);	
		setMinimumSize(new Dimension(570,650));
		cargarIPpanel();
		panelIp.initRadio(true);
		cargarProxyPanel();
		panelProxy.initRadio(true);
		cargarHeaderFooter();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(colorFondoTabbedPane);
		mainContainer = getContentPane();
		mainContainer.setLayout(borderL);
		//Layouts
		panelsContainer.setLayout(gridL);
		buttonsContainer.setLayout(gridLHeaderFooter);
		titleContainer.setLayout(gridLHeaderFooter);
		//add panels
		titleContainer.add(panelTitle);
		buttonsContainer.add(panelButtons);		
		panelsContainer.add(panelIp);
		panelsContainer.add(panelProxy);
		//add containers
		mainContainer.add(buttonsContainer,BorderLayout.SOUTH);
		mainContainer.add(panelsContainer,BorderLayout.CENTER);		
		mainContainer.add(titleContainer,BorderLayout.NORTH);
		aplicarEstilos();
		//SwingUtilities.updateComponentTreeUI(this);
		logger.infoMessage("*********************Pantalla NEW PROFILE initialized******************");
	}

	public static NewProfileImp getIntance() {
		if(instanceNewProfil == null){
			instanceNewProfil = new NewProfileImp();
		}
		return instanceNewProfil;
	}
	
	public void aplicarEstilos(){
		btnGuardar.setMnemonic(KeyEvent.VK_G);
		btnGuardar.setToolTipText(resources.getString("tag.newprofile.guardar.tooltiptex"));
		
		btnCancelar.setMnemonic(KeyEvent.VK_ESCAPE); // revisa el escape
		btnCancelar.setToolTipText(resources.getString("tag.newprofile.cancelar.tooltiptex"));
	}
	
	public void cargarHeaderFooter(){
		try{
			lblTitulo.setFont(new Font("Tahoma",0,18));
			panelTitle.add(lblTitulo);
			panelButtons.setLayout(new GridLayout(1,2));
			panelButtons.add(btnGuardar);
			panelButtons.add(btnCancelar);
		}catch(Exception e){
			logger.severeError("*****************Error al cargar header and footer***************************" 
					+ e.toString() , e);
			exitVentana(1);
		}
	}
	public void cargarIPpanel() {
		try {
			panelIp.cargarElementos();
			logger.infoMessage("*****************Modulo configurar IP inicializada*********************");
		} catch (Exception e) {
			logger.severeError("Error al cargar los elementos de la configuracion IP" 
					+ e.toString() , e);
			exitVentana(1);
		}
	}
	public void cargarProxyPanel() {
		try{
			panelProxy.cargarElementos();
			logger.infoMessage("*****************Modulo configurar proxy inicializada*********************");
		}catch(Exception e){
			logger.severeError("Error al cargar los elementos de la configuracion del proxy" 
					+ e.toString() , e);
			exitVentana(1);
		}
	}
	public void guardaPerfil() {
		// TODO Auto-generated method stub
		
	}

	public void crearInterfaces() {
		try{
			if(countThread == 0){
				new ThreadOp(this).ejecutar(0);
				countThread++;
				return;
			}
			JOptionPane.showMessageDialog(null, resources.getString("msg.info.interfaces"),"Aviso",JOptionPane.INFORMATION_MESSAGE);
		}catch(IllegalThreadStateException ex){
			logger.severeError("Error al iniciar el thread ", ex);
		}
	}
	
	public void crearRedes() {
		try{
			new ThreadOp(this).ejecutar(1);
		}catch(IllegalThreadStateException ex){
			logger.severeError("Error al iniciar el thread ", ex);
		}
	}

	public void llenarComboInterfaces(ArrayList<Interfaz> listaInterfaces) {
		setModeInterface((DefaultComboBoxModel<String>)panelIp.getCmbInterfaces().getModel());
		getModeInterface().removeAllElements();
		setListaInterfaces(listaInterfaces);		
		for(Interfaz inter: listaInterfaces){
			panelIp.getCmbInterfaces().addItem(inter.getNombre());
		}
	}

	public void llenarComboRedes(ArrayList<Red> listaRedes) {
		setModeRedes((DefaultComboBoxModel<String>)panelProxy.getCmbNetworks().getModel());
		getModeRedes().removeAllElements();
		setListaRedes(listaRedes);
		for(Red red: listaRedes){
			panelProxy.getCmbNetworks().addItem(red.getNombre());
		}
	}


	@Override
	public void exitApp(int flagStatus) {
		// TODO Auto-generated method stub		
	}
	public void setDetailInterfaces(int index,String itemSelected){
		try{
			if(getModeInterface() == null){
				return;
			}
			if(getModeInterface().getSize() != 0){
				if(itemSelected.contains(resources.getString("tag.wi")) || itemSelected.contains(resources.getString("tag.wim")) && 
						itemSelected.contains(resources.getString("tag.fi")) || itemSelected.contains(resources.getString("tag.fim"))){
					panelProxy.HabDesabElementos(true);
				}else{
					panelProxy.HabDesabElementos(false);
				}
				panelIp.getLblinfoEstado().setText(getListaInterfaces().get(index).getEstado());
				panelIp.getLblinfoTipo().setText(getListaInterfaces().get(index).getTipo());
			}
		}catch(Exception e){
			logger.severeError("Ocurrio un error", e);
			JOptionPane.showMessageDialog(null, resources.getString("msg.exit.error"),"Error",JOptionPane.ERROR_MESSAGE);
			exitVentana(1);
		}
		
	}
	
	@Override
	public void setDetailRedes(int index) {
		if(getModeRedes() == null){
			return;
		}
		if(getModeRedes().getSize() != 0){
			panelProxy.getLblinfoAuth().setText(getListaRedes().get(index).getAutentificacion());
			panelProxy.getLblinfoCifrado().setText(getListaRedes().get(index).getCifrado());
			
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
			noError = true;
			commonHand.salirWindow(this);
		break;
		}
		
	}
	
	/**
	 * Flag ayuda saber si se abrira la ventana de la clase o una secundaria
	 */
	@Override
	public void mostrarVentana(boolean flag) {
		if(instanceNewProfil != null){
			if(noError){
				JOptionPane.showMessageDialog(null, resources.getString("msg.exit.error"),"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(true);
		}
	}
	public void changeStateTexts(int flagPanel){
		//Ip panel
		try{
			if(flagPanel == 0){
				panelIp.changeStateTexts();
			}else{//Proxy panel
				panelProxy.changeStateTexts();
			}
		}catch(Exception e){
			logger.severeError("Error inesperado: " 
					+ e.toString() , e);
			exitVentana(1);
		}
	}
	public ArrayList<Interfaz> getListaInterfaces() {
		return listaInterfaces;
	}

	public void setListaInterfaces(ArrayList<Interfaz> listaInterfaces) {
		this.listaInterfaces = listaInterfaces;
	}

	public ArrayList<Red> getListaRedes() {
		return listaRedes;
	}

	public void setListaRedes(ArrayList<Red> listaRedes) {
		this.listaRedes = listaRedes;
	}

	public int getCountThread() {
		return countThread;
	}

	public void setCountThread(int countThread) {
		this.countThread = countThread;
	}

	public DefaultComboBoxModel<String> getModeRedes() {
		return modeRedes;
	}

	public void setModeRedes(DefaultComboBoxModel<String> modeRedes) {
		this.modeRedes = modeRedes;
	}

	public DefaultComboBoxModel<String> getModeInterface() {
		return modeInterface;
	}

	public void setModeInterface(DefaultComboBoxModel<String> modeInterface) {
		this.modeInterface = modeInterface;
	}
}
