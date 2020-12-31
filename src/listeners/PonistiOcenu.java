package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.OceneController;
import view.MainFrame;
import view.PolozeniPredmetiPanel;
import view.StudentiIzmenaDialog;

public class PonistiOcenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedRow=PolozeniPredmetiPanel.getInstance().getTabelaPolozenihPredmeta().getSelectedRow();
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(null, "Odaberite ocenu!");
			return;
		}
		int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da poništite ocenu?",
				"Poništavnje ocene", JOptionPane.YES_NO_OPTION);
		
		if(code==JOptionPane.YES_OPTION) {
			//Ocena ocena=OceneJTable.getInstance();
			OceneController.getInstance().ponistiOcenu(selectedRow);
			StudentiIzmenaDialog.getInstance().refreshStudentPanel();
			MainFrame.getInstance().azurirajPrikaz();
		}
	}

}
