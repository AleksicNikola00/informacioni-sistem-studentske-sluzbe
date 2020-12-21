package listeners;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfesoriController;
import controller.StudentiController;
import view.MainFrame;
import view.StudentiDodajDialog;

public class AddActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 1)
		{
			ProfesoriController.getInstance().dodajProfesora();
		}else if(MainFrame.getInstance().getSelectedIndex() == 0) 
		{
			StudentiDodajDialog.getInstance().setVisible(true);
		}

	}

}
