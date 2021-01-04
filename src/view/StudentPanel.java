package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentiController;
import controller.Validate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;
import model.Student;
import model.Student.Status;


public class StudentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private  ArrayList<JTextField> listaTxt;
	private  JButton btnPotvrdi;//btn potvrde koji enable/disable u zavisnosti od validnosti txt polja
	private  JButton btnOdustani;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblDatumRodj;
	private JLabel lblAdresaStan;
	private JLabel lblBrojTel;
	private JLabel lblEmail;
	private JLabel lblBrIndexa;
	private JLabel lblGodUpisa;
	private JLabel lblTrenutnaGodinaStudija;
	private JLabel lblNacinFinansiranja;
	private  JComboBox<String> trenutnaGodinaComboBox;//combo boxovi izdvojeni da bismo mogli da im pristupamo iz kontrolera
	private  JComboBox<String> nacinFinasiranjaComboBox;
	private boolean mode;//true-dodaj false-edituj
	
	public boolean getMode() {
		return mode;
	}

	public void setMode(boolean mode) {
		this.mode = mode;
	}
	public  ArrayList<JTextField> getListaTxt() {
		return listaTxt;
	}
	
	public  void setListaTxt(ArrayList<JTextField> listaTxt) {
		this.listaTxt = listaTxt;
	}
	public  JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}
	public  void setBtnPotvrdi(JButton btnPotvrdi) {
		this.btnPotvrdi = btnPotvrdi;
	}
	public  JButton getBtnOdustani() {
		return btnOdustani;
	}
	public  void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}
	public  JComboBox<String> getTrenutnaGodinaComboBox() {
		return trenutnaGodinaComboBox;
	}
	public  void setTrenutnaGodinaComboBox(JComboBox<String> trenutnaGodinaComboBox) {
		this.trenutnaGodinaComboBox = trenutnaGodinaComboBox;
	}
	public  JComboBox<String> getNacinFinasiranjaComboBox() {
		return nacinFinasiranjaComboBox;
	}
	public  void setNacinFinasiranjaComboBox(JComboBox<String> nacinFinasiranjaComboBox) {
		this.nacinFinasiranjaComboBox = nacinFinasiranjaComboBox;
	}
	
	public StudentPanel getPanel() {
		return this;
	}
	
	public StudentPanel(boolean mode) {
		this.mode=mode;
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
		MyFocusListener proveraUnosa= new MyFocusListener(listaTxt,btnPotvrdi,btnOdustani);
		//ime
				JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblIme = new JLabel("Ime*");
				lblIme.setPreferredSize(dim);
				JTextField txtIme = new JTextField();
				txtIme.setPreferredSize(dim);
				//if(mode)
					txtIme.setText("Pero");
				txtIme.setName("txtIme");
				txtIme.addFocusListener(proveraUnosa);
				txtIme.addActionListener(new SwitchTxtFieldListener());
				panIme.add(lblIme);
				panIme.add(txtIme);
				//this.add(lblIme);
			
			//prz
				JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblPrezime = new JLabel("Prezime*");
				lblPrezime.setPreferredSize(dim);
				JTextField txtPrezime = new JTextField();
				txtPrezime.setPreferredSize(dim);
				txtPrezime.setText("Perić");
				txtPrezime.setName("txtPrz"); //isto kao i ime zbog provere!
				txtPrezime.addFocusListener(proveraUnosa);
				txtPrezime.addActionListener(new SwitchTxtFieldListener());
				panPrezime.add(lblPrezime);
				panPrezime.add(txtPrezime);
		
				//datRodj
				JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblDatumRodj = new JLabel("Datum rođenja*");
				lblDatumRodj.setPreferredSize(dim);
				JTextField txtDatumRodj = new JTextField();
				txtDatumRodj.setPreferredSize(dim);
				txtDatumRodj.setText("25.02.1980.");
				txtDatumRodj.setName("datRodj");
				txtDatumRodj.addFocusListener(proveraUnosa);
				txtDatumRodj.addActionListener(new SwitchTxtFieldListener());
				panDatumRodj.add(lblDatumRodj);
				panDatumRodj.add(txtDatumRodj);
				
				//adresa
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
				
				//telefon
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
				
				//email
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
				
				//brIndexa
				JPanel panBrIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblBrIndexa= new JLabel("Broj indexa*");
				lblBrIndexa.setPreferredSize(dim);
				JTextField txtBrIndexa=new JTextField();
				txtBrIndexa.setName("txtIndex");
				txtBrIndexa.setPreferredSize(dim);
				
					txtBrIndexa.setText("RA-24/2018");
				//else
					//txtBrIndexa.setText(student.getBrojIndexa());
				txtBrIndexa.addFocusListener(proveraUnosa);
				txtBrIndexa.addActionListener(new SwitchTxtFieldListener());
				panBrIndexa.add(lblBrIndexa);
				panBrIndexa.add(txtBrIndexa);
				
				//godinaUpisa
				JPanel panGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblGodUpisa=new JLabel("Godina upisa*");
				lblGodUpisa.setPreferredSize(dim);
				JTextField txtGodinaUpisa=new JTextField();
				txtGodinaUpisa.setPreferredSize(dim);
				txtGodinaUpisa.setText("2018");
				txtGodinaUpisa.setName("txtGodinaUpisa");
				txtGodinaUpisa.addFocusListener(proveraUnosa);
				txtGodinaUpisa.addActionListener(new SwitchTxtFieldListener());
				panGodinaUpisa.add(lblGodUpisa);
				panGodinaUpisa.add(txtGodinaUpisa);
				
				//TrenutnaGodinaStudija
				JPanel panTrenutnaGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija*");
				lblTrenutnaGodinaStudija.setPreferredSize(dim);
				panTrenutnaGodinaStudija.add(lblTrenutnaGodinaStudija);
				String[] godinaStudiranja= {"I (prva)","II (druga)","III (treća)","IV (četvrta)","Master","Doktorske"};
				trenutnaGodinaComboBox = new JComboBox<String>(godinaStudiranja);
				trenutnaGodinaComboBox.setPreferredSize(dim);
				panTrenutnaGodinaStudija.add(trenutnaGodinaComboBox);
				
				//NacinFinansiranja
				JPanel panNacinFinansiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lblNacinFinansiranja=new JLabel("Način finansiranja*");
				lblNacinFinansiranja.setPreferredSize(dim);
				panNacinFinansiranja.add(lblNacinFinansiranja);
				String[] nacinFinansiranja= {"Budžet","Samofinansiranje"};
				nacinFinasiranjaComboBox = new JComboBox<String>(nacinFinansiranja);
				nacinFinasiranjaComboBox.setPreferredSize(dim);
				panNacinFinansiranja.add(nacinFinasiranjaComboBox);
				
				//dugmad
				JPanel panBtn = new JPanel();
				panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
				panBtn.add(btnPotvrdi);
				panBtn.add(Box.createHorizontalStrut(25));
				panBtn.add(btnOdustani);
				
				btnOdustani.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(mode)
							StudentiDodajDialog.getInstance().dispose();
						else {
							StudentiIzmenaDialog.getInstance().dispose();
							//BazaPredmeta.getInstance().setPredmeti(true);
						}
						return;
					}
				});

				btnPotvrdi.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						String message = MainFrame.getInstance().getResourceBundle().getString("postojeciBrojIndeksa");
						if(proveraUnosa.validateTxtFields()) {
							if(mode) {
								if(!Validate.validateUniqueIndex(txtBrIndexa.getText())) {
									JOptionPane.showMessageDialog(null, message);
									return;
								}
								StudentiController.getInstance().dodajStudenta();
								StudentiDodajDialog.getInstance().dispose();
							}
							else {
								if(isIndexSame() || Validate.validateUniqueIndex(txtBrIndexa.getText())) {
								StudentiController.getInstance().izmeniStudenta(StudentiJTable.getInstance().getSelectedRow());
								StudentiIzmenaDialog.getInstance().dispose();
								}else {
									JOptionPane.showMessageDialog(null, message);
									return;
								}
							}
							return;
						}
					}
				});
				
				//dodaj txtfieldove u niz
				listaTxt.add(txtIme);
				listaTxt.add(txtPrezime);
				listaTxt.add(txtDatumRodj);
				listaTxt.add(txtAdresaStan);
				listaTxt.add(txtBrojTel);
				listaTxt.add(txtEmail);
				listaTxt.add(txtBrIndexa);
				listaTxt.add(txtGodinaUpisa);
				//
				if(!mode) {
					refreshJTxtFields();
				}
				
				//uredi view
				Box box=Box.createVerticalBox();
				box.add(panIme);
				box.add(panPrezime);
				box.add(panDatumRodj);
				box.add(panAdresaStan);
				box.add(panBrojTel);
				box.add(panEmail);
				box.add(panBrIndexa);
				box.add(panGodinaUpisa);
				box.add(panTrenutnaGodinaStudija);
				box.add(panNacinFinansiranja);
				box.add(Box.createVerticalStrut(20));
				box.add(panBtn);
				box.add(Box.createGlue());
				this.add(box);

	}
	//pri editu
	public void refreshJTxtFields() {
		studentPanelChangeLanguage();
		//
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		Student student=StudentiController.getInstance().getStudent(selectedIndex);
		DateFormat dateFormat=new SimpleDateFormat("dd.mm.yyyy.");
		//setuj 
		listaTxt.get(0).setText(student.getIme());
		listaTxt.get(1).setText(student.getPrezime());
		listaTxt.get(2).setText(dateFormat.format(student.getDatumRodjenja()));
		listaTxt.get(3).setText(student.getAdresa());
		listaTxt.get(4).setText(student.getBrojTelefona());
		listaTxt.get(5).setText(student.getEmail());
		listaTxt.get(6).setText(student.getBrojIndexa());
		listaTxt.get(7).setText(Integer.toString(student.getGodinaUpisa()));
		//int trenutnaGodinaStudija
		trenutnaGodinaComboBox.setSelectedIndex(student.getTrenutnaGodinaStudija()-1);
		if(student.getStatus()==Status.B)
			nacinFinasiranjaComboBox.setSelectedIndex(0);
		else
			nacinFinasiranjaComboBox.setSelectedIndex(1);
		
	}
	//pri editu ukoliko je index isti kao sto je i bio necemo proveravati da li vec postoji u listi
	public boolean isIndexSame() {
		
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		Student student=StudentiController.getInstance().getStudent(selectedIndex);
		
		return (listaTxt.get(6).getText().equals(student.getBrojIndexa()))?true:false;
	}
	
	public void studentPanelChangeLanguage() {
        btnPotvrdi.setText(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
        btnOdustani.setText(MainFrame.getInstance().getResourceBundle().getString("odustani"));
        lblIme.setText(MainFrame.getInstance().getResourceBundle().getString("imeZvezda"));
        lblPrezime.setText(MainFrame.getInstance().getResourceBundle().getString("prezimeZvezda"));
        lblDatumRodj.setText(MainFrame.getInstance().getResourceBundle().getString("datumRodjZvezda"));
        lblAdresaStan.setText(MainFrame.getInstance().getResourceBundle().getString("adresaStanZvezda"));
        lblBrojTel.setText(MainFrame.getInstance().getResourceBundle().getString("brojTelZvezda"));
        lblEmail.setText(MainFrame.getInstance().getResourceBundle().getString("emailZvezda"));
        lblBrIndexa.setText(MainFrame.getInstance().getResourceBundle().getString("brIndexZvezda"));
        lblGodUpisa.setText(MainFrame.getInstance().getResourceBundle().getString("godUpisaZvezda"));
        lblTrenutnaGodinaStudija.setText(MainFrame.getInstance().getResourceBundle().getString("trenutnaGodinaStudijaZvezda"));
        lblNacinFinansiranja.setText(MainFrame.getInstance().getResourceBundle().getString("nacinFinansiranjaZvezda"));
        trenutnaGodinaComboBox.removeAllItems();
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("prva"));
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("druga"));
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("treca"));
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("cetvrta"));
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("master"));
        trenutnaGodinaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("doktorske"));
        nacinFinasiranjaComboBox.removeAllItems();
        nacinFinasiranjaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("budzet"));
        nacinFinasiranjaComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("samofinansiranje"));
    }
}
