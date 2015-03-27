package com.netsettings.application.view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import com.netsettings.application.controller.ClicHandler;
import com.netsettings.application.controller.ComboHandler;
import com.netsettings.application.controller.RadioHandler;
import com.netsettings.application.view.CommonView;

public class ConfigProxyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String propFileName = "properties.newp";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private SpringLayout layout = new SpringLayout();
	private JFrame context;
	private ComboHandler comboHandler;
	private ClicHandler clichandler;
	private RadioHandler radioHandler;
	//Elementos graficos
	private ButtonGroup grupoProxy;
	private JRadioButton rbEnableProxy;
	private JRadioButton rbDisableProxy;
	private JLabel etiqueta;
	private JTextField txtProxy;
	public  JComboBox<String> cmbNetworks;
	public JButton btnGetNeworks;
	private CommonView commonView = new CommonView();
	private JLabel lblinfoAuth;
	private JLabel lblinfoCifrado;
	
	
	public ConfigProxyPanel(JFrame context){
		setLayout(layout);
		setBorder(BorderFactory.createTitledBorder(null, "Config. Proxy", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		this.setContext(context);
		comboHandler = new ComboHandler(getContext(), this);
		clichandler = new ClicHandler(getContext());
		radioHandler = new RadioHandler(getContext());
		grupoProxy = new ButtonGroup();
		rbEnableProxy = new JRadioButton(resources.getString("tag.newprofile.configproxtpanel.rbenable.title"));
		rbEnableProxy.addActionListener(radioHandler);
		rbEnableProxy.setActionCommand(resources.getString("command.enableproxy"));
		rbDisableProxy = new JRadioButton(resources.getString("tag.newprofile.configproxtpanel.rbdisable.title"));
		rbDisableProxy.addActionListener(radioHandler);
		rbDisableProxy.setActionCommand(resources.getString("command.disableproxy"));
	
		txtProxy = new JTextField(15);
		cmbNetworks = new JComboBox<String>();
		cmbNetworks.addItem("[Get networks]");
		cmbNetworks.addActionListener(comboHandler);
		cmbNetworks.setActionCommand(resources.getString("command.comboRedes"));
		btnGetNeworks = new JButton(resources.getString("tag.newprofile.configproxypanel.btngetnetworks.title"));
		btnGetNeworks.addActionListener(clichandler);
		btnGetNeworks.setActionCommand(resources.getString("command.getRedes"));
		lblinfoAuth =new JLabel(resources.getString("tag.newprofile.configproxy.lblinfoauth.hint"));
		lblinfoCifrado = new JLabel(resources.getString("tag.newprofile.configproxy.lblinfocifrado.hint"));
	}
	
	public void cargarElementos()  throws Exception{

		grupoProxy.add(rbEnableProxy);
		grupoProxy.add(rbDisableProxy);
		rbEnableProxy.setSelected(true);
		//radios
		layout.putConstraint(SpringLayout.WEST, rbEnableProxy, 100, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, rbEnableProxy, 50, SpringLayout.NORTH, this);//eje Y
		
		layout.putConstraint(SpringLayout.WEST, rbDisableProxy, 200, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, rbDisableProxy, 50, SpringLayout.NORTH, this);//eje Y
		
		//textos
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lbldireccion.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, etiqueta, 90, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtProxy, 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, txtProxy, 90, SpringLayout.NORTH, this);//eje Y
		
		//comboBox
		layout.putConstraint(SpringLayout.WEST, cmbNetworks, 300, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, cmbNetworks, 50, SpringLayout.NORTH, this);//eje Y
		
		layout.putConstraint(SpringLayout.WEST, btnGetNeworks, 300, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, btnGetNeworks, 90, SpringLayout.NORTH, this);//eje Y
		
		//Avisos
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lblavisoactualizaredes.title"));
		etiqueta.setForeground(Color.red);
		etiqueta.setFont(new Font("Arial", Font.PLAIN, 12));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 10, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, etiqueta, 170, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lblavisoconexionauto.title"));
		etiqueta.setForeground(Color.red);
		etiqueta.setFont(new Font("Arial", Font.PLAIN, 12));
		layout.putConstraint(SpringLayout.WEST,etiqueta, 10, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.SOUTH, etiqueta, 190, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		aplicarEstilos();
		
		//detalles de red
		//Tipo de red
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxy.lblinfoauth"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 100, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, lblinfoAuth, 140, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, lblinfoAuth, 100, SpringLayout.NORTH, this);//eje Y

		//estado de red
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxy.lblinfocifrado"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 120, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, lblinfoCifrado, 140, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, lblinfoCifrado, 120, SpringLayout.NORTH, this);//eje Y
		
		//revision pendiente para imagen*****************************
//		layout.putConstraint(SpringLayout.WEST, networkIcon, 338, SpringLayout.WEST, this);//eje X
//		layout.putConstraint(SpringLayout.SOUTH, networkIcon, 173, SpringLayout.NORTH, this);//eje Y
		
		add(rbEnableProxy);
		add(rbDisableProxy);
		add(txtProxy);
		add(cmbNetworks);
		add(btnGetNeworks);
		
		add(lblinfoAuth);
		add(lblinfoCifrado);
	}
	
	public void aplicarEstilos(){
		
//		btnGuardar.setIcon(commonView.getResizeImageIcon(30, 30,resources.getString("uri.guardar")));
//		btnGuardar.setToolTipText("Guarda el perfil");
//		btnGuardar.setMnemonic(KeyEvent.VK_ENTER);
//		
//		btnCancelar.setIcon(commonView.getResizeImageIcon(30, 30, resources.getString("uri.cancelar")));
//		btnCancelar.setToolTipText("Cancela la edicion");
//		btnCancelar.setMnemonic(KeyEvent.VK_ESCAPE);
//		
		btnGetNeworks.setMnemonic(KeyEvent.VK_2);
		btnGetNeworks.setToolTipText(resources.getString("tag.newprofile.configproxypanel.btngetnetworks.tootiptex"));
	}
	
	public void changeStateTexts(){
		if(rbEnableProxy.isSelected()){
			txtProxy.setEnabled(true);
		}else if(rbDisableProxy.isSelected()){
			txtProxy.setEnabled(false);
		}
	}
	/**
	 * @return the context
	 */
	public JFrame getContext() {
		return context;
	}
	public void initRadio(boolean flag){
		rbEnableProxy.setSelected(flag);
	}
	public void HabDesabElementos(boolean flag){
		cmbNetworks.setEnabled(flag);
		btnGetNeworks.setEnabled(flag);
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(JFrame context) {
		this.context = context;
	}

	public JComboBox<String> getCmbNetworks() {
		return cmbNetworks;
	}

	public void setCmbNetworks(JComboBox<String> cmbNetworks) {
		this.cmbNetworks = cmbNetworks;
	}

	public JLabel getLblinfoAuth() {
		return lblinfoAuth;
	}

	public JLabel getLblinfoCifrado() {
		return lblinfoCifrado;
	}

	public void setLblinfoAuth(JLabel lblinfoAuth) {
		this.lblinfoAuth = lblinfoAuth;
	}

	public void setLblinfoCifrado(JLabel lblinfoCifrado) {
		this.lblinfoCifrado = lblinfoCifrado;
	}
}	