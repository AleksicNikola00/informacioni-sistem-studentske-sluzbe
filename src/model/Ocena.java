package model;

import java.io.Serializable;
import java.util.Date;

public class Ocena implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -552565010510250567L;
	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datumPolaganjaIspita;
	
	
	public Ocena() {
		// TODO Auto-generated constructor stub
	}

	public Ocena(Student student, Predmet predmet, int ocena, Date datumPolaganjaIspita) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Date getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}

	public void setDatumPolaganjaIspita(Date datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}

	
	
}
