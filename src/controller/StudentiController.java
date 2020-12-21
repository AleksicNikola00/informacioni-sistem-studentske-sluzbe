package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaStudenta;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.MainFrame;
import view.StudentiDodajDialog;

public class StudentiController {
	private static StudentiController instance=null;
	
	public  static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private  StudentiController() {}
	
	public void dodajStudenta() {
		ArrayList<JTextField> txtFieldArray=StudentiDodajDialog.getTxtFields();
		String[] datum=txtFieldArray.get(2).getText().split("\\.", 4);
		String ime,prezime,adresa,brIndexa,brTelefona,email;
		int godinaUpisa,trenutnaGodinaStudija;
		Status status;
		JComboBox<String> trenutnaGodinaComboBox=StudentiDodajDialog.getTrenutnaGodinaComboBox();
		JComboBox<String> nacinFinasiranjaComboBox=StudentiDodajDialog.getNacinFinansiranjaComboBox();
		
		ime=txtFieldArray.get(0).getText();
		prezime=txtFieldArray.get(1).getText();
		adresa=txtFieldArray.get(3).getText();
		brTelefona=txtFieldArray.get(4).getText();
		email=txtFieldArray.get(5).getText();
		brIndexa=txtFieldArray.get(6).getText();
		godinaUpisa=Integer.parseInt(txtFieldArray.get(7).getText());
		if(nacinFinasiranjaComboBox.getSelectedIndex()==0)
			status=Status.B;
		else
			status=Status.S;
		
		if(trenutnaGodinaComboBox.getSelectedItem().equals("I (prva)"))
			trenutnaGodinaStudija=1;
		else if(trenutnaGodinaComboBox.getSelectedItem().equals("II (druga)"))
			trenutnaGodinaStudija=2;
		else if(trenutnaGodinaComboBox.getSelectedItem().equals("III (treća)"))
			trenutnaGodinaStudija=3;
		else if(trenutnaGodinaComboBox.getSelectedItem().equals("IV (četvrta)"))
			trenutnaGodinaStudija=4;
		else
			trenutnaGodinaStudija=5;
		
		BazaStudenta.getInstance().dodajStudenta(ime, prezime,new GregorianCalendar(Integer.parseInt(datum[2]),Integer.parseInt(datum[1]), Integer.parseInt(datum[0])),
				adresa,brTelefona, email, brIndexa, godinaUpisa,trenutnaGodinaStudija,status, 0, new ArrayList<Ocena>(), 
				new ArrayList<Predmet>());
		//arzuriraj prikaz
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student =BazaStudenta.getInstance().getRow(rowSelectedIndex);
		BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndexa());
		//arzuriraj prikaz
		MainFrame.getInstance().azurirajPrikaz();
	}
	
}
