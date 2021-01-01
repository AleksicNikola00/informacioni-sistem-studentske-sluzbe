package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import listeners.AddActionListener;
import listeners.DeleteActionListener;
import listeners.EditActionListener;
import listeners.MyWindowListener;



public class MyMenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MyMenuBar() {
		JMenu file= new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem fNew= new JMenuItem("New",KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		fNew.setIcon(new ImageIcon("images/kreiraj.jpg"));
		fNew.addActionListener(new AddActionListener());
		JMenuItem fClose= new JMenuItem("Close",KeyEvent.VK_C);
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		fClose.setIcon(new ImageIcon("images/zatvori.jpg"));
		fClose.addActionListener(new MyActionListener3());
		file.add(fNew);
		file.add(fClose);
		
		JMenu edit= new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem eEdit=new JMenuItem("Edit",KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		eEdit.setIcon(new ImageIcon("images/izmeni.jpg"));
		eEdit.addActionListener(new EditActionListener());
		JMenuItem eDelete=new JMenuItem("Delete",KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));;
		eDelete.setIcon(new ImageIcon("images/obrisi.jpg"));
		eDelete.addActionListener(new DeleteActionListener());
		edit.add(eEdit);
		edit.add(eDelete);
		
		JMenu help= new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem hHelp=new JMenuItem("Help",KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		hHelp.setIcon(new ImageIcon("images/help.jpg"));
		hHelp.addActionListener(new MyActionListener1());
		JMenuItem hAbout=new JMenuItem("About",KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		hAbout.setIcon(new ImageIcon("images/about.jpg"));
		hAbout.addActionListener(new MyActionListener2());
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
	}
	
	public class MyActionListener1 implements ActionListener{
		String message="Kreiranje novog entiteta:\n    Selektujte tab čiji entitet želite da dodate.\n    "


				+ "Da bi se otvorio dijalog potrebno je da uradite jednu od četiri stvari:\n        1. Kliknite na dugme Kreiraj (znak +) na traci sa alatkama"
				+ "\n        2. Iz menija izaberite File -> New\n        3. Pomoću prečice CTRL + N\n        4. Pomoću prečice ALT + F + N\n    "
				+ "Unesite validne podatke u polja po uzoru na predefinisane vrednosti, te pritisnite dugme Potvrdi.";
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//UIManager.put("OptionPane.minimumSize", new Dimension(300,200));
			JTextArea textArea = new JTextArea("Kreiranje novog entiteta:\n"
					+ "Selektujte tab čiji entitet želite da dodate.\n"
					+ "Da bi se otvorio dijalog potrebno je da uradite jednu od četiri stvari:\n        1. Kliknite na dugme Kreiraj (znak +) na traci sa alatkama\n"
					+ "        2. Iz menija izaberite File -> New\n        3. Pomoću prečice CTRL + N\n        4. Pomoću prečice ALT + F + N\n"
					+ "Prije dodavanja predmeta potrebno je dodati profesora, jer predmet bez profesora nije moguć.\n"
					+ "Unesite validne podatke u polja po uzoru na predefinisane vrednosti, te pritisnite dugme Potvrdi.\n\n"
					+ "Izmena entiteta:\n"
					+ "Selektujte tab, a zatim i određeni entitet koji želite da izmenite.\n"
					+ "Da bi se otvorio dijalog potrebno je da uradite jednu od četiri stvari:\n        1. Kliknite na dugme Izmeni (znak olovke) na traci sa alatkama\n"
					+ "        2. Iz menija izaberite Edit -> Edit\n        3. Pomoću prečice CTRL + E\n        4. Pomoću prečice ALT + E + E\n"
					+ "Izvršite neophodne izmene, te pritisnite dugme Potvrdi.\n\n" 
					+ "Brisanje entiteta:\n"
					+ "Selektujte tab, a zatim i određeni entitet koji želite da izbrišete.\n"
					+ "Da bi se izbrisao entitet potrebno je da uradite jednu od četiri stvari:\n       1. Kliknite na dugme Obriši (znak kante) na traci sa alatkama\n"
					+ "        2. Iz menija izaberite Edit -> Delete\n        3. Pomoću prečice CTRL + D\n        4. Pomoću prečice ALT + E + D\n"        
					+ "Iskočiće dijalog za potvrdu brisanja na kom izaberete Da.\n\n"
					+ "Dodavanje predmeta studentu:\n"
					+ "Selektujte tab Studenti, zatim izaberite određenog studenta i otvorite dijalog za izmenu na neki od načina iz pomoći Izmena entiteta.\n"
					+ "Kliknite na tab Nepoloženi, zatim na dugme Dodaj, izaberite predmet i kliknite Dodaj za potvrdu.\n\n"
					+ "Uklanjanje predmeta studentu:\n"
					+ "Selektujte tab Studenti, zatim izaberite određenog studenta i otvorite dijalog za izmenu na neki od načina iz pomoći Izmena entiteta.\n"
					+ "Kliknite na tab Nepoloženi, odaberite predmet, zatim na dugme Ukloni, i kliknite Da za potvrdu.\n\n"
					+ "Polaganje predmeta studenta:\n"
					+ "Selektujte tab Studenti, zatim izaberite određenog studenta i otvorite dijalog za izmenu na neki od načina iz pomoći Izmena entiteta.\n"
					+ "Kliknite na tab Nepoloženi, odaberite predmet, zatim na dugme Polaganje."
					+ "Popunite dijalog validnim datumom i odgovarajućom ocenom, a zatim kliknite na dugme Potvrdi.\n\n"
					+ "Poništavanje ocene studenta:\n"
					+ "Selektujte tab Studenti, zatim izaberite određenog studenta i otvorite dijalog za izmenu na neki od načina iz pomoći Izmena entiteta.\n"
					+ "Kliknite na tab Položeni, odaberite predmet, zatim na dugme Poništi ocenu, potvrdite klikom na Da.\n\n"
					+ "Pretraga entiteta:\n"
					+ "Pretraga se vrši unosom određenog teksta sadržanog u odgovarajućim atributima klase entiteta koja se pretražuje u tekstualno polje na desnoj strani trake sa alatkama."
					+ "Svaki od parametara pretrage mora biti odvojen razmakom.\n"
					+ "Pri pretrazi studenata može se pretraživati po prezimenu ili prezimenu i imenu ili prezimenu, imenu i broju indeksa.\n"
					+ "Pri pretrazi profesora može se pretraživati po prezimenu ili prezimenu i imenu.\n"
					+ "Pri pretrazi predmeta pretražuje se po nazivu predmeta.\n"
					+ "Klikom na dugme Traži (znak lupe) pored tekstualnog polja, vrši se pretraživanje.\n\n"
					+ "Sortiranje entiteta:\n"
					+ "Selektujte tab sa glavnog prozora čije entitete želite da sortirate.\n"
					+ "Klikom na atribute (prvi red svakog taba), možete da sortirate entitete po tim atributima u rastućem ili opadajućem redosledu.\n\n"
					+ "Dodavanje i uklanjanje predmeta profesoru:\n"
					+ "Selektujte tab Profesori, zatim izaberite određenog profesora i otvorite dijalog za izmenu na neki od načina iz pomoći Izmena entiteta.\n"
					+ "Kliknite na tab Predmeti.\n"
					+ "Pri dodavanju predmeta iz pomoći Dodavanje entiteta, ako je predmetu dodat profesor, taj predmet će se naći u tabeli predmeta tog profesora.\n"
					+ "Kliknite na dugme Dodaj predmet.\n"
					+ "Izborom odgovarajućeg predmeta za dodaju, i pritiskom na dugme Potvrdi, predmet se briše iz tabele prethodnog profesora, a dodaje u tabelu novog profesora."
					
					
					
					);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(MainFrame.getInstance(), scrollPane,"Help Dijalog",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class MyActionListener2 implements ActionListener{
		String message="STUDENTSKA SLUŽBA v1.0\n\nStudentska služba je aplikacija namenjena za upotrebu od strane referenta "
				+ "studentske službe\nFakulteta tehničkih nauka "
				+ "u cilju lakšeg upravljanja nad entitetima fakulteta.\n\nAutori:\nNikola Aleksić - "
				+ "student 3. godine fakulteta tehničkih nauka u Novom Sadu, github: https://github.com/AleksicNikola00\nAleksandar Savić - "
				+ "student 3. godine fakulteta tehničkih nauka u Novom Sadu, github: https://github.com/AleksandarSavicRA8-2018";
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//UIManager.put("OptionPane.minimumSize", new Dimension(300,200));
			JOptionPane.showMessageDialog(MainFrame.getInstance(), message,"About Dijalog",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class MyActionListener3 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			MyWindowListener.getInstance().windowClosing(null);
		}	
	}

}
