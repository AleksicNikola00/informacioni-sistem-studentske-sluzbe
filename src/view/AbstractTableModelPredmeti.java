package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2177631931847342087L;

	public AbstractTableModelPredmeti() {}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==3 || columnIndex==2)
            return Integer.parseInt(BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex));
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return switch(columnIndex) {
		case 2->Integer.class;
		case 3->Integer.class;
		default -> String.class;
		};
	}
}
