package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.BazaStudenta;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.StudentiIzmenaDialog;
import view.StudentiJTable;
import view.MainFrame;
import view.StudentiDodajDialog;


public class StudentiController {
	private static StudentiController instance=null;
	
	//
	private ArrayList<JTextField> txtFieldArray;
	private String ime,prezime,adresa,brIndexa,brTelefona,email;
	private Date datum;
	private Status status;
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
		
		String brIndex=(String)StudentiJTable.getInstance().getValueAt(rowSelectedIndex, 0);
		BazaStudenta.getInstance().izbrisiStudenta(brIndex);
		//arzuriraj prikaz
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public Student getStudent(int rowSelectedIndex) {
		String brIndex=(String)StudentiJTable.getInstance().getValueAt(rowSelectedIndex, 0);
		return BazaStudenta.getInstance().getStudentIndex(brIndex);
	}
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		String brIndex=(String)StudentiJTable.getInstance().getValueAt(rowSelectedIndex, 0);
		//
		loadFromView(false);
		//
		BazaStudenta.getInstance().izmeniStudenta(brIndex, ime, prezime,datum,
				adresa,brTelefona, email, brIndexa, godinaUpisa,trenutnaGodinaStudija,status, 0, new ArrayList<Ocena>(), 
				new ArrayList<Predmet>());
		
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void loadFromView(boolean mode) {//true-add,false-edit
		
		if(!mode) {
			txtFieldArray=StudentiIzmenaDialog.getInstance().getStudentPanel().getListaTxt(); //studentPanel.getListaTxt();
			trenutnaGodinaComboBox=StudentiIzmenaDialog.getInstance().getStudentPanel().getTrenutnaGodinaComboBox();
			 nacinFinasiranjaComboBox=StudentiIzmenaDialog.getInstance().getStudentPanel().getNacinFinasiranjaComboBox();
		}else {
			txtFieldArray=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getListaTxt();
			trenutnaGodinaComboBox=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getTrenutnaGodinaComboBox();
			nacinFinasiranjaComboBox=StudentiDodajDialog.getInstance().getStudentPanelDodaj().getNacinFinasiranjaComboBox();
		}
		
		ime=txtFieldArray.get(0).getText();
		//String datum[]=txtFieldArray.get(2).getText().split(".");
		try {
			datum=new SimpleDateFormat("dd.mm.yyyy.").parse(txtFieldArray.get(2).getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
