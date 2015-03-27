package com.netsettings.application.controller;

import java.util.ResourceBundle;

import javax.swing.JFrame;

import com.netsettings.application.model.Interfaz;
import com.netsettings.application.model.Red;

public class CommonController {
	
	private String propFileName = "properties.common";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	
	public void salirApp(int flag){
		if(flag == 0){
			System.exit(flag);
		}
		System.exit(flag);
	}
	public void salirWindow(JFrame window){
			window.dispose();
	}
	
	public Interfaz getObjectoInterfaz(String s /*int index*/) {
		String estado;
		Interfaz interfaz = new Interfaz();
		interfaz.setNombre(s.substring(47, s.length()));
		interfaz.setTipo(s.substring(30,38));
		estado= s.substring(15,24).startsWith("c") || s.substring(15,24).startsWith("C") ? "Conectado" : "Desconectado"; 
		interfaz.setEstado(estado);
		return interfaz;
	}
	
	public void getObjectToRed(String s, Red red){
		if(s.contains(resources.getString("tag.ssid.tittle"))){
			red.setNombre(s.substring(9,s.length()).length() == 0 ? "Red oculta" : s.substring(9,s.length()));
		}else if(s.contains(resources.getString("tag.autenti.tittle"))){
			red.setAutentificacion(s.substring(29,s.length()));
		}else if(s.contains(resources.getString("tag.cifrado.tittle"))){
			red.setCifrado(s.substring(29,s.length()));
		}
	}
}
