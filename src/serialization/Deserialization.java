package serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenta;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.MainFrame;

public class Deserialization {
	
	private static ObjectInputStream ois;

	@SuppressWarnings("unchecked")
	public static void ucitajStudente(String imeFajla) throws ClassNotFoundException, FileNotFoundException, IOException {
			File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			BazaStudenta.getInstance().setStudenti((List<Student>)ois.readObject());
			
			
		} finally{
			ois.close();
			MainFrame.getInstance().azurirajPrikaz();
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public static void ucitajProfesore(String imeFajla) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			BazaProfesora.getInstance().setProfesori((ArrayList<Profesor>) ois.readObject());
		}finally{
			ois.close();
			MainFrame.getInstance().azurirajPrikaz();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void ucitajPredmete(String imeFajla) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			BazaPredmeta.getInstance().setSviPredmeti((ArrayList<Predmet>) ois.readObject());
			BazaPredmeta.getInstance().setCurrentList(1);
		}finally{
			ois.close();
			MainFrame.getInstance().azurirajPrikaz();
		}
	}
}
