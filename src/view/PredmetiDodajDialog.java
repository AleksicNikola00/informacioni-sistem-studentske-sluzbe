package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.DodajPredmetProfesoruListener;
import listeners.SwitchTxtFieldListener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PredmetiDodajDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  PredmetiDodajDialog instance=null;
	private static ArrayList<JTextField> listaTxt;
	private static JButton btnPotvrdi;
	private static JButton btnOdustani;
	private static JComboBox<Integer> godinaStudijaComboBox;
	private static JComboBox<String> semestarComboBox;
	private static JTextField txtProfesor;
	
	public static PredmetiDodajDialog getInstance() {
		if(instance==null)
			instance=new PredmetiDodajDialog();
	
		return instance;
	}
	
	public static JTextField getTxtProfesor() {
		return txtProfesor;
	}
	
	public static  ArrayList<JTextField> getTxtFields(){
		return listaTxt;
	}
	
	public static JButton getBtn() {
		return btnPotvrdi;
	}
	
	
	public static JComboBox<Integer> godinaStudijaComboBox(){
		return godinaStudijaComboBox;
	}
	
	public static JComboBox<String> semestarComboBox(){
		return semestarComboBox;
	}
	
	private PredmetiDodajDialog() {
		super(MainFrame.getInstance(),"Dodaj predmet",true);
		listaTxt=new ArrayList<JTextField>();
		btnPotvrdi=new JButton("Potvrdi");
		btnOdustani = new JButton("Odustani");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 7 );
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel = new JPanel();
		add(panel);
		Dimension dim = new Dimension((int)(screenWidth / 7), (int)(screenHeight / 25));
		Dimension dimProfesor=new Dimension((int)(screenWidth / 12),(int)(screenHeight / 25));
		
		//sifra predmeta
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Šifra*");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.setText("E2");
		txtSifra.setName("txtSifraPredmeta");
		//txtIme.addFocusListener(proveraUnosa);
		txtSifra.addActionListener(new SwitchTxtFieldListener());
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		//nazivPredmeta
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Naziv*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setText("Analiza");
		txtIme.setName("txtNazivPredmeta");
		//txtIme.addFocusListener(proveraUnosa);
		txtIme.addActionListener(new SwitchTxtFieldListener());
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		//godinaStudija
		JPanel panGodinaStudija=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Godina*");
		lblGodinaStudija.setPreferredSize(dim);
		panGodinaStudija.add(lblGodinaStudija);
		Integer[] godinaStudija= {1,2,3,4,5,6};
		godinaStudijaComboBox=new JComboBox<Integer>(godinaStudija);
		godinaStudijaComboBox.setPreferredSize(dim);
		panGodinaStudija.add(godinaStudijaComboBox);
		
		//semestar
		JPanel panSemestar= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSemestar = new JLabel("Semestar*");
		lblSemestar.setPreferredSize(dim);
		panSemestar.add(lblSemestar);
		String[] semestar= {"letnji","zimski"};
		semestarComboBox= new JComboBox<String>(semestar);
		semestarComboBox.setPreferredSize(dim);
		panSemestar.add(semestarComboBox);
		
		//ESPB
		JPanel panESPB= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblESPB = new JLabel("ESPB*");
		lblESPB.setPreferredSize(dim);
		JTextField txtESPB=new JTextField();
		txtESPB.setPreferredSize(dim);
		//
		txtESPB.addActionListener(new SwitchTxtFieldListener());
		panESPB.add(lblESPB);
		panESPB.add(txtESPB);
		
		//PROFSEOR
		JPanel panProfesor= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblProfesor = new JLabel("Profesor*");
		lblProfesor.setPreferredSize(dim);
		txtProfesor=new JTextField();
		txtProfesor.setPreferredSize(dimProfesor);
		txtProfesor.setText("");
		txtProfesor.setEditable(false);
		txtProfesor.setBackground(Color.WHITE);
		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor);
		panProfesor.add(Box.createHorizontalStrut(10));
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new DodajPredmetProfesoruListener());
		
		panProfesor.add(btnPlus);
		panProfesor.add(Box.createHorizontalStrut(10));
		JButton btnMinus=new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					txtProfesor.setText("");
				
			}
		});
		panProfesor.add(btnMinus);
		
		
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
						dispose();
						return;
					}
				});
				
		listaTxt.add(txtSifra);
		listaTxt.add(txtIme);
		
		//uredi view
		Box box=Box.createVerticalBox();
		box.add(panIme);
		box.add(panSifra);
		box.add(panGodinaStudija);
		box.add(panSemestar);
		box.add(panESPB);
		box.add(panProfesor);
		box.add(Box.createVerticalStrut(20));
		box.add(panBtn);
		box.add(Box.createGlue());
		panel.add(box);
	}
	
	
	
	
	
	
	
	
	
	
	
}
