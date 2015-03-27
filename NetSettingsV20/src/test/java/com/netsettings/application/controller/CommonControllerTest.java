package com.netsettings.application.controller;

import org.junit.Before;
import org.junit.Test;

public class CommonControllerTest {
	private CommonController commonController;
	
	@Before
	public void setUp(){
		commonController = new CommonController();
	}
	
	@Test
	public void crearObjectoInterfazTest() {
		commonController.getObjectoInterfaz("Habilitado     Conectado      Dedicado         VirtualBox Host-Only Network");
	}
}
