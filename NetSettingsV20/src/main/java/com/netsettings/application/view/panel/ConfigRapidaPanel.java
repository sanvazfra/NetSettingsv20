package com.netsettings.application.view.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import com.netsettings.application.view.MainWindow;
import com.netsettings.application.view.MainWindowImp;

public class ConfigRapidaPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private SpringLayout sprLConfigRap = new SpringLayout();
	private GridBagLayout gridBagLayout = new GridBagLayout();
	private GridBagConstraints constraint = new GridBagConstraints();
	private Insets insets = new Insets(0, 0, 0, 0);

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
		this.setLayout(gridBagLayout);
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.title"));
		this.add(etiqueta,getConstraint(0, 0, 3, 1, 0.0, 0.0, 10, 0, 10, 0));
		restartSize();
		
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.proxy"));
		constraint.anchor = GridBagConstraints.EAST;
		this.add(etiqueta,getConstraint(0, 1, 1, 1, 0.0, 0.0,0,5,10,0));
		restartSize();
		
		etiqueta = new JLabel(resources.getString("tag.mainwindow.configrapida.label.puerto"));
		constraint.anchor = GridBagConstraints.EAST;
		this.add(etiqueta,getConstraint(0, 2, 1, 1, 0.0, 0.0,0,5,10,0));
		restartSize();
		
		//Cajas de texto
		setStretch(1);
		this.add(txtProxyAdd,getConstraint(1, 1, 2, 1, 0.0, 0.0,0,5,5,5));
		restartSize();
		
		setStretch(1);
		this.add(txtPuerto,getConstraint(1, 2, 2, 1, 0.0, 0.0,0,5,5,5));
		restartSize();
		
		//Botones
		this.add(btnSet,getConstraint(0, 3, 1, 1, 0.0, 0.0,0,0,5,0));
		restartSize();
		
		this.add(btnCancel,getConstraint(1, 3, 1, 1, 0.0, 0.0,0,5,5,0));
		restartSize();
		
		//Radios
		radioGroup.add(jrbEnabled);
		radioGroup.add(jrbDisabled);
		jrbEnabled.setActionCommand("enabled"); 
		jrbDisabled.setActionCommand("disabled");
		jrbDisabled.setSelected(true);
		
		constraint.anchor = GridBagConstraints.WEST;
		this.add(jrbEnabled,getConstraint(1, 4, 1, 1, 0.0, 0.0,0,5,5,0));
		
		constraint.anchor = GridBagConstraints.WEST;
		this.add(jrbDisabled,getConstraint(2, 4, 1, 1, 1.0, 0.0,0,0,5,0));
		restartSize();

		//Text Area
		area.setEnabled(false);
		constraint.anchor = GridBagConstraints.EAST;
		this.add(lblOverride,getConstraint(0, 4, 1, 1, 0.0, 0.0,0,10,0,0));
		restartSize();
		
		setStretch(3);
		this.add(scroll,getConstraint(0, 5, 3, 3, 0.0, 1.0,0,5,5,5));
		restartSize();
		//CheckBox
		constraint.anchor = GridBagConstraints.EAST;
		this.add(chkLocal,getConstraint(1, 8, 2, 1, 0.0, 0.0,0,0,5,0));
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
