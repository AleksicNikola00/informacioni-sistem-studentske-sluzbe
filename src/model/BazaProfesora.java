package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}


	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;

	private BazaProfesora() {
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("TITULA");
	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Pero", "Peri�", "Docent", "Doktor nauka", LocalDate.of(1990, 3, 28), "Ulica Vojvode Stepe", 
				"064-152-4141", "mikamikic@gmail.com", "Ulica cara Du�ana", "A65F21GH0"));
		profesori.add(new Profesor("Marko", "Markovi�", "Vanredni profesor", "Doktor nauka", LocalDate.of(1990, 5, 25), "Ulica Alekse �anti�a", 
				"064-953-1461", "markomarkovic@gmail.com", "Ulica cara Du�ana", "H568F13D6"));
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getZvanje();
		case 3:
			return profesor.getTitula();
		default:
			return null;
		}
	}

	public void dodajProfesora(String ime, String prezime, String zvanje, String titula, LocalDate datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte) {
		this.profesori.add(new Profesor(ime, prezime, zvanje, titula, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brojLicneKarte));
	}

}
