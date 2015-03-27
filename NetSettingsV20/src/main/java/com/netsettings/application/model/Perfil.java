package com.netsettings.application.model;

public class Perfil {
	private String nombre;
	private String fechaCreacion;
	private String Description;
	private String location;
	public String getNombre() {
		return nombre;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public String getDescription() {
		return Description;
	}
	public String getLocation() {
		return location;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
