package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import controller.ProfesoriController;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import view.PredmetePredajeProfesorPanel;
import view.ProfesoriIzmenaDialog;
import view.ProfesoriJTable;

public class DodajProfesoruPredmet implements ActionListener {

	private ArrayList<Predmet> listaPredmeta;
	private ArrayList<Predmet> predmetiKojeProfesorPredaje;
	private Profesor profesor;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] buttons = {"Potvrdi","Odustani"};
		int rowIndex = ProfesoriJTable.getInstance().getSelectedRow();
		profesor = ProfesoriController.getInstance().getProfesor(rowIndex);
		predmetiKojeProfesorPredaje = profesor.getPredmeti();
		listaPredmeta = BazaPredmeta.getInstance().getSviPredmeti();
		
		DefaultListModel<String> dlm =new DefaultListModel<String>();
		JList<String> list = new JList<String>(dlm);
		
		for (Predmet predmet : listaPredmeta) {
			if(!postojiUListiPredmetaKojeProfesorPredaje(predmet)) {
				String sifraIme = predmet.getSifraPredmeta() + "-"  + predmet.getNazivPredmeta();
				dlm.addElement(sifraIme);
			}
		}
		
		if(list.getModel().getSize()==0) {
			JOptionPane.showMessageDialog(null, "Ni jedan predmet nije dostpuan!");
			return;
		}
		
		Object[] message = {"Predmeti:", list};
		
		int result = JOptionPane.showOptionDialog(ProfesoriIzmenaDialog.getInstance(), message, "Dodaj predmet",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, buttons, null);
		
		if (result == JOptionPane.YES_OPTION && list.getSelectedValue()!=null) {
			String[] niz = list.getSelectedValue().split("-");
			Predmet predmet = BazaPredmeta.getInstance().getSviPredmet(niz[0]);
			predmet.getProfesor().getPredmeti().remove(predmet);
			int index = ProfesoriJTable.getInstance().getSelectedRow();
			Profesor profesor = ProfesoriController.getInstance().getProfesor(index);
			predmet.setProfesor(profesor);
			predmetiKojeProfesorPredaje.add(predmet);
			PredmetePredajeProfesorPanel.getInstance().refreshPanel();
			return;
		}
	}
	
	public boolean postojiUListiPredmetaKojeProfesorPredaje(Predmet predmet) {
		boolean exists=false;
		for (Predmet predmet1 : predmetiKojeProfesorPredaje) {
			if(predmet1.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				exists=true;
				break;
			}
		}
		return exists;
	}

}
