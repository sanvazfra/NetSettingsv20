package com.netsettings.application.view.panel;

import java.awt.Color; 
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;
import java.awt.Insets;
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
	//private SpringLayout layout = new SpringLayout();
	private GridBagLayout gridBagLayout = new GridBagLayout();
	private GridBagConstraints constraint = new GridBagConstraints();
	private Insets insets = new Insets(0, 0, 0, 0);
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
		//this.setLayout(layout);
		this.setLayout(gridBagLayout);
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
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta,getConstraint(0, 0, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		setStretch(1);
		add(txtNombre,getConstraint(1, 0, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		add(cmbInterfaces, getConstraint(3, 0, 2, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();		
		
		//ComboBox		
		add(btnGetInteface,getConstraint(3, 1, 2, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		//Radios
		grupo.add(rbFija);
		grupo.add(rbDHCP);
		rbDHCP.setSelected(true);
		
		add(rbFija,getConstraint(1, 1, 1, 1, 1.0, 0.0, 0, 0, 0, 0));
		add(rbDHCP, getConstraint(2, 1, 1, 1, 1.0, 0.0, 0, 0, 0, 0));  //------------->
		restartSize();
		
		//Etiquetas/Cajas de texto
		//IP
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblip.title"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta,getConstraint(0, 2, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
			
		setStretch(1);
		add(txtIp,getConstraint(1, 2, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		//Mask
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblmask.title"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta,getConstraint(0, 3, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		setStretch(1);
		add(txtMask,getConstraint(1, 3, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		//Gateway
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblgate.title"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta,getConstraint(0, 4, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		setStretch(1);
		add(txtGate, getConstraint(1, 4, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		//DNS preferido
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lbldnsprefer.title"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta, getConstraint(0, 5, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
	
		setStretch(1);
		add(txtPreferDNS, getConstraint(1, 5, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		//DNS alternativo
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lbldnsalter.title"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta, getConstraint(0, 6, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
		
		setStretch(1);
		add(txtAltDNS,getConstraint(1, 6, 2, 1, 1.0, 0.0, 0, 0, 0, 10));
		restartSize();
		aplicarEstilos();
		
		//detalles de interfaz
		//Tipo de interfaz
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoTipo"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta, getConstraint(3, 2, 1, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();
		
		add(lblinfoTipo,getConstraint(4, 2, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();

		//estado de interfaz
		etiqueta = new JLabel(resources.getString("tag.newprofile.configippanel.lblinfoEstado"));
		constraint.anchor = GridBagConstraints.EAST;
		add(etiqueta, getConstraint(3, 3, 1, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();
		
		add(lblinfoEstado,getConstraint(4, 3, 1, 1, 0.0, 0.0, 0, 0, 0, 10));
		restartSize();
	}
	public GridBagConstraints getConstraint(int x, int y, int width, int height, double weightx,double weighty,
			int top, int left, int bottom, int right){
		constraint.gridx=x;
		constraint.gridy=y;
		constraint.gridwidth = width;
		constraint.gridheight = height;
		constraint.weightx= weightx;
		constraint.weighty= weighty;
		insets.set(top, left, bottom, right);
		constraint.insets = insets;
		return constraint;
	}
	
	public void setStretch(int direction){
		switch (direction) {
		case 1:
				constraint.fill = GridBagConstraints.HORIZONTAL;
			break;
		case 2:
				constraint.fill = GridBagConstraints.VERTICAL;
			break;
		case 3:
			constraint.fill = GridBagConstraints.BOTH;
			break;
		default://restart
				constraint.fill = GridBagConstraints.NONE;
			break;
		}
	}
	public void restartSize(){
		constraint.gridwidth = 0;
		constraint.gridheight = 0;
		constraint.weightx = 0.0;
		constraint.weighty = 0.0;
		insets.set(0, 0, 0, 0);
		constraint.fill = GridBagConstraints.NONE;
		constraint.anchor = GridBagConstraints.CENTER;
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
