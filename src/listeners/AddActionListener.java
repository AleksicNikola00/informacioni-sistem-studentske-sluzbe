package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.PredmetiDodajDialog;
import view.ProfesoriDodajDialog;
import view.StudentiDodajDialog;

public class AddActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 1)
		{
			ProfesoriDodajDialog.getInstance().setVisible(true);
			ProfesoriDodajDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
		}else if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			StudentiDodajDialog.getInstance().setVisible(true);
			StudentiDodajDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
		}else if(MainFrame.getInstance().getSelectedIndex() == 2) {
			PredmetiDodajDialog.getInstance();
			PredmetiDodajDialog.setMode(true);
			PredmetiDodajDialog.getInstance().refreshPredmetPanel();
			PredmetiDodajDialog.getInstance().setVisible(true);
			PredmetiDodajDialog.getInstance().setLocationRelativeTo(MainFrame.getInstance());
		}

	}

}
