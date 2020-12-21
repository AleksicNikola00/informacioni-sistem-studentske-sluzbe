package view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFocusListener implements FocusListener {
	
	private static ArrayList<JTextField> txtFieldArray=null;//niz textFieldova iz dijaloga
	private static JButton btnPotvrdi=null;//button na koji dodajemo entitet u listu u slucaju da su polja sa textom validna
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(txtFieldArray==null)// da ne bismo vise puta bespotrebno setovali niz text fildova na istu vrednost
			  txtFieldArray=StudentiDodajDialog.getTxtFields();
		
		if(btnPotvrdi==null)
			btnPotvrdi=StudentiDodajDialog.getBtn();
		
		JTextField txt = (JTextField) arg0.getComponent();
		String name=txt.getName();
		String s=txt.getText().trim();//text unutar polja nad kojim se pozvao focus lost
		int length=s.length();//duzina texta unutar polja
		switch (name) {
		case "txtIme":
			if(!validateString(s,length)) {
				JOptionPane.showMessageDialog(null, "Neispravno ime!");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtPrz":
			if(!validateString(s,length)) {
				JOptionPane.showMessageDialog(null, "Neispravno prezime!");
				txt.setText("");
			}
			break;
		case "datRodj":
			if (!s.matches("([0-9]{2})\\.([0-9]{2})\\.([0-9]{4}).")) {
				JOptionPane.showMessageDialog(null, "Neispravan format datuma! \nVALIDAN FORMAT: (dd.mm.yyyy.)");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtAdresa":
			if(length==0) {
				JOptionPane.showMessageDialog(null, "Neispravna adresa!");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtBroj":
			if(!validatePhoneNumber(s, length)) {
				JOptionPane.showMessageDialog(null, "Neispravan broj telefona!");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}	
			break;
		case "txtEmail": //https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method  PREUZET REGGEX ODAVDE!
			if (!s.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
				JOptionPane.showMessageDialog(null, "Neispravan format emaila!");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtIndex":
			if(length==0) {
				JOptionPane.showMessageDialog(null, "Neispravan broj indexa!");
				txt.setText("");
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtGodinaUpisa":
			if(!validateYear(s, length)) {
				JOptionPane.showMessageDialog(null, "Neispravna godina upisa!");
				txt.setText("");
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
	
	private boolean validateYear(String s,int length) {
		boolean valid=true;
		if (length == 0) {
			valid=false;
		}
		
		try {
			int brojGodina=Integer.parseInt(s);
			if(brojGodina<1900 || brojGodina>2021)
				valid=false;
		}
		catch(NumberFormatException e) {
			valid=false;
		}
		return valid;
	}
	
	private boolean validateString(String s,int length) {
		boolean valid=true;
		if (length == 0) {
			valid=false;
		}
		else if (Character.isUpperCase(s.charAt(0)) == false) {
			valid=false;
		}
		for (int i = 1; i < length; i++) {
	        if (Character.isLowerCase(s.charAt(i)) == false) 
	        	valid=false;
	        
	    }
		return valid;
	}
	
	private boolean validatePhoneNumber(String s,int length) {
		boolean valid=true;
		if (length < 9 || length > 13) {
			valid=false;
		}
		for (int i = 0; i < length; i++) {
	        if (Character.isDigit(s.charAt(i)) == false) {
	        	valid=false;
	        }
	    }
		return valid;
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