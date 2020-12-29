package controller;

import java.util.ArrayList;
import java.util.Date;

import model.BazaOcena;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.OceneJTable;
import view.StudentiJTable;

public class OceneController {
	
	private static OceneController instance = null;
	//Student student, Predmet predmet, int ocena, Date datumPolaganjaIspita
	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datumPolaganjaIspita;
	
	public static OceneController getInstance() {
		if (instance == null) {
			instance = new OceneController();
		}
		return instance;
	}
	
	public void refreshOcene(ArrayList<Ocena> ocene) {
		BazaOcena.getInstance().setOcene(ocene);
	}
	
	public void dodajOcenu() {
		BazaOcena.getInstance().dodajOcenu(student, predmet, ocena, datumPolaganjaIspita);
	}
	
	//public void ponistiOcenu(String brIndexa,String sifraPredmeta)
	public void ponistiOcenu(int selectedRow) {
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		Student student=StudentiController.getInstance().getStudent(selectedIndex);
		String sifraPredmeta=(String)OceneJTable.getInstance().getValueAt(selectedRow, 0);
		BazaOcena.getInstance().ponistiOcenu(student.getBrojIndexa(), sifraPredmeta);
	}
	
}
