package model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Profesor {

	private String prezime;
	private String ime;
	private Calendar datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private JPanel panelZvanja;
	private JPanel panelTitule;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private ArrayList<Predmet> predmeti;
	
	public Profesor(String prezime, String ime, Calendar datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, ArrayList<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.predmeti = predmeti;
		panelZvanja = new JPanel();
		panelTitule = new JPanel();
		comboZvanja();
		comboTitule();
	}

	private void comboZvanja() {
		String[] zvanja = {"Docent", "Vanredni profesor", "Redovni Profesor"};
		final JComboBox<String> combo = new JComboBox<String>(zvanja);
		panelZvanja.add(combo);
		combo.setSelectedIndex(0);
	}
	
	private void comboTitule() {
		String[] titule = {"Doktor Nauka"};
		final JComboBox<String> combo = new JComboBox<String>(titule);
		panelTitule.add(combo);
		combo.setSelectedIndex(0);
	}
	
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Calendar getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Calendar datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
}
