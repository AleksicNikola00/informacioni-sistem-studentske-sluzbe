package serialization;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaSacuvaj;
import model.BazaStudenta;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Serialization {
	
	private static ObjectOutputStream oos;
	
	public static void sacuvajObjekte(String imeFajla) throws IOException {
        //BazaStudenta.getInstance().getStudenti(), BazaPredmeta.getInstance().getSviPredmeti(), BazaProfesora.getInstance().getProfesori()
        BazaSacuvaj sveListe=new BazaSacuvaj(BazaStudenta.getInstance().getStudenti(), BazaPredmeta.getInstance().getSviPredmeti(), BazaProfesora.getInstance().getProfesori());
        File f=new File(imeFajla);
            try {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
                oos.writeObject(sveListe);
            }
        finally {
                oos.close();
        }
    }
}
