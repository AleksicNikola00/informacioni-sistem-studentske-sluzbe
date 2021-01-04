package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import controller.Validate;
import model.Profesor;
import view.MainFrame;
import view.ProfesoriJTable;
import view.StudentiJTable;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 0) {
			if(StudentiJTable.getInstance().getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "Odaberite studenta!");
			}
			else {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite obrisati studenta?",
						"Brisanje studenta", JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION)
					StudentiController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 1) {
			if(ProfesoriJTable.getInstance().getSelectedRow()==-1){
				JOptionPane.showMessageDialog(null, "Odaberite profesora!");
			}
			else {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite obrisati profesora?",
						"Brisanje profesora", JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION) {
					int index=ProfesoriJTable.getInstance().getSelectedRow();
					Profesor profesor=ProfesoriController.getInstance().getProfesor(index);
					if(Validate.validateProfesorAddedToSubject(profesor)) {
						JOptionPane.showMessageDialog(null, "Profesor dodat na predmet, uklonite predmet prije brisanja profesora!");
					}
					else
						ProfesoriController.getInstance().izbrisiProfesora(index);
				}
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 2) {
			if(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow()==-1){
				String message = MainFrame.getInstance().getResourceBundle().getString("invalidPredmet");
				JOptionPane.showMessageDialog(null, message);
			}
			else {
				String message = MainFrame.getInstance().getResourceBundle().getString("deletePredmetMsg");
				String title = MainFrame.getInstance().getResourceBundle().getString("deletePredmetTitle");
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), message,
						title, JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION)
					PredmetiController.getInstance().izbrisiPredmet(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow());
			}
		}
	}

}
