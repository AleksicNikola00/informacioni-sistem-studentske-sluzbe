package model;

import java.util.ArrayList;

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String godinaStudija;
	private Profesor profesor;
	private String brojESPB;
	private ArrayList<Student> studentiKojiSuPoloziliPredmet;
	private ArrayList<Student> studentiKojiNisuPoloziliPredmet;
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, String godinaStudija,
			Profesor profesor, String brojESPB, ArrayList<Student> studentiKojiSuPoloziliPredmet,
			ArrayList<Student> studentiKojiNisuPoloziliPredmet) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
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

	public String getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public String getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(String brojESPB) {
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
