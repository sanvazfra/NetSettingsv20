package com.netsettings.application.controller;

import javax.swing.JFrame;
import com.netsettings.application.model.Perfil;
import com.netsettings.application.view.NewProfile;
import com.netsettings.application.view.Window;

public class PerfilesControllerImp implements PerfilesController {
	private Window context;
	private NewProfile newProfile;
	
	public PerfilesControllerImp(JFrame context){
		if(context instanceof NewProfile){
			newProfile = (NewProfile)context;
		}
	}

	@Override
	public void saverProfile(Perfil perfil) {
		switch (perfil.getComb()) {
		case 1: //Proxy - IP fija
				//Crear instrucciones en el archivo de propiedades
				//llamar a las  instrucciones segun la combinaciones
			System.out.println("1");
			break;
		case 2: //Proxy - DHCP
			System.out.println("2");	
			break;
		case 3: // Fija
			System.out.println("3");
			break;
		case 4: // DHCP
			System.out.println("4");
			break;
		case 5: //Proxy
			System.out.println("5");
			break;	
		default:
			break;
		}
	}

	@Override
	public void createInstructions() {
		// TODO Auto-generated method stub
		
	}


}
