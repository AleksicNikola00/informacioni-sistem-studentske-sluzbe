package model;


import java.util.ArrayList;
import java.util.Calendar;


public class Student {
	
	public enum Status{B,S}//B-budzet S-samofinansiranje
	
	private String ime;
	private String prezime;
	private Calendar datumRodjenja;
	private String adresa;
	private String email;
	private int brojTelefona;
	private String brojIndexa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	ArrayList<Ocena> spisakPolozenihIspita;
	ArrayList<Predmet> spisakNepolozenihIspita;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Student(String ime, String prezime, Calendar datumRodjenja, String adresa, String email, int brojTelefona,
			String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosecnaOcena,
			ArrayList<Ocena> spisakPolozenihIspita, ArrayList<Predmet> spisakNepolozenihIspita) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.email = email;
		this.brojTelefona = brojTelefona;
		this.brojIndexa = brojIndexa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPolozenihIspita = spisakPolozenihIspita;
		this.spisakNepolozenihIspita = spisakNepolozenihIspita;
	}





	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Calendar getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Calendar datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(int brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getBrojIndexa() {
		return brojIndexa;
	}
	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public ArrayList<Ocena> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}
	public void setSpisakPolozenihIspita(ArrayList<Ocena> spisakPolozenihIspita) {
		this.spisakPolozenihIspita = spisakPolozenihIspita;
	}
	public ArrayList<Predmet> getSpisakNepolozenihIspita() {
		return spisakNepolozenihIspita;
	}
	public void setSpisakNepolozenihIspita(ArrayList<Predmet> spisakNepolozenihIspita) {
		this.spisakNepolozenihIspita = spisakNepolozenihIspita;
	}
	
	
}
