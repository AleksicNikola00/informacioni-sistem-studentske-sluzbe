package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ProfesoriDodajDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8727863466776967183L;

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
		Dimension dim = new Dimension(120, 20);
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("ime");
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("prezime");
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodj = new JLabel("Datum roðenja*:");
		lblDatumRodj.setPreferredSize(dim);
		JTextField txtDatumRodj = new JTextField();
		txtDatumRodj.setPreferredSize(dim);
		txtDatumRodj.setName("datum rodjenja");
		panDatumRodj.add(lblDatumRodj);
		panDatumRodj.add(txtDatumRodj);
		
		Box box = Box.createVerticalBox();
		box.add(panIme);
		box.add(panPrezime);
		box.add(panDatumRodj);
		box.add(Box.createGlue());
		panel.add(box);
	}
}
