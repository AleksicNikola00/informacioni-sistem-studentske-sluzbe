package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import view.MainFrame;
import view.PredmetiJTable;
import view.ProfesoriJTable;
import view.StudentiJTable;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 0) {
			if(StudentiJTable.getInstance().getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null, "Odaberite studenta!");
			else {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete studenta?",
						"Brisanje studenta", JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION)
					StudentiController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 1) {
			if(ProfesoriJTable.getInstance().getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null, "Odaberite profesora!");
			else {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete profesora?",
						"Brisanje profesora", JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION)
					ProfesoriController.getInstance().izbrisiProfesora(ProfesoriJTable.getInstance().getSelectedRow());
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 2) {
			if(PredmetiJTable.getInstance().getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null, "Odaberite predmet!");
			else {
				int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete predmet?",
						"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
				if(code==JOptionPane.YES_OPTION)
					PredmetiController.getInstance().izbrisiPredmet(PredmetiJTable.getInstance().getSelectedRow());
			}
		}
	}

}
