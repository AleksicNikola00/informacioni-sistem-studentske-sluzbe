package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaProfesora;
import model.Predmet;
import view.MainFrame;
import view.ProfesoriDodajDialog;

public class ProfesoriController {
	
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora() {
		ArrayList<JTextField> txtFieldArray = ProfesoriDodajDialog.getListaTxt();
		String[] datum = txtFieldArray.get(2).getText().split("\\.", 4);
		int day = Integer.parseInt(datum[0]);
		int month = Integer.parseInt(datum[1]);
		int year = Integer.parseInt(datum[2]);
		String ime, prezime, adresaStan, adresaKanc, brLK, email, zvanje, titula, brTel;
		JComboBox<String> zvanjaComboBox = ProfesoriDodajDialog.getZvanjaComboBox();
		
		ime = txtFieldArray.get(0).getText();
		prezime = txtFieldArray.get(1).getText();
		adresaStan = txtFieldArray.get(3).getText();
		brTel = txtFieldArray.get(4).getText();
		email = txtFieldArray.get(5).getText();
		adresaKanc = txtFieldArray.get(6).getText();
		brLK = txtFieldArray.get(7).getText();
		titula = "Doktor nauka";
		
		if(zvanjaComboBox.getSelectedItem().equals("Docent"))
			zvanje = "Docent";
		else if(zvanjaComboBox.getSelectedItem().equals("Vanredni profesor"))
			zvanje = "Vanredni profesor";
		else
			zvanje = "Redovni profesor";
		
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, zvanje, titula, LocalDate.of(year, month, day), 
				adresaStan, brTel, email, adresaKanc, brLK, new ArrayList<Predmet>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
}
