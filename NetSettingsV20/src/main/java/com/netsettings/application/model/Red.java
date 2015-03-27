package com.netsettings.application.model;

public class Red {
	private String nombre;
	private String autentificacion;
	private String cifrado = null;
	public String getNombre() {
		return nombre;
	}
	public String getAutentificacion() {
		return autentificacion;
	}
	public String getCifrado() {
		return cifrado;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAutentificacion(String autentificacion) {
		this.autentificacion = autentificacion;
	}
	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	
	
}
