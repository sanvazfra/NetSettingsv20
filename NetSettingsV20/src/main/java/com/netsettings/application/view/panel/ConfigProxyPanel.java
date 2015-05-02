package com.netsettings.application.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import com.netsettings.application.controller.LoggerUtil;
import com.netsettings.application.controller.RadioHandler;

public class ConfigProxyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String propFileName = "properties.newp";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);

//	private SpringLayout layout = new SpringLayout();
	private GridBagLayout gridBagLayout = new GridBagLayout();
	private GridBagConstraints constraint = new GridBagConstraints();
	private Insets insets = new Insets(0, 0, 0, 0);
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
	//private CommonView commonView = new CommonView();
	private JLabel lblinfoAuth;
	private JLabel lblinfoCifrado;
	private JPanel networkImage = new NetWorkImage();
	
	
	public ConfigProxyPanel(JFrame context){
		//setLayout(layout);
		setLayout(gridBagLayout);
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
		this.add(rbEnableProxy,getConstraint(1, 0, 1, 1, 0.0, 0.0, 0, 0, 5, 0));
		restartSize();
		
		this.add(rbDisableProxy,getConstraint(2, 0, 1, 1, 1.0, 0.0, 0, 0, 5, 0));
		restartSize();
		
		//button,text's
		this.add(cmbNetworks,getConstraint(3, 0, 1, 1, 0.0, 0.0, 0, 0, 5, 0));
		restartSize();

		constraint.anchor = GridBagConstraints.EAST;
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lbldireccion.title"));
		this.add(etiqueta,getConstraint(0, 1, 1, 1, 0.0, 0.0, 0, 0, 10, 5));
		restartSize();
		
		setStretch(3);
		this.add(txtProxy,getConstraint(1, 1, 2, 1, 0.0, 0.0, 0, 0, 10, 0));
		restartSize();
		
		this.add(btnGetNeworks,getConstraint(3, 1, 1, 1, 0.0, 0.0, 0, 0, 10, 0));
		restartSize();
	
		//detalles de red
		//Tipo de red
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxy.lblinfoauth"));
		constraint.anchor = GridBagConstraints.EAST;
		this.add(etiqueta,getConstraint(0, 2, 1, 1, 0.0, 0.0, 0, 0, 0, 5));
		restartSize();
	
		this.add(lblinfoAuth,getConstraint(1, 2, 1, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();

		//estado de red
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxy.lblinfocifrado"));
		constraint.anchor = GridBagConstraints.EAST;
		this.add(etiqueta,getConstraint(0, 3, 1, 1, 0.0, 0.0, 0, 0, 10, 5));
		restartSize();
	
		this.add(lblinfoCifrado,getConstraint(1, 3, 1, 1, 0.0, 0.0, 0, 0, 10, 0));
		restartSize();
		
		//Avisos
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lblavisoactualizaredes.title"));
		etiqueta.setForeground(Color.red);
		etiqueta.setFont(new Font("Arial", Font.PLAIN, 12));
		constraint.anchor = GridBagConstraints.WEST;
		this.add(etiqueta,getConstraint(0, 4, 4, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();
		
		constraint.anchor = GridBagConstraints.CENTER;
		this.add(networkImage,getConstraint(3, 4, 1, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();
		
		etiqueta = new JLabel(resources.getString("tag.newprofile.configproxypanel.lblavisoconexionauto.title"));
		etiqueta.setForeground(Color.red);
		etiqueta.setFont(new Font("Arial", Font.PLAIN, 12));

		
		constraint.anchor = GridBagConstraints.WEST;
		this.add(etiqueta,getConstraint(0, 5, 4, 1, 0.0, 0.0, 0, 0, 0, 0));
		restartSize();
		
	
		aplicarEstilos();
		
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
		btnGetNeworks.setToolTipText(resources.getString("tag.newprofile.configippanel.btngetinterfaces.tootiptex"));
		
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
	
	/**
	 * 
	 * Clase anonima para establecer la imagen de fondo en el panel de configuracion del proxy.
	 * @author pako
	 *
	 */
	class NetWorkImage extends JPanel{
		
		/**
		 * NetWorkIcon
		 */
		private static final long serialVersionUID = 1L;
		public Image img;
		private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
		
		public NetWorkImage(){
			try{
				setBackground(resources.getString("uri.networkimage"));
				setPreferredSize(new Dimension(35,25));
			}catch(Exception e){
				logger.severeError("Error al cargar el icono de red en el panel", e);
			}
			
		}
		
		@Override
		public void paint(Graphics g) {
			int width = this.getSize().width;
			int height =this.getSize().height;
			if(this.img != null){
				try{
					g.drawImage(this.img, 0, 0, width, height, null);
					logger.infoMessage("El icono de red, se configuro en el panel correctamente......");
				}catch(Exception e){
					logger.severeError("Error al cargar el panel del icono de red", e);
				}
			}else{
				logger.infoMessage("Error al cargar la imagen de red en el panel");
			}
			super.paintComponents(g);			
		}
		
		public void setBackground(String path) throws IllegalAccessException{
			img = getResizeImageIcon(35, 30, path).getImage();
			repaint();
		}
		
		public ImageIcon getResizeImageIcon(int width,int heigth,String UrlImgToResize) throws IllegalArgumentException{
			ImageIcon icon = new ImageIcon(getClass().getResource(UrlImgToResize));
			Image img = icon.getImage();
			Image imgResize = img.getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH);
			return new ImageIcon(imgResize);
		}
	}
}	
