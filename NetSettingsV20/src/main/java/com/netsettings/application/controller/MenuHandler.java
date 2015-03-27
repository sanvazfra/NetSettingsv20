package com.netsettings.application.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.netsettings.application.view.Window;

public class MenuHandler implements ActionListener{
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private ResourceBundle resources;
	private Window context;
	
	public MenuHandler(JFrame context) {
		setContext((Window)context);
		resources = ResourceBundle.getBundle("properties.handler");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int comando = getFlagOption(e.getActionCommand());
		switch (comando) {
		case 0:
			getContext().mostrarVentana(false);	
			break;

		case 1:
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
		if(comando.equalsIgnoreCase(resources.getString("command.mostrarnuevoperfil"))){
			return 0;
		}
		return -1;
	}
	public Window getContext() {
		return context;
	}
	
	public void setContext(Window context) {
		this.context = context;
	}

}
