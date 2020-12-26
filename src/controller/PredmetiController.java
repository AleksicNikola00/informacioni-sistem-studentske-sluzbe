package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.MainFrame;
import view.PredmetiDodajDialog;

public class PredmetiController {
private static PredmetiController instance = null;
	

	private ArrayList<JTextField> txtFieldArray;
	private JComboBox<Integer> godinaStudijaComboBox;
	private JComboBox<String> semestarComboBox;
	private String sifraPredmeta,nazivPredmeta,semestar;
	private int godinaStudija,brojESPB;
	private String[] imePrezime;
	private Profesor profesor;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	public void dodajPredmet(){
		loadFromView();
		
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, brojESPB,
				new ArrayList<Student>(), new ArrayList<Student>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		//Predmet predmet= BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		//BazaPredmeta.getInstance().
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	
	public void izmeniPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Predmet predmet=BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		loadFromView();
		BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifraPredmeta(), sifraPredmeta, nazivPredmeta,
				semestar, godinaStudija, profesor, brojESPB, 
				new ArrayList<Student>(), new ArrayList<Student>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	
	public void loadFromView() {
			 txtFieldArray=PredmetiDodajDialog.getTxtFields();
			godinaStudijaComboBox=PredmetiDodajDialog.getGodinaStudijaComboBox();
			 semestarComboBox= PredmetiDodajDialog.getSemestarComboBox();
			 sifraPredmeta=txtFieldArray.get(0).getText();
			 nazivPredmeta=txtFieldArray.get(1).getText();
			 semestar=(String)semestarComboBox.getSelectedItem();
			 godinaStudija= godinaStudijaComboBox.getSelectedIndex()+1;
			 brojESPB=Integer.parseInt(txtFieldArray.get(2).getText());
			 imePrezime=txtFieldArray.get(3).getText().split(" ");
			 profesor=BazaProfesora.getInstance().getProfesor(imePrezime[0], imePrezime[1]);
	}
}
