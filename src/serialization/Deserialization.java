package serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import model.Predmet;
import model.Profesor;
import model.Student;

public class Deserialization {
	
	private static ObjectInputStream ois;

	@SuppressWarnings("unchecked")
	public static void ucitajStudente(List<Student> studenti,String imeFajla) throws ClassNotFoundException, FileNotFoundException, IOException {
			File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			studenti=(List<Student>)ois.readObject();
		} finally{
			ois.close();
		}
			
		
	}
	
	@SuppressWarnings("unchecked")
	public static void ucitajProfesore(ArrayList<Profesor> profesori,String imeFajla) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			profesori=(ArrayList<Profesor>) ois.readObject();
		}finally{
			ois.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void ucitasPredmete(ArrayList<Predmet> predmeti,String imeFajla) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			predmeti=(ArrayList<Predmet>) ois.readObject();
		}finally{
			ois.close();
		}
	}
}
