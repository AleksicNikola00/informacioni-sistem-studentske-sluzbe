package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.NepolozeniPredmetiPanel;
import view.StudentiIzmenaDialog;
import view.UpisOceneDialog;

public class UpisOceneListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow() == -1)
			JOptionPane.showMessageDialog(null, "Odaberite predmet!");
		else {
			UpisOceneDialog.getInstance();
			UpisOceneDialog.getInstance().setVisible(true);
			UpisOceneDialog.getInstance().setLocationRelativeTo(StudentiIzmenaDialog.getInstance());
		}
	}
}
