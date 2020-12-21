package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentiController;
import model.Student.Status;

//import com.sun.tools.javac.launcher.Main;



public class StudentiDodajDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentiDodajDialog instance=null;
	private static ArrayList<JTextField> listaTxt=new ArrayList<JTextField>();
	private static JButton btnPotvrdi=new JButton("Potvrdi");
	
	public static StudentiDodajDialog getInstance() {
		if(instance==null)
			instance=new StudentiDodajDialog();
		
		return instance;
	}
	
	public static  ArrayList<JTextField> getTxtFields(){
		return listaTxt;
	}
	
	public static JButton getBtn() {
			return btnPotvrdi;
		}
	
	private StudentiDodajDialog() {
		super(MainFrame.getInstance(),"Dodaj Studenta",true);
		//
		ArrayList<JTextField> listaTxt=new ArrayList<JTextField>();
		JButton btnPotvrdi=new JButton("Potvrdi");
		//
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3 * screenWidth / 4 - 500)/2, (3 * screenHeight / 4 - 25)*4/5);
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija();
	}
	
	
	
	private void inicijalizacija() {
		JPanel panel = new JPanel();
		//panel.setBackground(Color.black);
		add(panel);
		Dimension dim = new Dimension(200, 30);
		MyFocusListener proveraUnosa= new MyFocusListener();
		
		//ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setText("Pero");
		txtIme.setName("txtIme");
		txtIme.addFocusListener(proveraUnosa);
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		//prz
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setText("Perić");
		txtPrezime.setName("txtPrz"); //isto kao i ime zbog provere!
		txtPrezime.addFocusListener(proveraUnosa);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		//datRodj
		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodj = new JLabel("Datum rodjenja*");
		lblDatumRodj.setPreferredSize(dim);
		JTextField txtDatumRodj = new JTextField();
		txtDatumRodj.setPreferredSize(dim);
		txtDatumRodj.setText("25.02.1980.");
		txtDatumRodj.setName("datRodj");
		txtDatumRodj.addFocusListener(proveraUnosa);
		panDatumRodj.add(lblDatumRodj);
		panDatumRodj.add(txtDatumRodj);
		
		//adresa
		JPanel panAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
		lblAdresaStan.setPreferredSize(dim);
		JTextField txtAdresaStan = new JTextField();
		txtAdresaStan.setPreferredSize(dim);
		txtAdresaStan.setText("Ulica Alekse Šantića 4");
		txtAdresaStan.setName("txtAdresa");
		txtAdresaStan.addFocusListener(proveraUnosa);
		panAdresaStan.add(lblAdresaStan);
		panAdresaStan.add(txtAdresaStan);
		
		//telefon
		JPanel panBrojTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTel = new JLabel("Broj telefona*");
		lblBrojTel.setPreferredSize(dim);
		JTextField txtBrojTel = new JTextField();
		txtBrojTel.setPreferredSize(dim);
		txtBrojTel.setText("063265456");
		txtBrojTel.setName("txtBroj");
		txtBrojTel.addFocusListener(proveraUnosa);
		panBrojTel.add(lblBrojTel);
		panBrojTel.add(txtBrojTel);
		
		//email
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setText("pero.peric@uns.ac.rs");
		txtEmail.setName("txtEmail");
		txtEmail.addFocusListener(proveraUnosa);
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		//brIndexa
		JPanel panBrIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrIndexa= new JLabel("Broj indexa*");
		lblBrIndexa.setPreferredSize(dim);
		JTextField txtBrIndexa=new JTextField("RA-24/2018");
		txtBrIndexa.setPreferredSize(dim);
		txtBrIndexa.setName("txtIndex");
		txtBrIndexa.addFocusListener(proveraUnosa);
		panBrIndexa.add(lblBrIndexa);
		panBrIndexa.add(txtBrIndexa);
		
		//godinaUpisa
		JPanel panGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodUpisa=new JLabel("Godina upisa*");
		lblGodUpisa.setPreferredSize(dim);
		JTextField txtGodinaUpisa=new JTextField("2018");
		txtGodinaUpisa.setPreferredSize(dim);
		txtGodinaUpisa.setName("txtGodinaUpisa");
		txtGodinaUpisa.addFocusListener(proveraUnosa);
		panGodinaUpisa.add(lblGodUpisa);
		panGodinaUpisa.add(txtGodinaUpisa);
		
		//TrenutnaGodinaStudija
		JPanel panTrenutnaGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija*");
		lblTrenutnaGodinaStudija.setPreferredSize(dim);
		panTrenutnaGodinaStudija.add(lblTrenutnaGodinaStudija);
		String[] godinaStudiranja= {"I (prva)","II (druga)","III (treća)","IV (četvrta)","Master","Doktorske"};
		JComboBox<String> trenutnaGodinaComboBox = new JComboBox<String>(godinaStudiranja);
		trenutnaGodinaComboBox.setPreferredSize(dim);
		panTrenutnaGodinaStudija.add(trenutnaGodinaComboBox);
		
		//NacinFinansiranja
		JPanel panNacinFinansiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNacinFinansiranja=new JLabel("Način finansiranja*");
		lblNacinFinansiranja.setPreferredSize(dim);
		panNacinFinansiranja.add(lblNacinFinansiranja);
		String[] nacinFinansiranja= {"Budžet","Samofinansiranje"};
		JComboBox<String> nacinFinasiranjaComboBox = new JComboBox<String>(nacinFinansiranja);
		nacinFinasiranjaComboBox.setPreferredSize(dim);
		panNacinFinansiranja.add(nacinFinasiranjaComboBox);

		//dugmad
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
				return;
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(proveraUnosa.validateTxtFields()) {
					//String ime, String prezime, Calendar datumRodjenja, String adresa, String email, String brojTelefona,
					//String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status
					Status s;
					if(nacinFinasiranjaComboBox.getSelectedIndex()==0)
						s=Status.B;
					else
						s=Status.S;
				
					int godina=0;
					if(trenutnaGodinaComboBox.getSelectedItem().equals("I (prva)"))
						godina=1;
					else if(trenutnaGodinaComboBox.getSelectedItem().equals("II (druga)"))
						godina=2;
					else if(trenutnaGodinaComboBox.getSelectedItem().equals("III (treća)"))
						godina=3;
					else
						godina=4;
					
					String[] datum=txtDatumRodj.getText().split("\\.", 4);
					StudentiController.getInstance().dodajStudenta(txtIme.getText(),txtPrezime.getText(),new GregorianCalendar(Integer.parseInt(datum[2]),Integer.parseInt(datum[1]), Integer.parseInt(datum[0])),
							txtAdresaStan.getText(),txtEmail.getText(),txtBrojTel.getText(),txtBrIndexa.getText(),Integer.parseInt(txtGodinaUpisa.getText()),godina,
							s);
					dispose();
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

		panel.add(box);
	}
	
}
