package view;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfesoriController;
import controller.StudentiController;

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
			
			//StudentiController.getInstance().dodajStudenta();
		}

	}

}
