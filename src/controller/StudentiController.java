package controller;

import java.util.ArrayList;
import java.util.Calendar;

import model.BazaStudenta;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.MainFrame;

public class StudentiController {
	private static StudentiController instance=null;
	
	public  static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private  StudentiController() {}
	
	public void dodajStudenta(String ime, String prezime, Calendar datumRodjenja, String adresa, String email, String brojTelefona,
			String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status) {
		
		BazaStudenta.getInstance().dodajStudenta(ime, prezime,  datumRodjenja, adresa,
				email, brojTelefona, brojIndexa, godinaUpisa,trenutnaGodinaStudija,status, 0, new ArrayList<Ocena>(), 
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
