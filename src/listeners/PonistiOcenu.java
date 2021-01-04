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
			String message = MainFrame.getInstance().getResourceBundle().getString("invalidOcena");
			JOptionPane.showMessageDialog(null, message);
			return;
		}
		String message = MainFrame.getInstance().getResourceBundle().getString("ponistiOcenuMsg");
        String title = MainFrame.getInstance().getResourceBundle().getString("ponistiOcenuTitle");
		int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), message,title, JOptionPane.YES_NO_OPTION);
		
		if(code==JOptionPane.YES_OPTION) {
			//Ocena ocena=OceneJTable.getInstance();
			OceneController.getInstance().ponistiOcenu(selectedRow);
			StudentiIzmenaDialog.getInstance().refreshStudentPanel();
			//MainFrame.getInstance().azurirajPrikaz();
		}
	}

}
