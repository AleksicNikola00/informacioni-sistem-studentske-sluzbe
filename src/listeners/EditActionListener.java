package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.StudentiIzmenaDialog;
import view.MainFrame;
import view.PredmetiDodajDialog;
import view.ProfesoriIzmenaDialog;
import view.ProfesoriJTable;
import view.StudentiJTable;

public class EditActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			if(StudentiJTable.getInstance().getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "Odaberite studenta!");
			}
			else {
				StudentiIzmenaDialog.getInstance().refreshStudentPanel();
				StudentiIzmenaDialog.getInstance().setVisible(true);
				StudentiIzmenaDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
			}
		}
		else if(MainFrame.getInstance().getSelectedIndex() == 1) {
			if(ProfesoriJTable.getInstance().getSelectedRow() == -1){
				String message = MainFrame.getInstance().getResourceBundle().getString("invalidProfesor");
				JOptionPane.showMessageDialog(null, message);
			}
			else {
				ProfesoriIzmenaDialog.getInstance().refreshProfesorPanel();
				ProfesoriIzmenaDialog.getInstance().setVisible(true);
				ProfesoriIzmenaDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
			}
		}
		else if(MainFrame.getInstance().getSelectedIndex() == 2) {
			if(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow()==-1){
				JOptionPane.showMessageDialog(null, "Odaberite predmet!");
			}
			else {
				PredmetiDodajDialog.getInstance();
				PredmetiDodajDialog.setMode(false);
				PredmetiDodajDialog.getInstance().refreshPredmetPanel();
				PredmetiDodajDialog.getInstance().setVisible(true);
			}
		}

	}

}
