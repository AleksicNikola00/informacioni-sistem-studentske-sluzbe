package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MainFrame;
import view.NepolozeniPredmetiPanel;
import view.StudentiIzmenaDialog;
import view.UpisOceneDialog;

public class UpisOceneListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow() == -1) {
			String message = MainFrame.getInstance().getResourceBundle().getString("invalidPredmet");
			JOptionPane.showMessageDialog(null, message);
		}
		else {
			UpisOceneDialog.getInstance();
			UpisOceneDialog.getInstance().refreshUpisOceneDialog();
			UpisOceneDialog.getInstance().setVisible(true);
			UpisOceneDialog.getInstance().setLocationRelativeTo(StudentiIzmenaDialog.getInstance());
		}
	}
}
