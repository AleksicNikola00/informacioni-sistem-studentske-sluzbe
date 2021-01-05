package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BazaSacuvaj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2216210987761796046L;

	private ArrayList<Student> studenti;
	private ArrayList<Predmet> predmeti;
	private ArrayList<Profesor> profesori;
	
	public BazaSacuvaj() {
		// TODO Auto-generated constructor stub
	}

	public BazaSacuvaj(ArrayList<Student> studenti, ArrayList<Predmet> predmeti, ArrayList<Profesor> profesori) {
		super();
		this.studenti = studenti;
		this.predmeti = predmeti;
		this.profesori = profesori;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	} 
}
