package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class SwitchTxtFieldListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField txtField=(JTextField)arg0.getSource();
		txtField.transferFocus();
	}
	
}
