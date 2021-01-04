package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.PredmetiController;
import listeners.DodajProfesoruPredmet;
import listeners.UkloniPredmetProfesoru;

public class PredmetePredajeProfesorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9047471325747789550L;

	private static PredmetePredajeProfesorPanel instance=null;
	private JTable predmetiKojeProfesorPredaje;
	private JButton btnDodaj;
	private JButton btnObrisi;
	
	public JTable getPredmetiKojeProfesorPredaje() {
		return predmetiKojeProfesorPredaje;
	}

	public static PredmetePredajeProfesorPanel getInstance() {
		if(instance==null)
			instance=new PredmetePredajeProfesorPanel();
		
		return instance;
	}
	
	private PredmetePredajeProfesorPanel() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnPanel.setPreferredSize(new Dimension((3*screenWidth/7),75));
		btnDodaj = new JButton("Dodaj predmet");
		btnDodaj.addActionListener(new DodajProfesoruPredmet());
		btnObrisi = new JButton("Ukloni predmet");
		btnObrisi.addActionListener(new UkloniPredmetProfesoru());
		btnPanel.add(Box.createHorizontalStrut(screenWidth/50));
		btnPanel.add(btnDodaj);
		btnPanel.add(btnObrisi);
		add(btnPanel,BorderLayout.NORTH);
		
		predmetiKojeProfesorPredaje = new PredmetiJTable();
		JScrollPane scrollPane = new JScrollPane(predmetiKojeProfesorPredaje);
		scrollPane.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25, (3*screenHeight/8)-10));
		JPanel centralPanel = new JPanel();
		centralPanel.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25, (3*screenHeight/8)));
		centralPanel.add(scrollPane, BorderLayout.CENTER);
		add(centralPanel,BorderLayout.CENTER);
	}
	
	public void refreshPanel() {
		PredmetiController.getInstance().changeList(3); 
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti)predmetiKojeProfesorPredaje.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void predmetePredajeProfesorChangeLanguage() {
		btnDodaj.setText(MainFrame.getInstance().getResourceBundle().getString("dodajPredmet"));
		btnObrisi.setText(MainFrame.getInstance().getResourceBundle().getString("ukloniPredmet"));
	}
}
