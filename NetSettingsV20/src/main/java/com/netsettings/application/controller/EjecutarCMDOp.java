package com.netsettings.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.netsettings.application.model.Interfaz;
import com.netsettings.application.model.Red;

public class EjecutarCMDOp {
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private String propFileName = "properties.comandos";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private CommonController commonController;
	Interfaz interfaz;
	Red red;
	
		
	public ArrayList<Interfaz> ejecutarCMDInterfaz() throws Exception{
		commonController = new CommonController();
		ArrayList<Interfaz> listaInterfaces = new ArrayList<Interfaz>();
			String s = null;
			int index = 0;
			try {
				Process p = Runtime.getRuntime().exec(resources.getString("combcmd0006"));
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(
						p.getErrorStream()));
				while ((s = stdInput.readLine()) != null) {
					if (index != 0 && index != 1 && index != 2 && s.length() != 0) {
						interfaz = commonController.getObjectoInterfaz(s/*, index*/);
						listaInterfaces.add(interfaz);
					}
					index++;
				}
				while ((s = stdError.readLine()) != null) {
					logger.infoMessage(s);
				}
			} catch (IOException e) {
				throw new Exception(e);
			}
			return listaInterfaces;
	}
	public ArrayList<Red> ejecutarCMDRedes() throws Exception{
		commonController = new CommonController();
		ArrayList<Red> listaRedes = new ArrayList<Red>();
			String s = null;
			int index = 0;
			Red red = new Red();
			try {
				Process p = Runtime.getRuntime().exec(resources.getString("combcmd0007"));
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(
						p.getErrorStream()));
				while ((s = stdInput.readLine()) != null) {
					if (index != 0 && index != 1 && index != 2 && s.length() != 0) {
							commonController.getObjectToRed(s, red);
					}
					if(red.getCifrado() != null){
						listaRedes.add(red);
						red = new Red();
					}
					index++;
				}
				while ((s = stdError.readLine()) != null) {
					logger.infoMessage(s);
				}
			} catch (IOException e) {
				throw new Exception(e);
			}
			return listaRedes;
	}
	
}
