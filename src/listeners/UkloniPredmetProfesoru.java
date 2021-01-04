package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.PredmetePredajeProfesorPanel;

public class UkloniPredmetProfesoru implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int index = PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(null, "Odaberite predmet!");
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Predmet mora imati profesora, izaberite drugog profesora i dodajte mu predmet!");
		}
		//int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da uklonite predmet?",
		//		"Ukloni predmet", JOptionPane.YES_NO_OPTION);
		
		/*if(code==JOptionPane.YES_OPTION) {
			PredmetiController.getInstance().izbrisiPredmet(index);
			PredmetePredajeProfesorPanel.getInstance().refreshPanel();
		}*/
	}

}
