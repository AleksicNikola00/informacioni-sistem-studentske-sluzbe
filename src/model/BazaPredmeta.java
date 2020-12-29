package model;

import java.util.ArrayList;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private ArrayList<Predmet> predmeti;
	private ArrayList<Predmet> sviPredmeti;
	private ArrayList<Predmet> nepolozeniPredmeti;
	private ArrayList<String> kolone;
	private boolean mode;
	
	public void setPredmeti(boolean mode) {
		this.mode = mode;
		if(mode)
			predmeti = sviPredmeti;
		else
			predmeti = nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	public ArrayList<Predmet> getSviPredmeti() {
		return sviPredmeti;
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		this.nepolozeniPredmeti = new ArrayList<Predmet>();
		this.sviPredmeti = new ArrayList<Predmet>();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("ŠIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojESPB());
		case 3:
			return  Integer.toString(predmet.getGodinaStudija());
		case 4:
			return predmet.getSemestar();
		default:
			return null;
		}
	}

	public Predmet getSviPredmet(String sifraPredmeta) {
		for (Predmet predmet : sviPredmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta))
				return predmet;
		}
		return null;
	}
	
	public Predmet getPredmet(String sifraPredmeta) {
		for (Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta))
				return predmet;
		}
		return null;
	}
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, int godinaStudija,
			Profesor profesor, int brojESPB, ArrayList<Student> studentiKojiSuPoloziliPredmet,
			ArrayList<Student> studentiKojiNisuPoloziliPredmet) {
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, brojESPB, 
				studentiKojiSuPoloziliPredmet, studentiKojiNisuPoloziliPredmet));
		if(mode)
			sviPredmeti = predmeti;
	}
	
	public void izmeniPredmet(String staraSifraPredmeta,String sifraPredmeta, String nazivPredmeta, String semestar, int godinaStudija,
			Profesor profesor, int brojESPB, ArrayList<Student> studentiKojiSuPoloziliPredmet,
			ArrayList<Student> studentiKojiNisuPoloziliPredmet) {
		for (Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta().equals(staraSifraPredmeta)) {
				predmet.setSifraPredmeta(sifraPredmeta);
				predmet.setNazivPredmeta(nazivPredmeta);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godinaStudija);
				predmet.setProfesor(profesor);
				predmet.setBrojESPB(brojESPB);
				predmet.setStudentiKojiSuPoloziliPredmet(studentiKojiSuPoloziliPredmet);
				predmet.setStudentiKojiNisuPoloziliPredmet(studentiKojiNisuPoloziliPredmet);
				
				break;
			}
			
		}
		
		if(mode)
			sviPredmeti = predmeti;
	}
	
	public void izbrisiPredmet(String sifraPredmeta) {
		for (Predmet predmet : predmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmeti.remove(predmet);
				break;
			}
		}
		
		if(mode)
			sviPredmeti = predmeti;
	}
}
