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
	
	public void dodajStudenta() {
		BazaStudenta.getInstance().dodajStudenta("Nikola", "Aleksic",  Calendar.getInstance(), "Zmaj Jovina 16/8",
				"aleksamigojoni@stcable.rs", "069-731235", "RA-24-2018", 2018,3,Status.B, 9.24, new ArrayList<Ocena>(), 
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
