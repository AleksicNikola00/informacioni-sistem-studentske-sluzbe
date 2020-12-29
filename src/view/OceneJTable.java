package view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;



import java.awt.Color;
import java.awt.Component;

public class OceneJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static OceneJTable instance;
	
	public static OceneJTable getInstance() {
		if (instance == null) {
			instance = new OceneJTable();
		}
		return instance;
	}
	
	private OceneJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelOcene());
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		
		return c;
	}
}
