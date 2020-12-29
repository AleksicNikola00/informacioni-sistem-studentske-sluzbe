package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.ProfesoriController;
import controller.StudentiController;
import view.MainFrame;
import view.ProfesoriJTable;
import view.StudentiJTable;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 0) {
			int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete studenta?",
					"Brisanje studenta", JOptionPane.YES_NO_OPTION);
			if(code==JOptionPane.YES_OPTION) {
				StudentiController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 1) {
			int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da obrišete profesora?",
					"Brisanje profesora", JOptionPane.YES_NO_OPTION);
			if(code==JOptionPane.YES_OPTION)
				ProfesoriController.getInstance().izbrisiProfesora(ProfesoriJTable.getInstance().getSelectedRow());
		}
		
	}

}
