package com.netsettings.application.model;

import javax.swing.table.DefaultTableModel;

public class DataModel extends DefaultTableModel{
	
	/**
	 * Mejorar codigo
	 */
	private static final long serialVersionUID = 1L;

	public DataModel(Object[][] data,Object[] column) {
		super(data,column);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		super.isCellEditable(row, column);
		if(column == 1){
			return true;
		}
		return false;
	}
	
	@Override
	public void removeRow(int row) {
		super.removeRow(row);
	}
	
}
