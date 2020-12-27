package view;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTableModelOcene extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return BazaOcena.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaOcena.getInstance().getOcene().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
		//return BazaPredmeta.getInstance().getColumnName(column);
	}
	
}
