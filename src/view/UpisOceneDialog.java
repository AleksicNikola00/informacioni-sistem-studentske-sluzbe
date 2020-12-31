package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.OceneController;
import controller.PredmetiController;
import controller.StudentiController;
import listeners.MyFocusListener;
import listeners.SwitchTxtFieldListener;
import model.Predmet;
import model.Student;

public class UpisOceneDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5546730580092345928L;

	private static UpisOceneDialog instance = null;
	private static JComboBox<Integer> ocenaComboBox;
	private static ArrayList<JTextField> listaTxt;
	private static JButton btnPotvrdi;
	private static JButton btnOdustani;
	private JTextField txtSifra;
	private JTextField txtIme;
	private JTextField txtDatum;
	private int ocena;
	private Student student;
	private int mode;
	
	public static UpisOceneDialog getInstance() {
		if(instance==null)
			instance = new UpisOceneDialog();
	
		return instance;
	}
	
	
	public JTextField getTxtDatum() {
		return txtDatum;
	}


	public void setTxtDatum(JTextField txtDatum) {
		this.txtDatum = txtDatum;
	}


	public int getOcena() {
		return ocena;
	}


	public void setOcena(int ocena) {
		this.ocena = ocena;
	}


	private UpisOceneDialog() {
		super(StudentiIzmenaDialog.getInstance(), "Unos ocene", true);
		listaTxt = new ArrayList<JTextField>();
		btnPotvrdi = new JButton("Potvrdi");
		btnOdustani = new JButton("Odustani");
		txtSifra = new JTextField();
		txtIme = new JTextField();
		txtDatum = new JTextField();
		mode = PredmetiController.getInstance().getMode();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/4, screenHeight/3 );
		setLocationRelativeTo(StudentiIzmenaDialog.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel = new JPanel();
		add(panel);
		Dimension dim = new Dimension((int)(screenWidth / 10), (int)(screenHeight / 25));
		MyFocusListener proveraUnosa= new MyFocusListener(listaTxt, btnPotvrdi, btnOdustani);
		
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Šifra*");
		lblSifra.setPreferredSize(dim);
		txtSifra.setPreferredSize(dim);
		txtSifra.setEnabled(false);
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Naziv*");
		lblIme.setPreferredSize(dim);
		txtIme.setPreferredSize(dim);
		txtIme.setEnabled(false);
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		JPanel panOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOcena = new JLabel("Ocena*");
		lblOcena.setPreferredSize(dim);
		panOcena.add(lblOcena);
		Integer[] ocena = {6, 7, 8, 9, 10};
		ocenaComboBox = new JComboBox<Integer>(ocena);
		ocenaComboBox.setPreferredSize(dim);
		panOcena.add(ocenaComboBox);
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatum = new JLabel("Datum*");
		lblDatum.setPreferredSize(dim);
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("datRodj");
		txtDatum.addActionListener(new SwitchTxtFieldListener());
		txtDatum.addFocusListener(proveraUnosa);
		panDatum.add(lblDatum);
		panDatum.add(txtDatum);
		
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
		btnPotvrdi.setEnabled(false);
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
				if(proveraUnosa.validateTxtFields()) {
					int row = NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow();
					PredmetiController.getInstance().setMode(2);
					PredmetiController.getInstance().izbrisiPredmet(row);
					PredmetiController.getInstance().setMode(mode);
					Predmet predmet = OceneController.getInstance().getPredmet();
					
					int rowIndex=StudentiJTable.getInstance().getSelectedRow();
					student = StudentiController.getInstance().getStudent(rowIndex);
					OceneController.getInstance().setStudent(student);
					predmet.getStudentiKojiSuPoloziliPredmet().add(student);
					predmet.getStudentiKojiNisuPoloziliPredmet().remove(student);
					
					if(ocenaComboBox.getSelectedItem().equals(6))
						setOcena(6);
					else if(ocenaComboBox.getSelectedItem().equals(7))
						setOcena(7);
					else if(ocenaComboBox.getSelectedItem().equals(8))
						setOcena(8);
					else if(ocenaComboBox.getSelectedItem().equals(9))
						setOcena(9);
					else
						setOcena(10);
					OceneController.getInstance().setOcena(getOcena());
					
					try {
						OceneController.getInstance().setDatumPolaganjaIspita(new SimpleDateFormat("dd.mm.yyyy.").parse(txtDatum.getText()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					OceneController.getInstance().dodajOcenu();
					
					StudentiIzmenaDialog.getInstance().refreshStudentPanel();
					MainFrame.getInstance().azurirajPrikaz();
					dispose();
					return;
				}
			}
		});
		
		listaTxt.add(txtDatum);
		
		Box box=Box.createVerticalBox();
		box.add(panSifra);
		box.add(panIme);
		box.add(panOcena);
		box.add(panDatum);
		box.add(Box.createVerticalStrut(20));
		box.add(panBtn);
		box.add(Box.createGlue());
		panel.add(box);
	}
	
	public void refreshUpisOceneDialog(){
		int row = NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getSelectedRow();
		String value = (String)NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getValueAt(row, 0);
		txtSifra.setText(value);
		
		value = (String)NepolozeniPredmetiPanel.getInstance().getTabelaNepolozenihPredmeta().getValueAt(row, 1);
		txtIme.setText(value);
	}
}
