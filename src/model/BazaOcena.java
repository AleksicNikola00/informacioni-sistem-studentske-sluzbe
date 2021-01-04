package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BazaOcena {
	
	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private ArrayList<String> kolone;
	private ArrayList<Ocena> ocene;
	
	private BazaOcena() {
		this.ocene=new ArrayList<>();
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}

	public ArrayList<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(ArrayList<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}
	
	public String getValueAt(int row,int column) {
		Ocena ocena=this.ocene.get(row);
		switch(column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getBrojESPB());
		case 3:
			return Integer.toString(ocena.getOcena());
		case 4:
		{
			DateFormat dateFormat=new SimpleDateFormat("dd.mm.yyyy.");
			return dateFormat.format(ocena.getDatumPolaganjaIspita());
		}
		default:
			return null;
		}
	}
	
	public void dodajOcenu(Student student, Predmet predmet, int ocena,Date datumPolaganjaIspita) {
		this.ocene.add(new Ocena(student,predmet,ocena,datumPolaganjaIspita));
	}
	
	public Ocena ponistiOcenu(String brIndexa,String sifraPredmeta) {
		for (Ocena ocena : ocene) {
			if(ocena.getStudent().getBrojIndexa().equals(brIndexa) && ocena.getPredmet().getSifraPredmeta().equals(sifraPredmeta))
				this.ocene.remove(ocena);
			return ocena;
		}
		return null;
	}
}
