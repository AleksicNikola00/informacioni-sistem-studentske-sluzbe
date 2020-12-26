package controller;

import java.util.ArrayList;


import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaStudenta;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.IzmenaStudentaDialog;
import view.MainFrame;
import view.StudentiDodajDialog;


public class StudentiController {
	private static StudentiController instance=null;
	
	//
	private ArrayList<JTextField> txtFieldArray;
	private String ime,prezime,adresa,brIndexa,brTelefona,email,datum;
	Status status;
	private JComboBox<String> trenutnaGodinaComboBox;
	private JComboBox<String> nacinFinasiranjaComboBox;
	private int godinaUpisa,trenutnaGodinaStudija;
	//
	public  static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private  StudentiController() {}
	
	public void dodajStudenta() {
		loadFromView(true);
		BazaStudenta.getInstance().dodajStudenta(ime, prezime,datum,
				adresa,email, brTelefona, brIndexa, godinaUpisa,trenutnaGodinaStudija,status, 0, new ArrayList<Ocena>(), 
				new ArrayList<Predmet>());
		//arzuriraj prikaz
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student =BazaStudenta.getInstance().getRow(rowSelectedIndex);
		//System.out.println(student.getBrojIndexa());
		BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndexa());
		//arzuriraj prikaz
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student=BazaStudenta.getInstance().getRow(rowSelectedIndex);
		//
		loadFromView(false);
		//
		BazaStudenta.getInstance().izmeniStudenta(student.getBrojIndexa(), ime, prezime,datum,
				adresa,brTelefona, email, brIndexa, godinaUpisa,trenutnaGodinaStudija,status, 0, new ArrayList<Ocena>(), 
				new ArrayList<Predmet>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void loadFromView(boolean mode) {//true-add,false-edit
		
		if(!mode) {
			txtFieldArray=IzmenaStudentaDialog.getInstance().getStudentPanel().getListaTxt(); //studentPanel.getListaTxt();
			trenutnaGodinaComboBox=IzmenaStudentaDialog.getInstance().getStudentPanel().getTrenutnaGodinaComboBox();
			 nacinFinasiranjaComboBox=IzmenaStudentaDialog.getInstance().getStudentPanel().getNacinFinasiranjaComboBox();
		}else {
			txtFieldArray=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getListaTxt();
			trenutnaGodinaComboBox=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getTrenutnaGodinaComboBox();
			nacinFinasiranjaComboBox=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getNacinFinasiranjaComboBox();
		}
		
		ime=txtFieldArray.get(0).getText();
		datum=txtFieldArray.get(2).getText();
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
		else if(trenutnaGodinaComboBox.getSelectedItem().equals("Master"))
			trenutnaGodinaStudija=5;
		else
			trenutnaGodinaStudija=6;
	}
}
