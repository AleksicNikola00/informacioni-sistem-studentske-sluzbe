package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfesoriController;
import controller.StudentiController;
import view.MainFrame;
import view.ProfesoriJTable;
import view.StudentiJTable;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 0) {
			StudentiController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
		}else if(MainFrame.getInstance().getSelectedIndex() == 1) {
			ProfesoriController.getInstance().izbrisiProfesora(ProfesoriJTable.getInstance().getSelectedRow());
		}
		
	}

}
