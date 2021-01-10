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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetiController;
import controller.Validate;
import listeners.DodajPredmetuProfesoraListener;
import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;
import model.Predmet;

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
	private static JButton btnPlus;
	private static JButton btnMinus;
	private static JComboBox<Integer> godinaStudijaComboBox;
	private static JComboBox<String> semestarComboBox;
	private static JTextField txtProfesor;
	private static boolean mode;//true-dodaj false-izmeni
	private JLabel lblSifra;
	private JLabel lblIme;
	private JLabel lblGodinaStudija;
	private JLabel lblSemestar;
	private JLabel lblESPB;
	private JLabel lblProfesor;
	
	public static PredmetiDodajDialog getInstance() {
		if(instance==null)
			instance=new PredmetiDodajDialog();
	
		return instance;
	}

	public static JButton getBtnMinus() {
		return btnMinus;
	}

	public static JButton getBtnPlus() {
		return btnPlus;
	}
	
	public static JTextField getTxtProfesor() {
		return txtProfesor;
	}
	
	public static void setTxtProfesor(String imePrezime) {
		txtProfesor.setText(imePrezime);
	}
	
	public static  ArrayList<JTextField> getTxtFields(){
		return listaTxt;
	}
	
	public static JButton getBtn() {
		return btnPotvrdi;
	}
	
	
	public static JComboBox<Integer> getGodinaStudijaComboBox(){
		return godinaStudijaComboBox;
	}
	
	public static JComboBox<String> getSemestarComboBox(){
		return semestarComboBox;
	}
	
	
	private PredmetiDodajDialog() {
		super(MainFrame.getInstance(),"Dodaj predmet",true);
		listaTxt=new ArrayList<JTextField>();
		btnPotvrdi=new JButton("Potvrdi");
		btnOdustani = new JButton("Odustani");
		btnPlus = new JButton("+");
		btnMinus= new JButton("-");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 6 );
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel = new JPanel();
		add(panel);
		Dimension dim = new Dimension((int)(screenWidth / 7), (int)(screenHeight / 25));
		Dimension dimProfesor=new Dimension((int)(screenWidth / 12),(int)(screenHeight / 25));
		MyFocusListener proveraUnosa= new MyFocusListener(listaTxt,btnPotvrdi,btnOdustani);
		
		//sifra predmeta
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblSifra = new JLabel("Šifra*");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.setText("E2");
		txtSifra.setName("txtSifraPredmeta");
		//txtIme.addFocusListener(proveraUnosa);
		txtSifra.addActionListener(new SwitchTxtFieldListener());
		txtSifra.addFocusListener(proveraUnosa);
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		//nazivPredmeta
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblIme = new JLabel("Naziv*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setText("Analiza");
		txtIme.setName("txtNazivPredmeta");
		//txtIme.addFocusListener(proveraUnosa);
		txtIme.addActionListener(new SwitchTxtFieldListener());
		txtIme.addFocusListener(proveraUnosa);
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		//godinaStudija
		JPanel panGodinaStudija=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblGodinaStudija = new JLabel("Godina*");
		lblGodinaStudija.setPreferredSize(dim);
		panGodinaStudija.add(lblGodinaStudija);
		Integer[] godinaStudija= {1,2,3,4,5,6};
		godinaStudijaComboBox=new JComboBox<Integer>(godinaStudija);
		godinaStudijaComboBox.setPreferredSize(dim);
		panGodinaStudija.add(godinaStudijaComboBox);
		
		//semestar
		JPanel panSemestar= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblSemestar = new JLabel("Semestar*");
		lblSemestar.setPreferredSize(dim);
		panSemestar.add(lblSemestar);
		String[] semestar= {"letnji","zimski"};
		semestarComboBox= new JComboBox<String>(semestar);
		semestarComboBox.setPreferredSize(dim);
		panSemestar.add(semestarComboBox);
		
		//ESPB
		JPanel panESPB= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblESPB = new JLabel("ESPB*");
		lblESPB.setPreferredSize(dim);
		JTextField txtESPB=new JTextField();
		txtESPB.setPreferredSize(dim);
		txtESPB.setText("9");
		txtESPB.setName("txtESPB");
		//
		txtESPB.addActionListener(new SwitchTxtFieldListener());
		txtESPB.addFocusListener(proveraUnosa);
		panESPB.add(lblESPB);
		panESPB.add(txtESPB);
		
		//PROFSEOR
		JPanel panProfesor= new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblProfesor = new JLabel("Profesor*");
		lblProfesor.setPreferredSize(dim);
		txtProfesor=new JTextField();
		txtProfesor.setPreferredSize(dimProfesor);
		txtProfesor.setName("txtProfesor");
		txtProfesor.setText("");
		txtProfesor.setEditable(false);
		txtProfesor.setBackground(Color.WHITE);
		txtProfesor.addFocusListener(proveraUnosa);
		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor);
		panProfesor.add(Box.createHorizontalStrut(10));
		//JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new DodajPredmetuProfesoraListener(proveraUnosa));
		
		panProfesor.add(btnPlus);
		panProfesor.add(Box.createHorizontalStrut(10));
		//JButton btnMinus=new JButton("-");
		btnMinus.setEnabled(false);
		btnMinus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	Object[] buttons= {MainFrame.getInstance().getResourceBundle().getString("potvrdi"), MainFrame.getInstance().getResourceBundle().getString("odustani")};
            	JPanel panText = new JPanel();
            	JLabel label = new JLabel(MainFrame.getInstance().getResourceBundle().getString("jesiSiguran"));
            	panText.add(Box.createHorizontalGlue());
            	panText.add(label);
            	panText.add(Box.createHorizontalGlue());
            	String title = MainFrame.getInstance().getResourceBundle().getString("ukloniProfesoraTitle");
            	int dijalog = JOptionPane.showOptionDialog(MainFrame.getInstance(), panText,
        				title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, buttons, null);
            	
            	if(dijalog == JOptionPane.YES_OPTION) {
	            	txtProfesor.setText("");
	                btnPlus.setEnabled(true);
	                btnMinus.setEnabled(false);
            	}
            }
        });
		panProfesor.add(btnMinus);
		
		
		//dugmad
				JPanel panBtn = new JPanel();
				panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
				//JButton btnOdustani = new JButton("Odustani");
				btnPotvrdi.setEnabled(true);
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
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(proveraUnosa.validateTxtFields()) {
							String message = MainFrame.getInstance().getResourceBundle().getString("postojecaSifraError");
							if(getMode()) {
								if(!Validate.validateUniqueSifra(txtSifra.getText())) {
									JOptionPane.showMessageDialog(null, message);
									return;
								}
									PredmetiController.getInstance().dodajPredmet();
							}
							else {
								if(!isSifraSame() && !Validate.validateUniqueSifra(txtSifra.getText())) {
									JOptionPane.showMessageDialog(null, message);
									return;
								}
								PredmetiController.getInstance().izmeniPredmet(MainFrame.getInstance().getTabelaPredmeta().getSelectedRow());
							}
							dispose();
							return;
						}else {
							if(txtProfesor.getText().equals("")) {
								String message = MainFrame.getInstance().getResourceBundle().getString("invalidProfesor");
								JOptionPane.showMessageDialog(null, message);
								btnPotvrdi.setEnabled(false);
							}
						}
					}
				});
				
				
				
		listaTxt.add(txtSifra);
		listaTxt.add(txtIme);
		listaTxt.add(txtESPB);
		//listaTxt.add(txtProfesor);
		
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

	public static boolean getMode() {
		return mode;
	}

	public static void setMode(boolean mode) {
		PredmetiDodajDialog.mode = mode;
	}
	
	//edit
	public  void refreshPredmetPanel() {
		if(!mode)
		{
			int indexPredmeta=MainFrame.getInstance().getTabelaPredmeta().getSelectedRow();
			Predmet predmet=PredmetiController.getInstance().getPredmet(indexPredmeta);
			setTitle(MainFrame.getInstance().getResourceBundle().getString("izmeniPredmet"));
			listaTxt.get(0).setText(predmet.getSifraPredmeta());
			listaTxt.get(1).setText(predmet.getNazivPredmeta());
			listaTxt.get(2).setText(Integer.toString(predmet.getBrojESPB()));
			//listaTxt.get(3).setText(predmet.getProfesor().getIme()+" "+predmet.getProfesor().getPrezime());
			if(predmet.getProfesor()!=null) {
				setTxtProfesor(predmet.getProfesor().getIme()+" "+predmet.getProfesor().getPrezime());
				btnPlus.setEnabled(false);
				btnMinus.setEnabled(true);
			}
			else
			{
				setTxtProfesor("");
				btnPlus.setEnabled(true);
				btnMinus.setEnabled(false);
			}
			godinaStudijaComboBox.setSelectedIndex(predmet.getGodinaStudija()-1);
			//btnPlus.setEnabled(false);
			//btnMinus.setEnabled(true);
			if(predmet.getSemestar().equals(MainFrame.getInstance().getResourceBundle().getString("letnji")))
				semestarComboBox.setSelectedIndex(0);//letnji
			else
				semestarComboBox.setSelectedIndex(1);
		}
		else
			setTitle(MainFrame.getInstance().getResourceBundle().getString("dodajPredmet"));

	}
	
	public boolean isSifraSame() {
		//boolean isSame=false;
		int indexPredmeta=MainFrame.getInstance().getTabelaPredmeta().getSelectedRow();
		Predmet predmet=PredmetiController.getInstance().getPredmet(indexPredmeta);
		
		return (listaTxt.get(0).getText().equals(predmet.getSifraPredmeta()))?true:false;
	}
	
	public void predmetiDialogChangeLanguage() {
        btnPotvrdi.setText(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
        btnOdustani.setText(MainFrame.getInstance().getResourceBundle().getString("odustani"));
        lblSifra.setText(MainFrame.getInstance().getResourceBundle().getString("sifraZvezda"));
        lblIme.setText(MainFrame.getInstance().getResourceBundle().getString("nazivZvezda"));
        lblGodinaStudija.setText(MainFrame.getInstance().getResourceBundle().getString("godinaZvezda"));
        lblSemestar.setText(MainFrame.getInstance().getResourceBundle().getString("semestarZvezda"));
        lblESPB.setText(MainFrame.getInstance().getResourceBundle().getString("espbZvezda"));
        lblProfesor.setText(MainFrame.getInstance().getResourceBundle().getString("profesorZvezda"));
        semestarComboBox.removeAllItems();
        semestarComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("letnji"));
        semestarComboBox.addItem(MainFrame.getInstance().getResourceBundle().getString("zimski"));
    }
	
}
