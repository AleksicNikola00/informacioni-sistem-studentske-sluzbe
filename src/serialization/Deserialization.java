package serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaSacuvaj;
import model.BazaStudenta;
import view.MainFrame;

public class Deserialization {
	
	private static ObjectInputStream ois;
	
	public static void ucitajListu(String imeFajla) throws FileNotFoundException, IOException, ClassNotFoundException {
		//Sacuvaj sveListe=new Sacuvaj();
		File f=new File(imeFajla);
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			BazaSacuvaj sveListe=(BazaSacuvaj)ois.readObject();
			BazaStudenta.getInstance().setStudenti(sveListe.getStudenti());
			BazaProfesora.getInstance().setProfesori(sveListe.getProfesori());
			BazaPredmeta.getInstance().setSviPredmeti(sveListe.getPredmeti());
			BazaPredmeta.getInstance().setCurrentList(1);
		}
		finally{
			ois.close();
			MainFrame.getInstance().azurirajPrikaz();
		}
	}
	
}
