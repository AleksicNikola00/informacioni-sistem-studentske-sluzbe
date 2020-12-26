package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.StudentiController;
import view.MainFrame;
import view.StudentiJTable;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(MainFrame.getInstance().getSelectedIndex() == 0) {
			StudentiController.getInstance().izbrisiStudenta(StudentiJTable.getInstance().getSelectedRow());
		}
		
	}

}
