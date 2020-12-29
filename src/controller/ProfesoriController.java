package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.MainFrame;
import view.ProfesoriDodajDialog;
import view.ProfesoriIzmenaDialog;
import view.ProfesoriJTable;


public class ProfesoriController {
	
	private static ProfesoriController instance = null;
	private ArrayList<JTextField> listaTxt;
	private JComboBox<String> zvanjaComboBox;
	//private JComboBox<String> tituleComboBox;
	private String ime, prezime, adresaStan, telefon, email, adresaKanc, brojLK, zvanje, titula;
	private Date datumRodj;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora() {
		loadFromView(true);
		
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, zvanje, titula, datumRodj, 
				adresaStan, telefon, email, adresaKanc, brojLK, new ArrayList<Predmet>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izmeniProfesora(int rowSelectedIndex){
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Profesor profesor = this.getProfesor(rowSelectedIndex);
		loadFromView(false);
		
		BazaProfesora.getInstance().izmeniProfesora(ime, prezime, zvanje, titula, datumRodj, 
				adresaStan, telefon, email, adresaKanc, profesor.getBrojLicneKarte(), new ArrayList<Predmet>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public Profesor getProfesor(int rowSelectedIndex) {
		String ime=(String)ProfesoriJTable.getInstance().getValueAt(rowSelectedIndex, 0);
		String prezime=(String)ProfesoriJTable.getInstance().getValueAt(rowSelectedIndex, 1);
		return BazaProfesora.getInstance().getProfesor(ime, prezime);
	}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Profesor profesor=getProfesor(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(profesor.getBrojLicneKarte());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void loadFromView(boolean mode) {
		if(!mode) {
			listaTxt = ProfesoriIzmenaDialog.getInstance().getFirstPan().getListaTxt();
			zvanjaComboBox = ProfesoriIzmenaDialog.getInstance().getFirstPan().getZvanjaComboBox();
			//tituleComboBox = ProfesoriIzmenaDialog.getInstance().getFirstPan().getTituleComboBox();
		}else {
			listaTxt = ProfesoriDodajDialog.getInstance().getPanelDodaj().getListaTxt();
			zvanjaComboBox = ProfesoriDodajDialog.getInstance().getPanelDodaj().getZvanjaComboBox();
			//tituleComboBox = ProfesoriDodajDialog.getInstance().getPanelDodaj().getTituleComboBox();
		}
		
		ime = listaTxt.get(0).getText();
		prezime = listaTxt.get(1).getText();
		try {
			datumRodj = new SimpleDateFormat("dd.mm.yyyy.").parse(listaTxt.get(2).getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		adresaStan = listaTxt.get(3).getText();
		telefon = listaTxt.get(4).getText();
		email = listaTxt.get(5).getText();
		adresaKanc = listaTxt.get(6).getText();
		brojLK = listaTxt.get(7).getText();
		 
		if(zvanjaComboBox.getSelectedItem().equals("Docent"))
			zvanje = "Docent";
		else if(zvanjaComboBox.getSelectedItem().equals("Vanredni profesor"))
			zvanje = "Vanredni profesor";
		else
			zvanje = "Redovni profesor";
		
		titula = "Doktor nauka";
	}
}
