package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenta;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.NepolozeniPredmetiPanel;
import view.StudentiIzmenaDialog;
import view.StudentiJTable;

public class DodajPredmetStudentu implements ActionListener {

	private ArrayList<Predmet> listaPredmeta;
	private ArrayList<Predmet> listaNepolozenihPredmeta;
	private Student student;
	ArrayList<Ocena> listaPolozenihPredmeta;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object[] buttons= {"Dodaj","Odustani"};
		int rowIndex=StudentiJTable.getInstance().getSelectedRow();
		student=BazaStudenta.getInstance().getRow(rowIndex);
		listaNepolozenihPredmeta=student.getSpisakNepolozenihIspita();
		 listaPolozenihPredmeta=student.getSpisakPolozenihIspita();
		//lista koju prikazujemo
		 listaPredmeta=BazaPredmeta.getInstance().getSviPredmeti();
		 //System.out.println(listaPredmeta.size());
		DefaultListModel<String> dlm=new DefaultListModel<String>();
		JList<String> list =new JList<String>(dlm);
		for (Predmet predmet : listaPredmeta) {
			if(!postojiUListiNepolozenih(predmet) && !(postojiUListiPolozenih(predmet)) && odgovarajucaGodina(predmet)) {
				String sifraIme=predmet.getSifraPredmeta()+"-"+predmet.getNazivPredmeta();
				dlm.addElement(sifraIme);
			}
		}
		if(list.getModel().getSize()==0) {
			JOptionPane.showMessageDialog(null, "Ni jedan predmet nije dostpuan!");
			return;
		}
		
		int result=JOptionPane.showOptionDialog(StudentiIzmenaDialog.getInstance(), list, "Dodaj predmet",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, buttons, null);
		
		if (result == JOptionPane.YES_OPTION && list.getSelectedValue()!=null) {
			String[] imePrezime=list.getSelectedValue().split("-");
			Predmet predmet=BazaPredmeta.getInstance().getSviPredmet(imePrezime[0]);
			listaNepolozenihPredmeta.add(predmet);
			NepolozeniPredmetiPanel.getInstance().refreshPanel();
			return;
		}
	}
	
	public boolean postojiUListiPolozenih(Predmet predmet) {
		boolean exists=false;
		for (Ocena ocena : listaPolozenihPredmeta) {
			if(predmet.getSifraPredmeta().equals(ocena.getPredmet().getSifraPredmeta())) {
				exists=true;
				break;
			}
		}
		return exists;
	}
	
	public boolean postojiUListiNepolozenih(Predmet predmet) {
		boolean exists=false;
		for (Predmet predmet1 : listaNepolozenihPredmeta) {
			if(predmet1.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				exists=true;
				break;
			}
		}
		return exists;
	}
	
	public boolean odgovarajucaGodina(Predmet predmet) {
		boolean exists=false;
		if(student.getTrenutnaGodinaStudija()>=predmet.getGodinaStudija())
			exists=true;
		
		return exists;
	}
	
	
}
