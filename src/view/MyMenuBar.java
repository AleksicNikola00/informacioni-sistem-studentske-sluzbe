package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
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
	
	private JMenu file;
	private JMenuItem fNew;
	private JMenuItem fClose;
	private JMenu edit;
	private JMenuItem eEdit;
	private JMenuItem eDelete;
	private JMenu help;
	private JMenuItem hHelp;
	private JMenuItem hAbout;
	//
	private JMenu jezici;
    private JCheckBoxMenuItem jSrpski;
    private JCheckBoxMenuItem jEngleski;
	//
    private JMenu pretrazi;
	private JCheckBoxMenuItem jSearch;
	private JCheckBoxMenuItem jAdvancedSearch;
    
	public MyMenuBar() {
		file= new JMenu("Fajl");
		file.setMnemonic(KeyEvent.VK_F);
		fNew= new JMenuItem("Novi",KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		fNew.setIcon(new ImageIcon("images/kreiraj.jpg"));
		fNew.addActionListener(new AddActionListener());
		fClose= new JMenuItem("Zatvori",KeyEvent.VK_C);
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		fClose.setIcon(new ImageIcon("images/zatvori.jpg"));
		fClose.addActionListener(new MyActionListener3());
		file.add(fNew);
		file.add(fClose);
		
		edit= new JMenu("Uredi");
		edit.setMnemonic(KeyEvent.VK_E);
		eEdit=new JMenuItem("Uredi",KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		eEdit.setIcon(new ImageIcon("images/izmeni.jpg"));
		eEdit.addActionListener(new EditActionListener());
		eDelete=new JMenuItem("Obriši",KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));;
		eDelete.setIcon(new ImageIcon("images/obrisi.jpg"));
		eDelete.addActionListener(new DeleteActionListener());
		edit.add(eEdit);
		edit.add(eDelete);
		
		help= new JMenu("Pomoć");
		help.setMnemonic(KeyEvent.VK_H);
		hHelp=new JMenuItem("Pomoć",KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		hHelp.setIcon(new ImageIcon("images/help.jpg"));
		hHelp.addActionListener(new MyActionListener1());
		hAbout=new JMenuItem("O programu",KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		hAbout.setIcon(new ImageIcon("images/about.jpg"));
		hAbout.addActionListener(new MyActionListener2());
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
		//
		jezici = new JMenu("Jezici");
		jezici.setMnemonic(KeyEvent.VK_J);
        add(jezici);

        jSrpski = new JCheckBoxMenuItem("Srpski");
        jSrpski.setSelected(true);
        jSrpski.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Locale.setDefault(new Locale("sr", "RS"));
                MainFrame.getInstance().changeLanguage();
            }
        });
        jezici.add(jSrpski);

        jEngleski = new JCheckBoxMenuItem("Engleski");
        jEngleski.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Locale.setDefault(new Locale("en", "US"));
                MainFrame.getInstance().changeLanguage();
            }
        });
       
        jezici.add(jEngleski);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jSrpski);
        bg.add(jEngleski);
        //
        pretrazi=new JMenu("Vrste pretrage");
        //hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        pretrazi.setMnemonic(KeyEvent.VK_P);
        add(pretrazi);
        
        
        jSearch= new JCheckBoxMenuItem("Pretraga");
        jSearch.setSelected(true);
        jSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Toolbar.getInstance().changeSearch(false);
			}
		});
        jAdvancedSearch = new JCheckBoxMenuItem("Napredna pretraga");
        jAdvancedSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Toolbar.getInstance().changeSearch(true);
			}
		});
        pretrazi.add(jSearch);
        pretrazi.add(jAdvancedSearch);
        ButtonGroup advancedSearch = new ButtonGroup();
        advancedSearch.add(jSearch);
        advancedSearch.add(jAdvancedSearch);
		
	}
	
	public void menuChangeLanguage() {
        file.setText(MainFrame.getInstance().getResourceBundle().getString("file"));
        fNew.setText(MainFrame.getInstance().getResourceBundle().getString("fNew"));
        fClose.setText(MainFrame.getInstance().getResourceBundle().getString("fClose"));
        edit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
        eEdit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
        eDelete.setText(MainFrame.getInstance().getResourceBundle().getString("eDelete"));
        help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
        hHelp.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
        hAbout.setText(MainFrame.getInstance().getResourceBundle().getString("hAbout"));
        jezici.setText(MainFrame.getInstance().getResourceBundle().getString("jezici"));
        jSrpski.setText(MainFrame.getInstance().getResourceBundle().getString("jSrpski"));
        jEngleski.setText(MainFrame.getInstance().getResourceBundle().getString("jEngleski"));
        //
        pretrazi.setText(MainFrame.getInstance().getResourceBundle().getString("pretrazi"));
        jSearch.setText(MainFrame.getInstance().getResourceBundle().getString("jPretraga"));
        jAdvancedSearch.setText(MainFrame.getInstance().getResourceBundle().getString("jNaprednaPretraga"));
    }
	
	
	public class MyActionListener1 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//UIManager.put("OptionPane.minimumSize", new Dimension(300,200));
			JTextArea textArea = new JTextArea(MainFrame.getInstance().getResourceBundle().getString("helpDialog"));
			String title = MainFrame.getInstance().getResourceBundle().getString("helpDialogTitle");
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(MainFrame.getInstance(), scrollPane, title,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class MyActionListener2 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//UIManager.put("OptionPane.minimumSize", new Dimension(300,200));
			String message=MainFrame.getInstance().getResourceBundle().getString("aboutDialog");
			String title = MainFrame.getInstance().getResourceBundle().getString("aboutDialogTitle");
			JOptionPane.showMessageDialog(MainFrame.getInstance(), message, title,JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class MyActionListener3 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			MyWindowListener.getInstance().windowClosing(null);
		}	
	}

}
