package com.netsettings.application.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import com.netsettings.application.view.NewProfile;
import com.netsettings.application.view.NewProfileImp;

public class RadioHandler implements ActionListener{
	
	@SuppressWarnings("unused")
	private JFrame context;
	private NewProfile newProfile;
	private ResourceBundle resources;
	
	public RadioHandler(JFrame context){
		if(context instanceof NewProfile){
			this.newProfile = (NewProfileImp)context;	
		}else this.context = context;
		resources = ResourceBundle.getBundle("properties.handler");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.rbfija"))){
			newProfile.changeStateTexts(0);
		}else if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.rbDHCP"))){
			newProfile.changeStateTexts(0);
		}else if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.enableproxy"))){
			newProfile.changeStateTexts(1);
		}else if(e.getActionCommand().equalsIgnoreCase(resources.getString("command.disableproxy"))){
			newProfile.changeStateTexts(1);
		}
	}

}
