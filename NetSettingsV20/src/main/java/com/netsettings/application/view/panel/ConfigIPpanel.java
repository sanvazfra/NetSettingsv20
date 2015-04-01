package com.netsettings.application.view.panel;

import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionListener;
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

public class ConfigIPpanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String propFileName = "properties.newp";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private ActionListener clicHandler ;
	private JFrame context;
	private ComboHandler comboHandler;
	private RadioHandler radioHandler;
	//Objetos graficos
	private SpringLayout layout = new SpringLayout();
	private  JLabel etiqueta;
	private  JTextField txtNombre;
	private  JComboBox<String> cmbInterfaces;
	private  JButton btnGetInteface;
	private  ButtonGroup grupo;
	private  JRadioButton rbFija ;
	private  JRadioButton rbDHCP ;
	private  JTextField txtIp;
	private  JTextField txtMask ;
	private  JTextField txtGate ;
	private JTextField txtPreferDNS;
	private JTextField txtAltDNS;
	private JLabel lblinfoEstado;
	private JLabel lblinfoTipo;
	
	//private NewProfile newProfile;
	
	
	public ConfigIPpanel(JFrame context){
		this.setLayout(layout);
		this.setBorder(BorderFactory.createTitledBorder(null, "Config. IP", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		this.setContext(context);
		comboHandler = new ComboHandler(context,this);
		clicHandler = new ClicHandler(getContext());
		radioHandler = new RadioHandler(context);
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblnombre.title"));
		txtNombre = new JTextField(15);
		cmbInterfaces = new JComboBox<String>();
		cmbInterfaces.addItem("[Get interfaces]");
		cmbInterfaces.addActionListener(comboHandler);
		cmbInterfaces.setActionCommand(resources.getString("command.comboInterface"));
		btnGetInteface = new JButton(resources.getString("tag.newprofile.configippanel.btngetinterfaces.title"));
		btnGetInteface.setActionCommand(resources.getString("command.getinterface"));
		btnGetInteface.addActionListener(clicHandler);
		grupo = new ButtonGroup();
		rbFija = new JRadioButton(resources.getString("tag.newprofile.configippanel.rbFija.title"));
		rbFija.addActionListener(radioHandler);
		rbFija.setActionCommand(resources.getString("command.rbfija"));
		rbDHCP = new JRadioButton(resources.getString("tag.newprofile.configippanel.rbDHCP.title"));
		rbDHCP.addActionListener(radioHandler);
		rbDHCP.setActionCommand(resources.getString("command.rbDHCP"));
		txtIp = new JTextField(15);
		txtMask = new JTextField(15);
		txtGate = new JTextField(15);
		txtPreferDNS = new JTextField(15);
		txtAltDNS = new JTextField(15);
		lblinfoEstado =new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoEstado.hint"));
		lblinfoTipo = new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoTipo.hint"));
	}
	
	public void aplicarEstilos(){
		btnGetInteface.setMnemonic(KeyEvent.VK_3);
		btnGetInteface.setToolTipText(resources.getString("tag.newprofile.configippanel.btngetinterfaces.tootiptex"));
	}
	
	public void cargarElementos() throws Exception{
		//Cajas de texto
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblnombre.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 20, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtNombre, 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtNombre, 20, SpringLayout.NORTH, this);//eje Y
		
		//ComboBox
		layout.putConstraint(SpringLayout.WEST, cmbInterfaces, 5, SpringLayout.EAST, txtNombre);//eje X
		layout.putConstraint(SpringLayout.NORTH, cmbInterfaces, 20, SpringLayout.NORTH, this);//eje Y
		
		layout.putConstraint(SpringLayout.WEST, btnGetInteface, 40, SpringLayout.EAST, rbDHCP);//eje X
		layout.putConstraint(SpringLayout.NORTH, btnGetInteface, 50, SpringLayout.NORTH, this);//eje Y
		
		//Radios
		grupo.add(rbFija);
		grupo.add(rbDHCP);
		rbDHCP.setSelected(true);
		
		layout.putConstraint(SpringLayout.WEST, rbFija, 100, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, rbFija, 60, SpringLayout.NORTH, this);//eje Y
		
		layout.putConstraint(SpringLayout.WEST, rbDHCP, 200, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, rbDHCP, 60, SpringLayout.NORTH, this);//eje Y
		
		//Etiquetas/Cajas de texto
		//IP
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblip.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 90, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtIp, 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtIp, 90, SpringLayout.NORTH, this);//eje Y
		
		//Mask
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblmask.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 120, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtMask, 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtMask, 120, SpringLayout.NORTH, this);//eje Y
		
		//Gateway
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblgate.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 150, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtGate, 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtGate, 150, SpringLayout.NORTH, this);//eje Y
		
		//DNS preferido
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lbldnsprefer.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 180, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtPreferDNS , 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtPreferDNS, 180, SpringLayout.NORTH, this);//eje Y
		
		//DNS alternativo
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lbldnsalter.title"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 210, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, txtAltDNS , 120, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, txtAltDNS, 210, SpringLayout.NORTH, this);//eje Y
		aplicarEstilos();
		//detalles de interfaz
		//Tipo de interfaz
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoTipo"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 330, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 100, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, lblinfoTipo, 390, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, lblinfoTipo, 100, SpringLayout.NORTH, this);//eje Y

		//estado de interfaz
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoEstado"));
		layout.putConstraint(SpringLayout.WEST, etiqueta, 330, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 120, SpringLayout.NORTH, this);//eje Y
		add(etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, lblinfoEstado, 390, SpringLayout.WEST, this);//eje X
		layout.putConstraint(SpringLayout.NORTH, lblinfoEstado, 120, SpringLayout.NORTH, this);//eje Y
		
		//Agregamos los objetos al layout
		add(txtNombre);
		add(cmbInterfaces);
		add(btnGetInteface);
		add(rbFija);
		add(rbDHCP);
		add(txtIp);
		add(txtMask);
		add(txtGate);
		add(txtPreferDNS);
		add(txtAltDNS);
		
		add(lblinfoTipo);
		add(lblinfoEstado);
		
	}
	public void changeStateTexts(){
		if(rbDHCP.isSelected()){
			txtIp.setEnabled(false);
			txtMask.setEnabled(false);
			txtGate.setEnabled(false);
			txtPreferDNS.setEnabled(false);
			txtAltDNS.setEnabled(false);
		}else if(rbFija.isSelected()){
			txtIp.setEnabled(true);
			txtMask.setEnabled(true);
			txtGate.setEnabled(true);
			txtPreferDNS.setEnabled(true);
			txtAltDNS.setEnabled(true);
		}
	}
	/**
	 * @return the context
	 */
	public JFrame getContext() {
		return context;
	}
	public void initRadio(boolean flag){
		rbFija.setSelected(flag);
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(JFrame context) {
		this.context = context;
	}

	public JComboBox<String> getCmbInterfaces() {
		return cmbInterfaces;
	}

	public JLabel getLblinfoTipo() {
		return lblinfoTipo;
	}

	public void setLblinfoTipo(JLabel lblinfoTipo) {
		this.lblinfoTipo = lblinfoTipo;
	}
	public JLabel getLblinfoEstado() {
		return lblinfoEstado;
	}

	public void setLblinfoEstado(JLabel lblinfoEstado) {
		this.lblinfoEstado = lblinfoEstado;
	}
}
