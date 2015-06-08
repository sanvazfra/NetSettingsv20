package com.netsettings.application.view;

import java.awt.Image;	
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class CommonView {
	
	public ImageIcon getResizeImageIcon(int width,int heigth,String UrlImgToResize){
		ImageIcon icon = new ImageIcon(getClass().getResource( UrlImgToResize));
		Image img = icon.getImage();
		Image imgResize = img.getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(imgResize);
	}
	
	public boolean validarLenght(String input){
		if(input.trim().length() != 0){		
			return true;	
		}
		return false;
	}
	public boolean validarIP(String input){
		String PATTERN = 
		        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		  Pattern pattern = Pattern.compile(PATTERN);
	      Matcher matcher = pattern.matcher(input.trim());
	      return matcher.matches();   
	}
	public int evaluateComb(String comb){
		if(comb.equals("PF")){
			return 1;
		}else if(comb.equals("PD")){
			return 2;
		}else if(comb.equals("F")){
			return 3;
		}else if(comb.equals("D")){
			return 4;
		}else if(comb.equals("P")){
			return 5;
		}
		return 0;
	}

}
