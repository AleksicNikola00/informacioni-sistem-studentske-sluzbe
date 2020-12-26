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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;
import model.BazaStudenta;
import model.Student;


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
		//za edit mode
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		Student student=null;
		if(!mode)
			student=BazaStudenta.getInstance().getRow(selectedIndex);
		//
		//ime
				JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblIme = new JLabel("Ime*");
				lblIme.setPreferredSize(dim);
				JTextField txtIme = new JTextField();
				txtIme.setPreferredSize(dim);
				if(mode)
					txtIme.setText("Pero");
				else
					txtIme.setText(student.getIme());
				txtIme.setName("txtIme");
				txtIme.addFocusListener(proveraUnosa);
				txtIme.addActionListener(new SwitchTxtFieldListener());
				panIme.add(lblIme);
				panIme.add(txtIme);
				//this.add(lblIme);
			
			//prz
				JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblPrezime = new JLabel("Prezime*");
				lblPrezime.setPreferredSize(dim);
				JTextField txtPrezime = new JTextField();
				txtPrezime.setPreferredSize(dim);
				if(mode)
					txtPrezime.setText("Perić");
				else
					txtPrezime.setText(student.getPrezime());
				txtPrezime.setName("txtPrz"); //isto kao i ime zbog provere!
				txtPrezime.addFocusListener(proveraUnosa);
				txtPrezime.addActionListener(new SwitchTxtFieldListener());
				panPrezime.add(lblPrezime);
				panPrezime.add(txtPrezime);
		
				//datRodj
				JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblDatumRodj = new JLabel("Datum rođenja*");
				lblDatumRodj.setPreferredSize(dim);
				JTextField txtDatumRodj = new JTextField();
				txtDatumRodj.setPreferredSize(dim);
				if(mode)
					txtDatumRodj.setText("25.02.1980.");
				else
					txtDatumRodj.setText(student.getDatumRodjenja());
				txtDatumRodj.setName("datRodj");
				txtDatumRodj.addFocusListener(proveraUnosa);
				txtDatumRodj.addActionListener(new SwitchTxtFieldListener());
				panDatumRodj.add(lblDatumRodj);
				panDatumRodj.add(txtDatumRodj);
				
				//adresa
				JPanel panAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
				lblAdresaStan.setPreferredSize(dim);
				JTextField txtAdresaStan = new JTextField();
				txtAdresaStan.setPreferredSize(dim);
				if(mode)
					txtAdresaStan.setText("Ulica Alekse Šantića 4");
				else
					txtAdresaStan.setText(student.getAdresa());
				txtAdresaStan.setName("txtAdresa");
				txtAdresaStan.addFocusListener(proveraUnosa);
				txtAdresaStan.addActionListener(new SwitchTxtFieldListener());
				panAdresaStan.add(lblAdresaStan);
				panAdresaStan.add(txtAdresaStan);
				
				//telefon
				JPanel panBrojTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblBrojTel = new JLabel("Broj telefona*");
				lblBrojTel.setPreferredSize(dim);
				JTextField txtBrojTel = new JTextField();
				txtBrojTel.setPreferredSize(dim);
				if(mode)
					txtBrojTel.setText("066439698");
				else
					txtBrojTel.setText(student.getBrojTelefona());
				txtBrojTel.setName("txtBroj");
				txtBrojTel.addFocusListener(proveraUnosa);
				txtBrojTel.addActionListener(new SwitchTxtFieldListener());
				panBrojTel.add(lblBrojTel);
				panBrojTel.add(txtBrojTel);
				
				//email
				JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblEmail = new JLabel("E-mail adresa*");
				lblEmail.setPreferredSize(dim);
				JTextField txtEmail = new JTextField();
				txtEmail.setPreferredSize(dim);
				if(mode)
					txtEmail.setText("pero.peric@uns.ac.rs");
				else
					txtEmail.setText(student.getEmail());;
				txtEmail.setName("txtEmail");
				txtEmail.addFocusListener(proveraUnosa);
				txtEmail.addActionListener(new SwitchTxtFieldListener());
				panEmail.add(lblEmail);
				panEmail.add(txtEmail);
				
				//brIndexa
				JPanel panBrIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblBrIndexa= new JLabel("Broj indexa*");
				lblBrIndexa.setPreferredSize(dim);
				JTextField txtBrIndexa=new JTextField();
				txtBrIndexa.setName("txtIndex");
				txtBrIndexa.setPreferredSize(dim);
				if(mode)
					txtBrIndexa.setText("RA-24/2018");
				else
					txtBrIndexa.setText(student.getBrojIndexa());
				txtBrIndexa.addFocusListener(proveraUnosa);
				txtBrIndexa.addActionListener(new SwitchTxtFieldListener());
				panBrIndexa.add(lblBrIndexa);
				panBrIndexa.add(txtBrIndexa);
				
				//godinaUpisa
				JPanel panGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblGodUpisa=new JLabel("Godina upisa*");
				lblGodUpisa.setPreferredSize(dim);
				JTextField txtGodinaUpisa=new JTextField();
				txtGodinaUpisa.setPreferredSize(dim);
				if(mode)
					txtGodinaUpisa.setText("2018");
				else
					txtGodinaUpisa.setText(Integer.toString(student.getGodinaUpisa()));
				txtGodinaUpisa.setName("txtGodinaUpisa");
				txtGodinaUpisa.addFocusListener(proveraUnosa);
				txtGodinaUpisa.addActionListener(new SwitchTxtFieldListener());
				panGodinaUpisa.add(lblGodUpisa);
				panGodinaUpisa.add(txtGodinaUpisa);
				
				//TrenutnaGodinaStudija
				JPanel panTrenutnaGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija*");
				lblTrenutnaGodinaStudija.setPreferredSize(dim);
				panTrenutnaGodinaStudija.add(lblTrenutnaGodinaStudija);
				String[] godinaStudiranja= {"I (prva)","II (druga)","III (treća)","IV (četvrta)","Master","Doktorske"};
				trenutnaGodinaComboBox = new JComboBox<String>(godinaStudiranja);
				trenutnaGodinaComboBox.setPreferredSize(dim);
				panTrenutnaGodinaStudija.add(trenutnaGodinaComboBox);
				
				//NacinFinansiranja
				JPanel panNacinFinansiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel lblNacinFinansiranja=new JLabel("Način finansiranja*");
				lblNacinFinansiranja.setPreferredSize(dim);
				panNacinFinansiranja.add(lblNacinFinansiranja);
				String[] nacinFinansiranja= {"Budžet","Samofinansiranje"};
				nacinFinasiranjaComboBox = new JComboBox<String>(nacinFinansiranja);
				nacinFinasiranjaComboBox.setPreferredSize(dim);
				panNacinFinansiranja.add(nacinFinasiranjaComboBox);
				
				//dugmad
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
							StudentiDodajDialog.getInstance().dispose();
						else
							IzmenaStudentaDialog.getInstance().dispose();
						return;
					}
				});

				btnPotvrdi.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						if(proveraUnosa.validateTxtFields()) {
							if(mode) {
								StudentiController.getInstance().dodajStudenta(getPanel());
								StudentiDodajDialog.getInstance().dispose();
							}
							else {
								StudentiController.getInstance().izmeniStudenta(selectedIndex,getPanel());
								IzmenaStudentaDialog.getInstance().dispose();
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
	
}
