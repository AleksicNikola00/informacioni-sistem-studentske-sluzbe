package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenta;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public int getColumnCount() {
		return BazaStudenta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudenta.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenta.getInstance().getColumnName(column);
	}
	
}
