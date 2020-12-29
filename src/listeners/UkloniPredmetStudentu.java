package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.PredmetiController;
import view.MainFrame;
import view.NepolozeniPredmetiPanel;


public class UkloniPredmetStudentu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int index=NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(null, "Odaberite predmet!");
			return;
		}
		int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da uklonite predmet?",
				"Uklanjanje predmeta", JOptionPane.YES_NO_OPTION);
		
		if(code==JOptionPane.YES_OPTION) {
			PredmetiController.getInstance().izbrisiPredmet(index);
			NepolozeniPredmetiPanel.getInstance().refreshPanel();
		}
		
	}

}
