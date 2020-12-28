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

	private String ime,prezime,index;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
		//https://coderanch.com/t/498077/java/row-filters-combined
		if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			String[] niz=Toolbar.getInstance().getSearchBox().getText().split(" ");
			String ime=niz[0];
			
			
			//System.out.println(niz.length);
			AbstractTableModelStudenti model=(AbstractTableModelStudenti) MainFrame.getInstance().getTabelaStudenata().getModel();
			TableRowSorter<AbstractTableModelStudenti> sorter=new TableRowSorter<AbstractTableModelStudenti>(model);
			java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(3);
			//sorter.setRowFilter(RowFilter.regexFilter(".*"+ime+".*",1));
			filters.add(RowFilter.regexFilter(".*"+ime+".*",1));
			if(niz.length>=2) 
			{
				String prezime=niz[1];
				//TableRowSorter<AbstractTableModelStudenti> sorter1=new TableRowSorter<AbstractTableModelStudenti>(model);
				//sorter1.setRowFilter(RowFilter.regexFilter(".*"+prezime+".*",2));
				//MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorter1);
				filters.add(RowFilter.regexFilter(".*"+prezime+".*",2));
				if(niz.length==3)
				{
					String index=niz[2];
					//TableRowSorter<AbstractTableModelStudenti> sorter2=new TableRowSorter<AbstractTableModelStudenti>(model);
					//System.out.println(index);
					//sorter2.setRowFilter(RowFilter.regexFilter(".*"+index+".*",0));
					//MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorter2);
					filters.add(RowFilter.regexFilter(".*"+index+".*",0));
				}
									
			}
			RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
			 sorter.setRowFilter(serviceFilter);
			MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorter);
			
		}
	}

}
