package com.netsettings.application.view.panel;

import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.netsettings.application.view.MainWindow;
import com.netsettings.application.view.MainWindowImp;

public class ConfigRapidaPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpringLayout sprLConfigRap = new SpringLayout();
	private String propFileName = "properties.mainw";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	
	private MainWindow mainWindow;
	//elementos graficos
	private JLabel etiqueta = null;
	public JTextField txtPuerto = new JTextField(4);
	public JTextField txtProxyAdd = new JTextField(15);
	private JButton btnSet = new JButton(resources.getString("tag.mainwindow.configpanel.btnset"));
	private JButton btnCancel = new JButton(resources.getString("tag.mainwindow.configpanel.btncancel"));
	private ButtonGroup radioGroup = new ButtonGroup();
	public JRadioButton jrbEnabled = new JRadioButton(resources.getString("tag.mainwindow.configpanel.radio.yes"));
	public JRadioButton jrbDisabled = new JRadioButton(resources.getString("tag.mainwindow.configpanel.radio.no"));
	public JTextArea area = new JTextArea(3,30);
	private JScrollPane scroll = new JScrollPane(area);
	private JLabel lblOverride = new JLabel(resources.getString("tag.mainwindow.configpanel.labeloverride.title"));
	public JCheckBox chkLocal = new JCheckBox(resources.getString("tag.mainwindow.configpanel.check"));
	
	public ConfigRapidaPanel(MainWindowImp main) {
		super();
		setMainWindow(main);
	}
	
	public void cargarElementos() throws Exception{
		this.setLayout(sprLConfigRap);
		//Etiquetas
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.title"));
		sprLConfigRap.putConstraint(SpringLayout.HORIZONTAL_CENTER, etiqueta, 0, SpringLayout.HORIZONTAL_CENTER, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, etiqueta, 20, SpringLayout.NORTH, this);//eje Y
		this.add(etiqueta);
		
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.proxy"));
		sprLConfigRap.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, etiqueta, 60, SpringLayout.NORTH, this);//eje Y
		this.add(etiqueta);
		
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.puerto"));
		sprLConfigRap.putConstraint(SpringLayout.WEST, etiqueta, 50, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, etiqueta, 100, SpringLayout.NORTH, this);//eje Y
		
		//Cajas de texto
		sprLConfigRap.putConstraint(SpringLayout.WEST, txtProxyAdd, 150, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, txtProxyAdd, 60, SpringLayout.NORTH, this);//eje Y
		
		sprLConfigRap.putConstraint(SpringLayout.WEST, txtPuerto, 150, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, txtPuerto, 100, SpringLayout.NORTH, this);//eje Y
		
		//Botones
		sprLConfigRap.putConstraint(SpringLayout.WEST, btnSet, 50, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, btnSet, 140, SpringLayout.NORTH, this);//eje Y
		
		sprLConfigRap.putConstraint(SpringLayout.WEST, btnCancel, 200, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, btnCancel, 140, SpringLayout.NORTH, this);//eje Y
		
		//Radios
		radioGroup.add(jrbEnabled);
		radioGroup.add(jrbDisabled);
		jrbEnabled.setActionCommand("enabled"); 
		jrbDisabled.setActionCommand("disabled");
		jrbDisabled.setSelected(true);
		
		sprLConfigRap.putConstraint(SpringLayout.WEST, jrbEnabled, 190, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, jrbEnabled, 195, SpringLayout.NORTH, this);//eje Y
	
		sprLConfigRap.putConstraint(SpringLayout.WEST, jrbDisabled, 230, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, jrbDisabled, 195, SpringLayout.NORTH, this);//eje Y
		
		//Text Area
		area.setEnabled(false);
		sprLConfigRap.putConstraint(SpringLayout.WEST, lblOverride, 50, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, lblOverride, 200, SpringLayout.NORTH, this);//eje Y
		
		sprLConfigRap.putConstraint(SpringLayout.WEST, scroll, 50, SpringLayout.WEST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.NORTH, scroll, 220, SpringLayout.NORTH, this);//eje Y
		
		//CheckBox
		sprLConfigRap.putConstraint(SpringLayout.EAST, chkLocal, -26, SpringLayout.EAST, this);//eje X
		sprLConfigRap.putConstraint(SpringLayout.SOUTH, chkLocal, -12 , SpringLayout.SOUTH, this);//eje Y
		
		this.add(etiqueta);
		this.add(txtProxyAdd);
		this.add(txtPuerto);
		this.add(btnSet);
		this.add(btnCancel);
		this.add(jrbEnabled);
		this.add(jrbDisabled);
		this.add(lblOverride);
		this.add(scroll);
		this.add(chkLocal);
	}

	/**
	 * @return the mainWindow
	 */
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * @param mainWindow the mainWindow to set
	 */
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
}	
