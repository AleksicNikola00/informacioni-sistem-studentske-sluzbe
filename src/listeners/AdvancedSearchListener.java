package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.TableRowSorter;

import view.AbstractTableModelPredmeti;
import view.AbstractTableModelStudenti;
import view.MainFrame;
import view.Toolbar;

public class AdvancedSearchListener implements ActionListener {
	
	private boolean notFilter;
    private boolean andOr;//true-and false-or
    private int iterator;
    private int filterNum;
    private boolean mode;//true-student false-predmet

    private AbstractTableModelStudenti modelStudent;
    private TableRowSorter<AbstractTableModelStudenti> sorterStudenta;
    private AbstractTableModelPredmeti modelPredmet;
    private TableRowSorter<AbstractTableModelPredmeti> sorterPredmeta;
    private ArrayList<RowFilter<Object, Object>>  Finalfilters;
    private RowFilter<Object,Object> serviceFilter;
    private String[] niz;
	
	//

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
		//https://coderanch.com/t/498077/java/row-filters-combined
		//https://stackoverflow.com/questions/5194948/java-swing-combine-rowfilter-andfilter-with-rowfilter-orfilter
		if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			mode = true;
			filterNum=0;
			modelStudent=(AbstractTableModelStudenti) MainFrame.getInstance().getTabelaStudenata().getModel();
			sorterStudenta=new TableRowSorter<AbstractTableModelStudenti>(modelStudent);
			Finalfilters = new ArrayList<RowFilter<Object, Object>>();
			//

