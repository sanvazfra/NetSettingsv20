package com.netsettings.application.view;

import java.awt.Image;	

import javax.swing.ImageIcon;

public class CommonView {
	
	public ImageIcon getResizeImageIcon(int width,int heigth,String UrlImgToResize){
		ImageIcon icon = new ImageIcon(getClass().getResource( UrlImgToResize));
		Image img = icon.getImage();
		Image imgResize = img.getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(imgResize);
	}
	
}
