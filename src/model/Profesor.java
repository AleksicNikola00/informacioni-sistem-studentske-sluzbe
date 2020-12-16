package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Profesor {

	private String prezime;
	private String ime;
	private Calendar datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<String> predmeti = new ArrayList<String>();
	
	public Profesor(String prezime, String ime, Calendar datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje,
			ArrayList<String> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
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

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<String> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<String> predmeti) {
		this.predmeti = predmeti;
	}
	
}