			 niz=Toolbar.getInstance().getSearchBox().getText().split(" ");
			 System.out.println("Duzina niza "+niz.length);
			iterator=findBracket(0)+1;
			if(niz.length<3) {
				sorterStudenta.setRowFilter(null);
			}else {
			
				try {
					addToList();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Neispravan format upita! Obavezno unosenje razmaka izmedju elemenata!");
					sorterStudenta.setRowFilter(null);
					return;
				}
			System.out.println("And or value " + andOr);
			if(andOr)
				 serviceFilter = RowFilter.andFilter(Finalfilters);
			else
				serviceFilter = RowFilter.orFilter(Finalfilters);
			sorterStudenta.setRowFilter(serviceFilter);
			
			}
			MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorterStudenta);
		}
		else if(MainFrame.getInstance().getSelectedIndex() == 2) {
            mode=false;
            filterNum=0;
            modelPredmet = (AbstractTableModelPredmeti) MainFrame.getInstance().getTabelaPredmeta().getModel();
            sorterPredmeta=new TableRowSorter<AbstractTableModelPredmeti>(modelPredmet);
            Finalfilters = new ArrayList<RowFilter<Object, Object>>();

             niz=Toolbar.getInstance().getSearchBox().getText().split(" ");
             System.out.println("Duzina niza "+niz.length);
            iterator=findBracket(0)+1;
            if(niz.length<3) {
                sorterPredmeta.setRowFilter(null);
            }else {

                try {
                    addToList();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Neispravan format upita! Obavezno unosenje razmaka izmedju elemenata!");
                    sorterPredmeta.setRowFilter(null);
                    return;
                }

            System.out.println("And or value " + andOr);
            if(andOr)
                 serviceFilter = RowFilter.andFilter(Finalfilters);
            else
                serviceFilter = RowFilter.orFilter(Finalfilters);
            sorterPredmeta.setRowFilter(serviceFilter);

            }
            MainFrame.getInstance().getTabelaPredmeta().setRowSorter(sorterPredmeta);
        }
	}
	
	public void addToList() {
		
		ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
		RowFilter<Object,Object> filter1;
		boolean andOrInner=true;//and-true or-false
		for(int i=iterator;i<niz.length;i+=4) {
			
			
			if(niz[i].equals("(")) {
					filterNum-=filters.size();
					if(niz[i-1].equals("and")) 
						andOr=true;
					else if(niz[i-1].equals("or"))
						andOr=false;
					//
					if(andOrInner)
						filter1=RowFilter.andFilter(filters);
					else
						filter1=RowFilter.orFilter(filters);
					
					System.out.println("AndOrInner1: "+andOrInner);
					Finalfilters.add(filter1);
					//
					iterator=i+1;
					addToList();
					break;
				
			}
		
			
			if(niz[i-1].equals(")")) {
				
				filterNum-=filters.size();
				if(niz[i].equals("and"))
					andOr=true;
				else if(niz[i].equals("or"))
					andOr=false;
				
				if(andOrInner)
					filter1=RowFilter.andFilter(filters);
				else
					filter1=RowFilter.orFilter(filters);
				
				System.out.println("AndOrInner2: "+andOrInner);
				Finalfilters.add(filter1);
				//
				if(findBracket(i)==-1)
					iterator=i+1;
				else
					iterator=findBracket(i)+1;
					
				addToList();
				break;
			}
			
			System.out.println("----------------------------------------");
			System.out.println("NIIZ:");
			System.out.println(niz[i] + "  " + niz[i+1] + " " + niz[i+2] + " ");
			System.out.println("----------------------------------------");
			
			if(niz[i-1].equals("and"))
				andOrInner=true;
			else
				andOrInner=false;
			
			int column=getColumn(niz[i]);
			ComparisonType cmpType=getComparisonType(niz[i+1]);
			if((column<3 && mode) || ((column<2 || column==4)&&!mode)) {//stringovi,regex-i
				String porediSa=urediString(niz[i+2]);
				if(cmpType==ComparisonType.NOT_EQUAL) {
					filters.add(RowFilter.notFilter(RowFilter.regexFilter(porediSa, column)));
				}
				else {
					filters.add(RowFilter.regexFilter(porediSa, column));
				}
				
			}else {//int
				if((column==3 && mode) || ((column>=2 && column<=3)&&!mode)) {
					int broj=Integer.parseInt(niz[i+2]);
					if(notFilter)
						filters.add(RowFilter.notFilter(RowFilter.numberFilter(cmpType, broj, column)));
					else
						filters.add(RowFilter.numberFilter(cmpType, broj, column));
				}//double
				else {
					double brojD=Double.parseDouble((niz[i+2]));
					if(notFilter)
						filters.add(RowFilter.notFilter(RowFilter.numberFilter(cmpType, brojD, column)));
					else
						filters.add(RowFilter.numberFilter(cmpType, brojD, column));
				}
			}
			
			++filterNum;
		}
		if(filterNum>0) {
			filterNum-=filters.size();
			System.out.println("AndOrInner3: "+andOrInner);
			if(andOrInner)
				filter1=RowFilter.andFilter(filters);
			else
				filter1=RowFilter.orFilter(filters);
			Finalfilters.add(filter1);
		}
	}
	
	public ComparisonType getComparisonType(String string) {
		ComparisonType compType=ComparisonType.EQUAL;
		notFilter=false;
		if(string.equals("!=")) 
			compType=ComparisonType.NOT_EQUAL;
		else if(string.equals(">")) 
			compType=ComparisonType.AFTER;
		else if(string.equals("<"))
			compType=ComparisonType.BEFORE;
		else if(string.equals("<=")) {
			notFilter=true;
			compType=ComparisonType.AFTER;
		}else if(string.equals(">=")) {
			notFilter=true;
			compType=ComparisonType.BEFORE;
		}
		return compType;
	}
	
	public int getColumn(String string) {
		
		int column=-1;
		if(string.equals("ime") || string.equals("naziv"))
			column=1;
		else if(string.equals("prezime") || string.equals("espb"))
			column=2;
		else if(string.equals("godina"))
			column=3;
		else if(string.equals("semestar"))
            column=4;
		else if(string.equals("prosek"))
			column =5;
		else if(string.equals("indeks") || string.equals("sifra"))
			column=0;
		
		return column;
	}
	
	public String urediString(String string) {
		String povratni;
	
		if(string.charAt(0)=='"') {
			povratni=string.substring(1,string.length()-1);
			povratni="^"+povratni+"$";
		}
		else {
			povratni=string.substring(1,string.length()-1);

		}
		
		System.out.println("povratni: "+povratni);
		return povratni;
	}
	

	
	public int findBracket(int index) {
		int leftBracketAt=0;
		for(leftBracketAt=index;leftBracketAt<niz.length;leftBracketAt++)
			 if(niz[leftBracketAt].equals("(")) {
				if(niz[leftBracketAt+1].equals("("))
					return leftBracketAt+1;//moguc oblik upita na pocetku je da ima  ( ( 
				return leftBracketAt;
			 }
		return -1;
	}
}


