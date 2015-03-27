package com.netsettings.application.view;

import java.util.ArrayList;

import com.netsettings.application.model.Interfaz;
import com.netsettings.application.model.Red;

public interface NewProfile extends com.netsettings.application.view.Window{
	public void cargarIPpanel();
	public void cargarProxyPanel();
	public void guardaPerfil();
	public void crearInterfaces();
	public void crearRedes();
	public void llenarComboInterfaces(ArrayList<Interfaz> listaInterfaces);
	public void llenarComboRedes(ArrayList<Red> listaRedes);
	public void setDetailInterfaces(int index, String itemSelected);
	public void setDetailRedes(int index);
	public void changeStateTexts(int flagPanel);
}
