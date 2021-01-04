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
import view.PredmetePredajeProfesorPanel;
import view.PredmetiDodajDialog;
import view.ProfesoriJTable;
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
	private int mode; // 1-svi, 2-nepolozeniStudent, 3-predajeProfesor
	
	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	public void changeList(int mode) {
		this.mode=mode;
		if(mode == 2) {
			int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
			Student student=StudentiController.getInstance().getStudent(selectedIndex);
			BazaPredmeta.getInstance().setNepolozeniPredmeti(student.getSpisakNepolozenihIspita());
			BazaPredmeta.getInstance().setCurrentList(mode);
		}
		else if(mode == 1)
			BazaPredmeta.getInstance().setCurrentList(mode);
		else if(mode == 3) {
			int selectedIndex = ProfesoriJTable.getInstance().getSelectedRow();
			Profesor profesor = ProfesoriController.getInstance().getProfesor(selectedIndex);
			BazaPredmeta.getInstance().setPredmetiKojeProfesorPredaje(profesor.getPredmeti());
			BazaPredmeta.getInstance().setCurrentList(mode);
		}
	}
	
	public void dodajPredmet(){
		loadFromView();
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, brojESPB,
				new ArrayList<Student>(), new ArrayList<Student>());
		MainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public Predmet getPredmet(int rowSelectedIndex) {
		String sifra = new String();
		if(mode == 1)
			sifra=(String)MainFrame.getInstance().getTabelaPredmeta().getValueAt(rowSelectedIndex, 0);
		else if(mode == 2)
			sifra=(String) NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getValueAt(rowSelectedIndex, 0);
		else if(mode == 3)
			sifra=(String) PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getValueAt(rowSelectedIndex, 0);
		return BazaPredmeta.getInstance().getPredmet(sifra);
	}
	
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Predmet predmet=getPredmet(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifraPredmeta());
		
		Profesor profesor = BazaProfesora.getInstance().getProfesor(predmet.getProfesor().getIme(), predmet.getProfesor().getPrezime());
		profesor.getPredmeti().remove(predmet);
		
		if(mode == 1) 
			MainFrame.getInstance().azurirajPrikaz();
		else if(mode == 2)
			OceneController.getInstance().setPredmet(predmet);
			
	}
	
	
	public void izmeniPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Predmet predmet = getPredmet(rowSelectedIndex);
		predmet.getProfesor().getPredmeti().remove(predmet);
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
			 if(semestarComboBox.getSelectedItem().equals(MainFrame.getInstance().getResourceBundle().getString("letnji")))
				 semestar = "letnji";
			 else
				 semestar = "zimski";
			 godinaStudija= godinaStudijaComboBox.getSelectedIndex()+1;
			 brojESPB=Integer.parseInt(txtFieldArray.get(2).getText());
			 imePrezime=txtFieldArray.get(3).getText().split(" ");
			 profesor=BazaProfesora.getInstance().getProfesor(imePrezime[0], imePrezime[1]);
	}
	
	public void bazaPredmetaChangeLanguage() {
		MainFrame.getInstance().getTabelaPredmeta().getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("sifraPredmeta"));
		MainFrame.getInstance().getTabelaPredmeta().getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nazivPredmeta"));
		MainFrame.getInstance().getTabelaPredmeta().getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("espb"));
		MainFrame.getInstance().getTabelaPredmeta().getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("godina"));
		MainFrame.getInstance().getTabelaPredmeta().getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("semestar"));
		NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("sifraPredmeta"));
		NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nazivPredmeta"));
		NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("espb"));
		NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("godina"));
		NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("semestar"));
		PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("sifraPredmeta"));
		PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nazivPredmeta"));
		PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("espb"));
		PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("godina"));
		PredmetePredajeProfesorPanel.getInstance().getPredmetiKojeProfesorPredaje().getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("semestar"));	
	}
}
