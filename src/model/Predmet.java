package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7906026749908380737L;
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private int godinaStudija;
	private Profesor profesor;
	private int brojESPB;
	private ArrayList<Student> studentiKojiSuPoloziliPredmet;
	private ArrayList<Student> studentiKojiNisuPoloziliPredmet;
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, int godinaStudija,
			Profesor profesor, int brojESPB, ArrayList<Student> studentiKojiSuPoloziliPredmet,
			ArrayList<Student> studentiKojiNisuPoloziliPredmet) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.brojESPB = brojESPB;
		this.studentiKojiSuPoloziliPredmet = studentiKojiSuPoloziliPredmet;
		this.studentiKojiNisuPoloziliPredmet = studentiKojiNisuPoloziliPredmet;
	}
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}

	public ArrayList<Student> getStudentiKojiSuPoloziliPredmet() {
		return studentiKojiSuPoloziliPredmet;
	}

	public void setStudentiKojiSuPoloziliPredmet(ArrayList<Student> studentiKojiSuPoloziliPredmet) {
		this.studentiKojiSuPoloziliPredmet = studentiKojiSuPoloziliPredmet;
	}

	public ArrayList<Student> getStudentiKojiNisuPoloziliPredmet() {
		return studentiKojiNisuPoloziliPredmet;
	}

	public void setStudentiKojiNisuPoloziliPredmet(ArrayList<Student> studentiKojiNisuPoloziliPredmet) {
		this.studentiKojiNisuPoloziliPredmet = studentiKojiNisuPoloziliPredmet;
	}
	
}
