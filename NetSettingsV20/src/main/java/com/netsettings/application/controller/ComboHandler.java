package com.netsettings.application.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.netsettings.application.view.NewProfile;
import com.netsettings.application.view.panel.ConfigIPpanel;
import com.netsettings.application.view.panel.ConfigProxyPanel;

public class ComboHandler implements ActionListener{
	private String propFileName = "properties.handler";
	private ResourceBundle resources = ResourceBundle.getBundle(propFileName);
	private JFrame context;
	private JPanel subContext;


	public ComboHandler(JFrame context, JPanel subContext) {
		this.setContext(context); //New profile window
		this.setSubContext(subContext); // panel config ip 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.comboInterface"))){
			ConfigIPpanel panel = (ConfigIPpanel)getSubContext();
			NewProfile newprofile = (NewProfile)getContext();
			//el item seleccionado es nulo la primera vez que se ejecuta el tread
			String itemSelected = panel.getCmbInterfaces().getSelectedItem() == null ? itemSelected =  null :  panel.getCmbInterfaces().getSelectedItem().toString();
			newprofile.setDetailInterfaces(panel.getCmbInterfaces().getSelectedIndex(),itemSelected);
		}else if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.comboRedes"))){
			ConfigProxyPanel panel = (ConfigProxyPanel)getSubContext();
			NewProfile newprofile = (NewProfile)getContext();
			newprofile.setDetailRedes(panel.getCmbNetworks().getSelectedIndex());
		}
	}

	public JFrame getContext() {
		return context;
	}
	public void setContext(JFrame context) {
		this.context = context;
	}
	
	public JPanel getSubContext() {
		return subContext;
	}

	public void setSubContext(JPanel subContext) {
		this.subContext = subContext;
	}
}


