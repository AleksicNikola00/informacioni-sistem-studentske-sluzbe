package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesoriController;
import controller.Validate;
import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;
import model.Profesor;

public class ProfesorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195495952053849388L;
	
	private ArrayList<JTextField> listaTxt;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblDatumRodj;
	private JLabel lblAdresaStan;
	private JLabel lblBrojTel;
	private JLabel lblEmail;
	private JLabel lblAdresaKanc;
	private JLabel lblBrojLK;
	private JLabel lblZvanje;
	private JLabel lblTitula;
	private JComboBox<String> zvanjaComboBox;
	private JComboBox<String> tituleComboBox;
	private boolean mode;
	
	
	
	public ArrayList<JTextField> getListaTxt() {
		return listaTxt;
	}

	public void setListaTxt(ArrayList<JTextField> listaTxt) {
		this.listaTxt = listaTxt;
	}

	public JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}

	public void setBtnPotvrdi(JButton btnPotvrdi) {
		this.btnPotvrdi = btnPotvrdi;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public JComboBox<String> getZvanjaComboBox() {
		return zvanjaComboBox;
	}

	public void setZvanjaComboBox(JComboBox<String> zvanjaComboBox) {
		this.zvanjaComboBox = zvanjaComboBox;
	}

	public JComboBox<String> getTituleComboBox() {
		return tituleComboBox;
	}

	public void setTituleComboBox(JComboBox<String> tituleComboBox) {
		this.tituleComboBox = tituleComboBox;
	}

	public boolean isMode() {
		return mode;
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}

	public ProfesorPanel(boolean mode) {
		this.mode = mode;
		listaTxt=new ArrayList<JTextField>();
		btnPotvrdi=new JButton("Potvrdi");
		btnOdustani = new JButton("Odustani");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		Dimension dim = new Dimension((int)(screenWidth / 7), (int)(screenHeight / 25));
		MyFocusListener proveraUnosa= new MyFocusListener(listaTxt, btnPotvrdi,btnOdustani);
		
		//ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblIme = new JLabel("Ime*");
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
		lblPrezime = new JLabel("Prezime*");
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
		lblDatumRodj = new JLabel("Datum rođenja*");
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
		lblAdresaStan = new JLabel("Adresa stanovanja*");
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
		lblBrojTel = new JLabel("Broj telefona*");
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
		lblEmail = new JLabel("E-mail adresa*");
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
		lblAdresaKanc = new JLabel("Adresa kancelarije*");
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
		lblBrojLK = new JLabel("Broj lične karte*");
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
		lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(new Dimension(dim));
		panZvanje.add(lblZvanje);
		String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor"};
		zvanjaComboBox = new JComboBox<String>(zvanja);
		zvanjaComboBox.setPreferredSize(new Dimension(dim));
		panZvanje.add(zvanjaComboBox);
		
		//titula
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(new Dimension(dim));
		panTitula.add(lblTitula);
		String[] titule = {"Doktor nauka"};
		tituleComboBox = new JComboBox<String>(titule);
		tituleComboBox.setPreferredSize(new Dimension(dim));
		panTitula.add(tituleComboBox);
		
		
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
		//JButton btnOdustani = new JButton("Odustani");
		panBtn.add(btnPotvrdi);
		panBtn.add(Box.createHorizontalStrut(25));
		panBtn.add(btnOdustani);
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mode)
					ProfesoriDodajDialog.getInstance().dispose();
				else 
					ProfesoriIzmenaDialog.getInstance().dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(proveraUnosa.validateTxtFields()) {
					if(mode) {
						if(!Validate.validateUniqueName(txtIme.getText(), txtPrezime.getText())) {
							String message = MainFrame.getInstance().getResourceBundle().getString("postojeciProfesorError");
							JOptionPane.showMessageDialog(null, message);
							return;
						}
						ProfesoriController.getInstance().dodajProfesora();
						ProfesoriDodajDialog.getInstance().dispose();
					}
					else {
						if(isNameSame() || Validate.validateUniqueName(txtIme.getText(), txtPrezime.getText())) {
							ProfesoriController.getInstance().izmeniProfesora(ProfesoriJTable.getInstance().getSelectedRow());
							ProfesoriIzmenaDialog.getInstance().dispose();
						}
						else {
							String message = MainFrame.getInstance().getResourceBundle().getString("postojeciProfesorError");
							JOptionPane.showMessageDialog(null, message);
						}
					}
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
		
		if(!mode) {
			refreshProfesorFirstPanel();
		}
		
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
		this.add(box);
	}
	
	public  void refreshProfesorFirstPanel() {
		profesorPanelChangeLanguage();
		
		int indexProfesora = ProfesoriJTable.getInstance().getSelectedRow();
		Profesor profesor = ProfesoriController.getInstance().getProfesor(indexProfesora);
		DateFormat dateFormat=new SimpleDateFormat("dd.mm.yyyy.");
		listaTxt.get(0).setText(profesor.getIme());
		listaTxt.get(1).setText(profesor.getPrezime());
		listaTxt.get(2).setText(dateFormat.format(profesor.getDatumRodjenja()));
		listaTxt.get(3).setText(profesor.getAdresaStanovanja());
		listaTxt.get(4).setText(profesor.getTelefon());
		listaTxt.get(5).setText(profesor.getEmail());
		listaTxt.get(6).setText(profesor.getAdresaKancelarije());
		listaTxt.get(7).setText(profesor.getBrojLicneKarte());
			
		if(profesor.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("docent")))
			zvanjaComboBox.setSelectedIndex(0);
		else if(profesor.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("vanredni")))
			zvanjaComboBox.setSelectedIndex(1);
		else
			zvanjaComboBox.setSelectedIndex(2);
			
		tituleComboBox.setSelectedIndex(0);
	}
	
	public boolean isNameSame() {
		int selectedIndex = ProfesoriJTable.getInstance().getSelectedRow();
		Profesor profesor = ProfesoriController.getInstance().getProfesor(selectedIndex);
		
		if(listaTxt.get(0).getText().equals(profesor.getIme()) && listaTxt.get(1).getText().equals(profesor.getPrezime()))
			return true;
		else
			return false;
	}

	public void profesorPanelChangeLanguage() {
		btnPotvrdi.setText(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
		btnOdustani.setText(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		lblIme.setText(MainFrame.getInstance().getResourceBundle().getString("imeZvezda"));
		lblPrezime.setText(MainFrame.getInstance().getResourceBundle().getString("prezimeZvezda"));
		lblDatumRodj.setText(MainFrame.getInstance().getResourceBundle().getString("datumRodjZvezda"));
		lblAdresaStan.setText(MainFrame.getInstance().getResourceBundle().getString("adresaStanZvezda"));
		lblBrojTel.setText(MainFrame.getInstance().getResourceBundle().getString("brojTelZvezda"));
		lblEmail.setText(MainFrame.getInstance().getResourceBundle().getString("emailZvezda"));
		lblAdresaKanc.setText(MainFrame.getInstance().getResourceBundle().getString("adresaKancZvezda"));
		lblBrojLK.setText(MainFrame.getInstance().getResourceBundle().getString("brojLKZvezda"));
		lblZvanje.setText(MainFrame.getInstance().getResourceBundle().getString("zvanjeZvezda"));
		lblTitula.setText(MainFrame.getInstance().getResourceBundle().getString("titulaZvezda"));
		zvanjaComboBox.removeAllItems();
		zvanjaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("docent"));
		zvanjaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("vanredni"));
		zvanjaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("redovni"));
		tituleComboBox.removeAllItems();
		tituleComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("doktorNauka"));
	}
}