package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Validate;

public class MyFocusListener implements FocusListener {
	
	private static ArrayList<JTextField> txtFieldArray;//niz textFieldova iz dijaloga
	private static JButton btnPotvrdi;//button na koji dodajemo entitet u listu u slucaju da su polja sa textom validna
	
	public MyFocusListener(ArrayList<JTextField> txtFieldArray,JButton btnPotvrdi){
		MyFocusListener.txtFieldArray=txtFieldArray;
		MyFocusListener.btnPotvrdi=btnPotvrdi;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub	
		JTextField txt = (JTextField) arg0.getComponent();
		String name=txt.getName();
		String s=txt.getText().trim();//text unutar polja nad kojim se pozvao focus lost
		int length=s.length();//duzina texta unutar polja
		switch (name) {
		case "txtIme":
			if(!Validate.validateString(s,length)) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravno ime!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtPrz":
			if(!Validate.validateString(s,length)) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravno prezime!");
			}
			break;
		case "datRodj":
			if (!s.matches("([0-9]{2})\\.([0-9]{2})\\.([0-9]{4}).")) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravan format datuma! \nVALIDAN FORMAT: (dd.mm.yyyy.)");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtAdresa":
			if(length==0) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravna adresa stanovanja!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtBroj":
			if(!Validate.validatePhoneNumber(s, length)) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravan broj telefona!");
				btnPotvrdi.setEnabled(false);
			}	
			break;
		case "txtEmail": //https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method  PREUZET REGGEX ODAVDE!
			if (!s.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravan format emaila!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtIndex":
			if(length==0) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravan broj indexa!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtGodinaUpisa":
			if(!Validate.validateYear(s, length)) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravna godina upisa!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtAdresaKancelarije":
			if(length==0) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravna adresa kancelarije!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtBrojLK":
			if(!Validate.validateIDCardNumber(s, length)) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Neispravan broj lične karte!");
				btnPotvrdi.setEnabled(false);
			}
			break;
		default:
			break;
		}
		//provera ako su sva polja validna tada dozvoli dugme
		if(validateTxtFields())
			btnPotvrdi.setEnabled(true);
	}

	public boolean validateTxtFields() {
		boolean valid=true;
		for (JTextField jTextField : txtFieldArray) {
			if(jTextField.getText().equals("")) {
				valid=false;
				break;
			}
		}
		return valid;
	}
	
}