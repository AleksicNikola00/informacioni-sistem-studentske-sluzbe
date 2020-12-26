package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.IzmenaStudentaDialog;
import view.MainFrame;
import view.PredmetiDodajDialog;
import view.PredmetiJTable;
import view.StudentiJTable;

public class EditActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			if(StudentiJTable.getInstance().getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null, "Odaberite studenta!");
			else {
				IzmenaStudentaDialog.getInstance().refreshStudentPanel();
				IzmenaStudentaDialog.getInstance().setVisible(true);
				IzmenaStudentaDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
			}
		}else if(MainFrame.getInstance().getSelectedIndex() == 2) {
			if(PredmetiJTable.getInstance().getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null, "Odaberite predmet!");
			else {
				PredmetiDodajDialog.getInstance();
				PredmetiDodajDialog.setMode(false);
				PredmetiDodajDialog.getInstance().refreshPredmetPanel();
				PredmetiDodajDialog.getInstance().setVisible(true);
			}
		}

	}

}
