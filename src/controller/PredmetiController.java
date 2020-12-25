package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenta;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.MainFrame;
import view.PredmetiDodajDialog;

public class PredmetiController {
private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	public void dodajPredmet(){
		/*
		dodajPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaStudija,
				Profesor profesor, int brojESPB, ArrayList<Student> studentiKojiSuPoloziliPredmet,
				ArrayList<Student> studentiKojiNisuPoloziliPredmet)
		*/
		ArrayList<JTextField> txtFieldArray=PredmetiDodajDialog.getTxtFields();
		JComboBox<Integer> godinaStudijaComboBox=PredmetiDodajDialog.getGodinaStudijaComboBox();
		JComboBox<String> semestarComboBox= PredmetiDodajDialog.getSemestarComboBox();
		String sifraPredmeta=txtFieldArray.get(0).getText();
		String nazivPredmeta=txtFieldArray.get(1).getText();
		String semestar=(String)semestarComboBox.getSelectedItem();
		int godinaStudija= godinaStudijaComboBox.getSelectedIndex()+1;
		int brojESPB=Integer.parseInt(txtFieldArray.get(2).getText());
		String[] imePrezime=txtFieldArray.get(3).getText().split(" ");
		Profesor profesor=BazaProfesora.getInstance().getProfesor(imePrezime[0], imePrezime[1]);
		
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, brojESPB, new ArrayList<Student>(), new ArrayList<Student>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet= BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		//BazaStudenta.getInstance().izbrisiStudenta(predmet.getSifraPredmeta());
		MainFrame.getInstance().azurirajPrikaz();
	}
}
