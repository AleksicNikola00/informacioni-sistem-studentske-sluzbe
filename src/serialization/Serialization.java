package serialization;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Predmet;
import model.Profesor;
import model.Student;

public class Serialization {
	
	private static ObjectOutputStream oos;
	
	public static void sacuvajStudente(List<Student> studenti, String imeFajla) throws FileNotFoundException, IOException{
		File f=new File(imeFajla);
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos.writeObject(studenti);
		} finally{
			oos.close();
		}
	}
	
	public static void sacuvajProfesore(List<Profesor> profesori, String imeFajla) throws FileNotFoundException, IOException{
		File f=new File(imeFajla);
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos.writeObject(profesori);
		} finally{
			oos.close();
		}
	}
	
	public static void sacuvajPredmete(List<Predmet> predmeti, String imeFajla) throws FileNotFoundException, IOException{
		File f=new File(imeFajla);
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos.writeObject(predmeti);
		} finally{
			oos.close();
		}
	}
}
