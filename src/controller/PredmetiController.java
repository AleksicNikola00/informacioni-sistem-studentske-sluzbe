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
import view.NepolozeniPredmetiPanel;
import view.PredmetiDodajDialog;
import view.StudentiJTable;

public class PredmetiController {
private static PredmetiController instance = null;
	

	private ArrayList<JTextField> txtFieldArray;
	private JComboBox<Integer> godinaStudijaComboBox;
	private JComboBox<String> semestarComboBox;
	private String sifraPredmeta,nazivPredmeta,semestar;
	private int godinaStudija,brojESPB;
	private String[] imePrezime;
	private Profesor profesor;
	private boolean mode;
	
	public boolean isMode() {
		return mode;
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	public void changeList(boolean mode) {
		this.mode=mode;
		if(!mode) {
			int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
			Student student=StudentiController.getInstance().getStudent(selectedIndex);
			BazaPredmeta.getInstance().setNepolozeniPredmeti(student.getSpisakNepolozenihIspita());
		}
		BazaPredmeta.getInstance().setCurrentList(mode);
	}
	
	public void dodajPredmet(){
		loadFromView();
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, brojESPB,
				new ArrayList<Student>(), new ArrayList<Student>());
		MainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public Predmet getPredmet(int rowSelectedIndex) {
		String sifra;
		if(mode)
			 sifra=(String)MainFrame.getInstance().getTabelaPredmeta().getValueAt(rowSelectedIndex, 0);
		else
			sifra=(String) NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getValueAt(rowSelectedIndex, 0);
		
		return BazaPredmeta.getInstance().getPredmet(sifra);
	}
	
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet=getPredmet(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifraPredmeta());
		
		if(mode) {
			
			MainFrame.getInstance().azurirajPrikaz();
		}
		else {
			OceneController.getInstance().setPredmet(predmet);
		}
			
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
