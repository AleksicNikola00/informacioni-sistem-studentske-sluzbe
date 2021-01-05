package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.PredmetiController;
import controller.StudentiController;
import model.Predmet;
import view.MainFrame;
import view.NepolozeniPredmetiPanel;
import view.StudentiJTable;


public class UkloniPredmetStudentu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int index=NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow();
		int studentIndex=StudentiJTable.getInstance().getSelectedRow();
		if(index==-1) {
			String message = MainFrame.getInstance().getResourceBundle().getString("invalidPredmet");
            JOptionPane.showMessageDialog(null, message);
			return;
		}
		
		String message = MainFrame.getInstance().getResourceBundle().getString("ukloniPredmetMsg");
        String title = MainFrame.getInstance().getResourceBundle().getString("ukloniPredmetTitle");
		int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), message,title, JOptionPane.YES_NO_OPTION);
		
		if(code==JOptionPane.YES_OPTION) {
			Predmet predmet=PredmetiController.getInstance().getPredmet(index);
			predmet.getStudentiKojiNisuPoloziliPredmet().remove(StudentiController.getInstance().getStudent(studentIndex));
			//PredmetiController.getInstance().izbrisiPredmet(index);
			NepolozeniPredmetiPanel.getInstance().refreshPanel();
		}
		
	}

}
