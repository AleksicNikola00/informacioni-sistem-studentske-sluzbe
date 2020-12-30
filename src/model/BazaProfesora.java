package model;


import java.util.ArrayList;
import java.util.Date;

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
		this.profesori = new ArrayList<Profesor>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("TITULA");
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
	
	
	public Profesor getProfesor(String ime,String prezime) {
		for (Profesor profesor : profesori) {
			if(profesor.getIme().equals(ime) && profesor.getPrezime().equals(prezime)) 
				return profesor;
		}
		return null;
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

	public void dodajProfesora(String ime, String prezime, String zvanje, String titula, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, ArrayList<Predmet> predmeti ) {
		this.profesori.add(new Profesor(ime, prezime, zvanje, titula, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brojLicneKarte, predmeti));
	}
	
	public void izmeniProfesora(String staroIme, String staroPrezime, String ime, String prezime, String zvanje, String titula, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, ArrayList<Predmet> predmeti) {
		for (Profesor profesor : profesori) {
				if(profesor.getIme().equals(staroIme) && profesor.getPrezime().equals(staroPrezime)) {
					profesor.setIme(ime);
					profesor.setPrezime(prezime);
					profesor.setDatumRodjenja(datumRodjenja);
					profesor.setAdresaStanovanja(adresaStanovanja);
					profesor.setTelefon(telefon);
					profesor.setEmail(email);
					profesor.setAdresaKancelarije(adresaKancelarije);
					profesor.setBrojLicneKarte(brojLicneKarte);
					profesor.setZvanje(zvanje);
					profesor.setTitula(titula);
					profesor.setPredmeti(predmeti);
				}
		}
	}
	
	public void izbrisiProfesora(String ime, String prezime) {
		for (Profesor profesor : profesori) {
			if(profesor.getIme().equals(ime) && profesor.getPrezime().equals(prezime)) {
				profesori.remove(profesor);
				break;
			}
		}
	}

}
