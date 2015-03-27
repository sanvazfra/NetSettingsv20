package com.netsettings.application.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.netsettings.application.view.NewProfile;
import com.netsettings.application.view.Window;


public class ClicHandler implements ActionListener{
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private ResourceBundle resources;
	private com.netsettings.application.view.Window context;
	
	public ClicHandler(JFrame context) {
		setResources(ResourceBundle.getBundle("properties.handler"));
		this.context = (Window) context;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		int comando = getFlagOption(event.getActionCommand());
		NewProfile newProf = null;
		switch (comando) {
		case 0:
				newProf = (NewProfile)context;
				newProf.crearInterfaces();
			break;
		case 1:
				newProf = (NewProfile)context;
				newProf.crearRedes();
			break;
		case 2:
			break;
		default:
			logger.severeError("Error: No se pudo seleccionar el comando solicitado", null);
			JOptionPane.showMessageDialog(null, "No se pudo ejecutar la accion deseada, "
					+ "reinicie la aplicacion e intentelo de nuevo!! Mas detalles en el log","Error",JOptionPane.ERROR_MESSAGE);
				getContext().exitVentana(1);
			throw new UnknownError("Error: No "
					+ "se pudo seleccionar el comando solicitado");
		}
	}
	public int getFlagOption(String comando){
		if(comando.equalsIgnoreCase(resources.getString("command.getinterface"))){
			return 0;
		}else if(comando.equalsIgnoreCase(resources.getString("command.getRedes"))){
			return 1;
		}else return -1;
	}

	/**
	 * @return the resources
	 */
	public ResourceBundle getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}

	/**
	 * @return the context
	 */
	public Window getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Window context) {
		this.context = context;
	}

}
