package com.netsettings.application.controller;

import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LoggerUtil {
	
	private static Logger logger;
	private static LoggerUtil loggerUtil = null;
	private FileHandler handler;
	private SimpleFormatter formatter;
	private String propFileName = "properties.mainw";
	private ResourceBundle resources;
	private String sDirectorioTrabajo;
	
	private LoggerUtil(Logger log){
		try{
			logger = log;
			logger.setLevel(Level.ALL);
			resources = ResourceBundle.getBundle(propFileName);
			setsDirectorioTrabajo(System.getProperty(resources.getString("config.currentlocation")));
			handler = new FileHandler(getsDirectorioTrabajo() + "\\logs\\log_file.txt",false);
			formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
			logger.addHandler(handler);
			logger.info("Logger init()");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static LoggerUtil getLoggerInstance(Logger log) {
		if(loggerUtil==null){
			loggerUtil = new LoggerUtil(log);
		}
		return loggerUtil;
	}
	
	public void severeError(String error, Exception ex){
		logger.log(Level.SEVERE,error,ex);
	}
	public void warninMessage(String message){
		logger.warning(message);
	}
	public void infoMessage(String message){
		logger.info(message);
	}
	public void configMessage(String message){
		logger.config(message);
	}
	/**
	 * @return the sDirectorioTrabajo
	 */
	public String getsDirectorioTrabajo() {
		return sDirectorioTrabajo;
	}

	/**
	 * @param sDirectorioTrabajo the sDirectorioTrabajo to set
	 */
	public void setsDirectorioTrabajo(String sDirectorioTrabajo) {
		this.sDirectorioTrabajo = sDirectorioTrabajo;
	}
}
