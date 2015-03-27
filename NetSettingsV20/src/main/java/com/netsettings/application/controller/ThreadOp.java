package com.netsettings.application.controller;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.netsettings.application.model.Interfaz;
import com.netsettings.application.model.Red;
import com.netsettings.application.view.NewProfile;


public class ThreadOp extends Thread{
	private LoggerUtil logger = LoggerUtil.getLoggerInstance(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	private String propFileName = "properties.newp";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private int flag;
	private EjecutarCMDOp ejecutarCMD;
	
	NewProfile context;	
	public ThreadOp(JFrame context){
		if(context instanceof NewProfile){
			this.context = (NewProfile)context;
		}
		ejecutarCMD = new EjecutarCMDOp();
	}
	
	@Override
	public void run() {
		super.run();
		if(flag == 0){
			try {
				if(!createInterfaces()){
					logger.severeError("Ocurrio un error", null);
					this.join();
					JOptionPane.showMessageDialog(null, resources.getString("msg.exit.error.thread.interfaces"),"Error",JOptionPane.ERROR_MESSAGE);
				}else{
					logger.infoMessage("##########El proceso termino correctamente##########");
				}
			} catch (InterruptedException e) {
				logger.severeError(e.getMessage(), e);
			}
		}else if(flag == 1){
			try {
				if(!createRedes()){
					logger.severeError("Ocurrio un error", null);
					this.join();
					JOptionPane.showMessageDialog(null, resources.getString("msg.exit.error.thread.redes"),"Error",JOptionPane.ERROR_MESSAGE);
				}else{
					logger.infoMessage("##########El proceso termino correctamente##########");
				}
			} catch (InterruptedException e) {
				logger.severeError(e.getMessage(), e);
			}
		}
	}
	public void finishThread(){
		
	}
	public void openEplorer(){
		
	}
	public ArrayList<Red> getRedes(){
		return null;
	}
	public boolean createInterfaces(){
		ArrayList<Interfaz> listaInterface = null;
		try {
			listaInterface = ejecutarCMD.ejecutarCMDInterfaz();
			if(!listaInterface.isEmpty() || listaInterface.size() != 0){
				context.llenarComboInterfaces(listaInterface);
				return true;
			}
		} catch (Exception e) {
			logger.severeError("Error al extraer la lista de interfaces ", e);
		}
		return false;
	}
	
	public boolean createRedes(){
		ArrayList<Red> listaRedes = null;
		try {
			listaRedes = ejecutarCMD.ejecutarCMDRedes();
			if(!listaRedes.isEmpty() || listaRedes.size() != 0){
				context.llenarComboRedes(listaRedes);
				return true;
			}
		} catch (Exception e) {
			logger.severeError("Error al extraer la lista de redes ", e);
		}
		return false;
	}
	public void ejecutar(int flag){
		this.flag = flag;
		this.start();
		logger.infoMessage("##########Inicio el thread para flag:  " + flag + " ##########   \n0 - Obtener interfaces \n1 - Obtener redes");
	}
	
}
