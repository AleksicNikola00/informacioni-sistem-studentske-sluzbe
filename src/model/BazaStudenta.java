package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;

public class BazaStudenta {
	
	private static BazaStudenta instance = null;

	public static BazaStudenta getInstance() {
		if (instance == null) {
			instance = new BazaStudenta();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenta() {
		
		initStudenti();
		
		this.kolone=new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina Studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	private void initStudenti() {
		this.studenti=new ArrayList<Student>();
	}

	public Student getStudentIndex(String index) {
		for (Student student : studenti) {
			if(student.getBrojIndexa().equals(index))
				return student;
		}
		return null;
	}
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}
	
	
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int rowIndex) {
		return this.kolone.get(rowIndex);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndexa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 4:
			return student.getStatus().name();
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String ime, String prezime, Date datumRodjenja, String adresa, String email, String brojTelefona,
			String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosecnaOcena,
			ArrayList<Ocena> spisakPolozenihIspita, ArrayList<Predmet> spisakNepolozenihIspita) {
		
		
		this.studenti.add(new Student(ime,prezime,datumRodjenja,adresa,email,brojTelefona,brojIndexa,godinaUpisa,trenutnaGodinaStudija,status,prosecnaOcena,
				spisakPolozenihIspita,spisakNepolozenihIspita));
	}
	
	public void izbrisiStudenta(String brojIndexa) {
		for (Student student : studenti) {
			if(student.getBrojIndexa().equals(brojIndexa)) {
				studenti.remove(student);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String stariIndex,String ime, String prezime, Date datumRodjenja, String adresa, String email, String brojTelefona,
			String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosecnaOcena,
			ArrayList<Ocena> spisakPolozenihIspita, ArrayList<Predmet> spisakNepolozenihIspita) {
		
		for (Student student : studenti) {
			if(student.getBrojIndexa().equals(stariIndex)) {
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setDatumRodjenja(datumRodjenja);
				student.setAdresa(adresa);
				student.setEmail(email);
				student.setBrojTelefona(brojTelefona);
				student.setBrojIndexa(brojIndexa);
				student.setGodinaUpisa(godinaUpisa);
				student.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				student.setStatus(status);
				student.setProsecnaOcena(prosecnaOcena);
				student.setSpisakPolozenihIspita(spisakPolozenihIspita);
				student.setSpisakNepolozenihIspita(spisakNepolozenihIspita);
				
			}
		}
	}
	
	
}


