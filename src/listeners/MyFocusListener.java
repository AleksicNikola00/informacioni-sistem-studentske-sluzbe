package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Validate;
import view.MainFrame;

public class MyFocusListener implements FocusListener {
	
	private  ArrayList<JTextField> txtFieldArray;//niz textFieldova iz dijaloga
	private  JButton btnPotvrdi;//button na koji dodajemo entitet u listu u slucaju da su polja sa textom validna
	private JButton btnOdustani;//button nakon kojeg ne ispisujemo greske pri validaciji
	
	public MyFocusListener(ArrayList<JTextField> txtFieldArray,JButton btnPotvrdi,JButton btnOdustani){
		this.txtFieldArray=txtFieldArray;
		this.btnPotvrdi=btnPotvrdi;
		this.btnOdustani=btnOdustani;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		//System.out.println(arg0.getComponent().getName());
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub	
		JTextField txt = (JTextField) arg0.getComponent();
		String name=txt.getName();
		String s=txt.getText().trim();//text unutar polja nad kojim se pozvao focus lost
		int length=s.length();//duzina texta unutar polja
		switch (name) {
		case "txtSifraPredmeta":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnaSifraPredmeta");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtNazivPredmeta":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanNazivPredmeta");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtESPB":
			if(!Validate.validateESPB(s, length)  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravniESPB");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
			/*
		case "txtProfesor":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				JOptionPane.showMessageDialog(null, "Odaberite predmetnog profesora!");
				btnPotvrdi.setEnabled(false);
			}
			break;*/
		case "txtIme":
			if(!Validate.validateString(s,length) && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnoIme");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtPrz":
			if(!Validate.validateString(s,length)  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnoPrezime");
				JOptionPane.showMessageDialog(null, message);
			}
			break;
		case "datRodj":
			if (!s.matches("([0-9]{2})\\.([0-9]{2})\\.([0-9]{4}).")  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanDatum");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtAdresa":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnaAdresaStanovanja");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtBroj":
			if(!Validate.validatePhoneNumber(s, length)  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanBrojTelefona");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}	
			break;
		case "txtEmail": //https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method  PREUZET REGGEX ODAVDE!
			if (!s.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanEmail");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtIndex":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanBrojIndeksa");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtGodinaUpisa":
			if(!Validate.validateYear(s, length)  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnaGodinaUpisa");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtAdresaKancelarije":
			if(length==0  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravnaAdresaKancelarije");
				JOptionPane.showMessageDialog(null, message);
				btnPotvrdi.setEnabled(false);
			}
			break;
		case "txtBrojLK":
			if(!Validate.validateIDCardNumber(s, length)  && arg0.getOppositeComponent()!=btnOdustani) {
				txt.setText("");
				String message = MainFrame.getInstance().getResourceBundle().getString("neispravanBrojLK");
				JOptionPane.showMessageDialog(null, message);
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