package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import listeners.AddActionListener;



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
		JMenuItem eDelete=new JMenuItem("Delete",KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));;
		eDelete.setIcon(new ImageIcon("images/obrisi.jpg"));
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
				+ "Da bi se otvorio dijalog potrebno je da uradite jednu od tri stvari:\n        1. Kliknite na dugme Kreiraj (znak +) na tulbaru"
				+ "\n        2. Iz menija izaberite File -> New\n        3. Pomoću prečice CTRL + N\n        4. Pomoću prečice ALT + F + N\n    "
				+ "Unesite validne podatke u polja po uzoru na predefinisane vrednosti, te pritisnite dugme Potvrdi.";
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//UIManager.put("OptionPane.minimumSize", new Dimension(300,200));
			JOptionPane.showMessageDialog(MainFrame.getInstance(), message,"Help Dijalog",JOptionPane.INFORMATION_MESSAGE);
			
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
