package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.BazaProfesora;
import model.Profesor;
import view.PredmetiDodajDialog;

public class DodajPredmetuProfesoraListener implements ActionListener {

	private MyFocusListener myFocusListener;
	
	public DodajPredmetuProfesoraListener(MyFocusListener myFocusListener) {
		this.myFocusListener=myFocusListener;
	}
	//https://stackoverflow.com/questions/13334198/java-custom-buttons-in-showinputdialog  
	//http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Add_String_item_to_JList.htm   
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
			
		Object[] buttons= {"Potvrdi", "Odustani"};
		ArrayList<Profesor> listaProfesora=BazaProfesora.getInstance().getProfesori();
		DefaultListModel<String> dlm=new DefaultListModel<String>();
		JList<String> list =new JList<String>(dlm);
		
		for (Profesor profesor : listaProfesora) {
			String imePrezime=profesor.getIme()+" "+profesor.getPrezime();
			dlm.addElement(imePrezime);
		}
		
		
		if(list.getModel().getSize()==0) {
			JOptionPane.showMessageDialog(null, "Nema dostupnih profesora!");
			return;
		}
			
		JScrollPane scrollPane= new JScrollPane(list);
		int result=JOptionPane.showOptionDialog(PredmetiDodajDialog.getInstance(), scrollPane, "Odaberite profesora!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, buttons, null);
		if (result == JOptionPane.YES_OPTION && list.getSelectedValue()!=null){
           PredmetiDodajDialog.getTxtProfesor().setText(list.getSelectedValue());
           PredmetiDodajDialog.getBtnPlus().setEnabled(false);
           PredmetiDodajDialog.getBtnMinus().setEnabled(true);
           if(myFocusListener.validateTxtFields())
        	   PredmetiDodajDialog.getBtn().setEnabled(true);
		}
		
	}
	
}
