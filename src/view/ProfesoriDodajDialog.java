package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BazaProfesora;

public class ProfesoriDodajDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195495952053849388L;
	private JPanel panZvanjeComboBox;
	private JPanel panTitulaComboBox;
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	
	public ProfesoriDodajDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4 - 500, 3 * screenHeight / 4 - 25);
		setLocationRelativeTo(parent);
		
		inicijalizacija();
	}
	
	private void inicijalizacija() {
		JPanel panel = new JPanel();
		add(panel);
		Dimension dim = new Dimension(200, 30);
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setText("pr. Pero");
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setText("pr. Periæ");
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodj = new JLabel("Datum roðenja*");
		lblDatumRodj.setPreferredSize(dim);
		JTextField txtDatumRodj = new JTextField();
		txtDatumRodj.setPreferredSize(dim);
		txtDatumRodj.setText("pr. 25.2.1980.");
		panDatumRodj.add(lblDatumRodj);
		panDatumRodj.add(txtDatumRodj);
		
		JPanel panAdresaStan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
		lblAdresaStan.setPreferredSize(dim);
		JTextField txtAdresaStan = new JTextField();
		txtAdresaStan.setPreferredSize(dim);
		txtAdresaStan.setText("pr. Ulica Alekse Šantiæa 4");
		panAdresaStan.add(lblAdresaStan);
		panAdresaStan.add(txtAdresaStan);
		
		JPanel panBrojTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTel = new JLabel("Broj telefona*");
		lblBrojTel.setPreferredSize(dim);
		JTextField txtBrojTel = new JTextField();
		txtBrojTel.setPreferredSize(dim);
		txtBrojTel.setText("pr. 063265456");
		panBrojTel.add(lblBrojTel);
		panBrojTel.add(txtBrojTel);
		
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setText("pr. pero.peric@uns.ac.rs");
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		JPanel panAdresaKanc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
		lblAdresaKanc.setPreferredSize(dim);
		JTextField txtAdresaKanc = new JTextField();
		txtAdresaKanc.setPreferredSize(dim);
		txtAdresaKanc.setText("pr. Ulica Alekse Šantiæa 4");
		panAdresaKanc.add(lblAdresaKanc);
		panAdresaKanc.add(txtAdresaKanc);
		
		JPanel panBrojLK = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojLK = new JLabel("Broj liène karte*");
		lblBrojLK.setPreferredSize(dim);
		JTextField txtBrojLK = new JTextField();
		txtBrojLK.setPreferredSize(dim);
		txtBrojLK.setText("pr. A54FG5HJ3M");
		panBrojLK.add(lblBrojLK);
		panBrojLK.add(txtBrojLK);
		
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(new Dimension(195, 30));
		panZvanje.add(lblZvanje);
		panZvanjeComboBox = new JPanel();
		zvanjeComboBox();
		panZvanje.add(panZvanjeComboBox);
		
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(new Dimension(195, 30));
		panTitula.add(lblTitula);
		panTitulaComboBox = new JPanel();
		titulaComboBox();
		panTitula.add(panTitulaComboBox);
		
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.X_AXIS));
		JButton btnPotvrdi = new JButton("Potvrdi");
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
				String s = txtIme.getText().trim();
				int length = s.length();
				
				if (length == 0) {
					JOptionPane.showMessageDialog(null, "Neispravno ime!");
					return;
				}
				else if (Character.isUpperCase(s.charAt(0)) == false) {
					JOptionPane.showMessageDialog(null, "Neispravno ime!");
					return;
				}
				
				for (int i = 1; i < length; i++) {
			        if (Character.isLowerCase(s.charAt(i)) == false) {
			        	JOptionPane.showMessageDialog(null, "Neispravno ime!");
						return;
			        }
			    }
				
				s = txtPrezime.getText().trim();
				length = s.length();
				
				if (length == 0) {
					JOptionPane.showMessageDialog(null, "Neispravno prezime");
					return;
				}
				else if (Character.isUpperCase(s.charAt(0)) == false) {
					JOptionPane.showMessageDialog(null, "Neispravno prezime!");
					return;
				}
				
				for (int i = 1; i < length; i++) {
			        if (Character.isLowerCase(s.charAt(i)) == false) {
			        	JOptionPane.showMessageDialog(null, "Neispravno prezime!");
						return;
			        }
			    }
				
				s = txtDatumRodj.getText().trim();
				length = s.length();
				
				if (length == 0) {
					JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				
				for (int i = 0; i < length; i++) {
			        if (Character.isDigit(s.charAt(i)) == false && s.charAt(i) != '.') {
			        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
						return;
			        }
			    }
				
				int brojTacaka = 0;
				for (int i = 0; i < length; i++) {
			        if (s.charAt(i) == '.')
			        	brojTacaka++;
			    }
				if (brojTacaka != 3) {
		        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				
				String datum[] = s.split("\\.", 4);
				int day = Integer.parseInt(datum[0]);
				int month = Integer.parseInt(datum[1]);
				int year = Integer.parseInt(datum[2]);
				if (!(day >= 1 && day <= 31)) {
		        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				if (!(month >= 1 && month <= 12)) {
		        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				if (!(year >= 1950 && year <= 2000)) {
		        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				if (!(datum[3].trim().equals(""))) {
		        	JOptionPane.showMessageDialog(null, "Neispravan datum roðenja!");
					return;
				}
				
				s = txtAdresaStan.getText().trim();
				length = s.length();
				
				if (length == 0) {
					JOptionPane.showMessageDialog(null, "Neispravna adresa stanovanja!");
					return;
				}
				
				for (int i = 0; i < length; i++) {
			        if (!(Character.isDigit(s.charAt(i)) == true || Character.isLetter(s.charAt(i)) == true || s.charAt(i) == ' ' )) {
			        	JOptionPane.showMessageDialog(null, "Neispravan adresa stanovanja!");
						return;
			        }
			    }
				
				s = txtBrojTel.getText().trim();
				length = s.length();
				
				if (length < 9 || length > 13) {
					JOptionPane.showMessageDialog(null, "Neispravan broj telefona!");
					return;
				}
				
				for (int i = 0; i < length; i++) {
			        if (Character.isDigit(s.charAt(i)) == false) {
			        	JOptionPane.showMessageDialog(null, "Neispravan broj telefona!");
						return;
			        }
			    }
				
				s = txtEmail.getText().trim();
				length = s.length();

				int brojLudoA = 0;
				for (int i = 0; i < length; i++) {
			        if (s.charAt(i) == '@') {
			        	brojLudoA++;
			        }
			    }
				if (brojLudoA != 1) {
		        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
					return;
		        }
				
				for (int i = 0; i < length; i++) {
			        if (!(Character.isDigit(s.charAt(i)) == true || Character.isLetter(s.charAt(i)) == true || s.charAt(i) == '.' || s.charAt(i) == '@')) {
			        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
						return;
			        }
			    }
				
				String mail[] = s.split("@", 2);
				
				length = mail[0].length();
				brojTacaka = 0;
				for (int i = 0; i < length; i++) {
			        if (mail[0].charAt(i) == '.') {
			        	brojTacaka++;
			        }
			    }
				
				String prefiks[] = mail[0].split("\\.", brojTacaka + 1);
				for (int i = 0; i < brojTacaka + 1; i++) {
			        if (prefiks[i].equals("")) {
			        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
						return;
			        }
			    }
				
				length = mail[1].length();
				brojTacaka = 0;
				for (int i = 0; i < length; i++) {
			        if (mail[1].charAt(i) == '.') {
			        	brojTacaka++;
			        }
			    }
				if (brojTacaka == 0){
		        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
					return;
		        }
				
				String domen[] = mail[1].split("\\.", brojTacaka + 1);
				for (int i = 0; i < brojTacaka + 1; i++) {
			        if (domen[i].equals("")) {
			        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
						return;
			        }
			    }
				
				if (domen[brojTacaka].length() <= 1){
		        	JOptionPane.showMessageDialog(null, "Neispravna email adresa!");
					return;
		        }
				
				
				s = txtAdresaKanc.getText().trim();
				length = s.length();
				
				if (length == 0) {
					JOptionPane.showMessageDialog(null, "Neispravna adresa kancelarije!");
					return;
				}
				
				for (int i = 0; i < length; i++) {
			        if (!(Character.isDigit(s.charAt(i)) == true || Character.isLetter(s.charAt(i)) == true || s.charAt(i) == ' ' )) {
			        	JOptionPane.showMessageDialog(null, "Neispravna adresa kancelarije!");
						return;
			        }
			    }
				
				s = txtBrojLK.getText().trim();
				length = s.length();
				
				if (length < 6 || length > 13) {
					JOptionPane.showMessageDialog(null, "Neispravan broj liène karte!");
					return;
				}
				
				for (int i = 0; i < length; i++) {
			        if (!(Character.isDigit(s.charAt(i)) == true || Character.isUpperCase(s.charAt(i)) == true)) {
			        	JOptionPane.showMessageDialog(null, "Neispravan broj liène karte!");
						return;
			        }
			    }
				
				String zvanje = combo1.getSelectedItem().toString();
				String titula = combo2.getSelectedItem().toString();
				
				BazaProfesora.getInstance().dodajProfesora(txtIme.getText().trim(), txtPrezime.getText().trim(), zvanje, titula, LocalDate.of(year, month, day),
						txtAdresaStan.getText().trim(), txtBrojTel.getText().trim(), txtEmail.getText().trim(), txtAdresaKanc.getText().trim(), txtBrojLK.getText().trim());
				dispose();
			}
		});
		
		
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

	private void zvanjeComboBox() {
		String[] zvanja = {"Docent", "Vanredni profesor", "Redovni profesor"};
		combo1 = new JComboBox<String>(zvanja);
		combo1.setPreferredSize(new Dimension(200, 30));

		this.panZvanjeComboBox.add(combo1);

		combo1.setSelectedIndex(0);
	}
	
	private void titulaComboBox() {
		String[] titule = {"Doktor nauka"};
		combo2 = new JComboBox<String>(titule);
		combo2.setPreferredSize(new Dimension(200, 30));

		this.panTitulaComboBox.add(combo2);

		combo2.setSelectedIndex(0);
	}
}