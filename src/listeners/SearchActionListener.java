package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


import view.AbstractTableModelStudenti;
import view.MainFrame;
import view.Toolbar;

public class SearchActionListener implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
		//https://coderanch.com/t/498077/java/row-filters-combined
		if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			String[] niz=Toolbar.getInstance().getSearchBox().getText().split(" ");
			String prezime=niz[0];
	
			AbstractTableModelStudenti model=(AbstractTableModelStudenti) MainFrame.getInstance().getTabelaStudenata().getModel();
			TableRowSorter<AbstractTableModelStudenti> sorter=new TableRowSorter<AbstractTableModelStudenti>(model);
			java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(3);
			//"(?i)"-case insensitive flag!
			filters.add(RowFilter.regexFilter(".*"+"(?i)"+prezime+".*",2));
			if(niz.length>=2) 
			{
				String ime=niz[1];
				filters.add(RowFilter.regexFilter(".*"+"(?i)"+ime+".*",1));
				if(niz.length==3)
				{
					String index=niz[2];
					index.toUpperCase();
					System.out.println(index);
					filters.add(RowFilter.regexFilter(".*"+"(?i)"+index+".*",0));
				}
									
			}
			RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
			 sorter.setRowFilter(serviceFilter);
			MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorter);
			
		}
	}

}
