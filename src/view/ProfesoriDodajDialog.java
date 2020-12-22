package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesoriController;
import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;

public class ProfesoriDodajDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195495952053849388L;
	
	private static ProfesoriDodajDialog instance = null;
	private static ArrayList<JTextField> listaTxt;
	private static JButton btnPotvrdi;
	private static JComboBox<String> zvanjaComboBox;
	private static JComboBox<String> tituleComboBox;
	
	public static ArrayList<JTextField> getListaTxt() {
		return listaTxt;
	}

	public static JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}

	public static JComboBox<String> getZvanjaComboBox() {
		return zvanjaComboBox;
	}

	public static JComboBox<String> getTituleComboBox() {
		return tituleComboBox;
	}
	
	public static ProfesoriDodajDialog getInstance() {
		if(instance==null)
			instance=new ProfesoriDodajDialog();
		
		return instance;
	}
	
	private ProfesoriDodajDialog() {
		super(MainFrame.getInstance(),"Dodaj profesora", true);
		listaTxt=new ArrayList<JTextField>();
		btnPotvrdi=new JButton("Potvrdi");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4 - 500, 3 * screenHeight / 4 - 25);
		setLocationRelativeTo(MainFrame.getInstance());
		
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel = new JPanel();
		add(panel);
		Dimension dim = new Dimension((int)(screenWidth / 6.83), (int)(screenHeight / 25.6));
		MyFocusListener proveraUnosa= new MyFocusListener(listaTxt, btnPotvrdi);
		
		//ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setText("Pero");
		txtIme.setName("txtIme");
		txtIme.addFocusListener(proveraUnosa);
		txtIme.addActionListener(new SwitchTxtFieldListener());
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		//prezime
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setText("Perić");
		txtPrezime.setName("txtPrz");
		txtPrezime.addFocusListener(proveraUnosa);
		txtPrezime.addActionListener(new SwitchTxtFieldListener());
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		//datum rodjenja
		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodj = new JLabel("Datum rođenja*");
		lblDatumRodj.setPreferredSize(dim);
		JTextField txtDatumRodj = new JTextField();
		txtDatumRodj.setPreferredSize(dim);
		txtDatumRodj.setText("25.2.1980.");
		txtDatumRodj.setName("datRodj");
		txtDatumRodj.addFocusListener(proveraUnosa);
		txtDatumRodj.addActionListener(new SwitchTxtFieldListener());
		panDatumRodj.add(lblDatumRodj);
		panDatumRodj.add(txtDatumRodj);
		
		//adresa stanovanja
		JPanel panAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
		lblAdresaStan.setPreferredSize(dim);
		JTextField txtAdresaStan = new JTextField();
		txtAdresaStan.setPreferredSize(dim);
		txtAdresaStan.setText("Ulica Alekse Šantića 4");
		txtAdresaStan.setName("txtAdresa");
		txtAdresaStan.addFocusListener(proveraUnosa);
		txtAdresaStan.addActionListener(new SwitchTxtFieldListener());
		panAdresaStan.add(lblAdresaStan);
		panAdresaStan.add(txtAdresaStan);
		
		//broj telefona
		JPanel panBrojTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTel = new JLabel("Broj telefona*");
		lblBrojTel.setPreferredSize(dim);
		JTextField txtBrojTel = new JTextField();
		txtBrojTel.setPreferredSize(dim);
		txtBrojTel.setText("066439698");
		txtBrojTel.setName("txtBroj");
		txtBrojTel.addFocusListener(proveraUnosa);
		txtBrojTel.addActionListener(new SwitchTxtFieldListener());
		panBrojTel.add(lblBrojTel);
		panBrojTel.add(txtBrojTel);
		
		// email
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setText("pero.peric@uns.ac.rs");
		txtEmail.setName("txtEmail");
		txtEmail.addFocusListener(proveraUnosa);
		txtEmail.addActionListener(new SwitchTxtFieldListener());
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		// adresa kancelarije
		JPanel panAdresaKanc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
		lblAdresaKanc.setPreferredSize(dim);
		JTextField txtAdresaKanc = new JTextField();
		txtAdresaKanc.setPreferredSize(dim);
		txtAdresaKanc.setText("Ulica Alekse Šantića 4");
		txtAdresaKanc.setName("txtAdresaKancelarije");
		txtAdresaKanc.addFocusListener(proveraUnosa);
		txtAdresaKanc.addActionListener(new SwitchTxtFieldListener());
		panAdresaKanc.add(lblAdresaKanc);
		panAdresaKanc.add(txtAdresaKanc);
		
		// broj lične karte
		JPanel panBrojLK = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojLK = new JLabel("Broj lične karte*");
		lblBrojLK.setPreferredSize(dim);
		JTextField txtBrojLK = new JTextField();
		txtBrojLK.setPreferredSize(dim);
		txtBrojLK.setText("A54FG5HJ3M");
		txtBrojLK.setName("txtBrojLK");
		txtBrojLK.addFocusListener(proveraUnosa);
		txtBrojLK.addActionListener(new SwitchTxtFieldListener());
		panBrojLK.add(lblBrojLK);
		panBrojLK.add(txtBrojLK);
		
		//zvanje
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(new Dimension(dim));
		panZvanje.add(lblZvanje);
		String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor"};
		zvanjaComboBox = new JComboBox<String>(zvanja);
		zvanjaComboBox.setPreferredSize(new Dimension(dim));
		panZvanje.add(zvanjaComboBox);
		
		//titula
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(new Dimension(dim));
		panTitula.add(lblTitula);
		String[] titule = {"Doktor nauka"};
		tituleComboBox = new JComboBox<String>(titule);
		tituleComboBox.setPreferredSize(new Dimension(dim));
		panTitula.add(tituleComboBox);
		
		
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
		JButton btnOdustani = new JButton("Odustani");
		panBtn.add(btnPotvrdi);
		panBtn.add(Box.createHorizontalStrut(25));
		panBtn.add(btnOdustani);
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(proveraUnosa.validateTxtFields()) {
					ProfesoriController.getInstance().dodajProfesora();
					dispose();
					return;
				}
			}
		});
		
		listaTxt.add(txtIme);
		listaTxt.add(txtPrezime);
		listaTxt.add(txtDatumRodj);
		listaTxt.add(txtAdresaStan);
		listaTxt.add(txtBrojTel);
		listaTxt.add(txtEmail);
		listaTxt.add(txtAdresaKanc);
		listaTxt.add(txtBrojLK);
		
		Box box = Box.createVerticalBox();
		box.add(panIme);
		box.add(panPrezime);
		box.add(panDatumRodj);
		box.add(panAdresaStan);
		box.add(panBrojTel);
		box.add(panEmail);
		box.add(panAdresaKanc);
		box.add(panBrojLK);
		box.add(panZvanje);
		box.add(panTitula);
		box.add(Box.createVerticalStrut(20));
		box.add(panBtn);
		box.add(Box.createGlue());
		panel.add(box);
	}

}