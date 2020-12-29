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

import listeners.DodajPredmetStudentu;


public class NepolozeniPredmetiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2480661972392136347L;
	
	private static NepolozeniPredmetiPanel instance=null;
	private JTable tabelaNepolozenihPredmeta;
	
	public static NepolozeniPredmetiPanel getInstance() {
		if(instance==null)
			instance=new NepolozeniPredmetiPanel();
		
		return instance;
	}
	
	private NepolozeniPredmetiPanel() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnPanel.setPreferredSize(new Dimension((3*screenWidth/7),75));
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new DodajPredmetStudentu());
		JButton btnObrisi = new JButton("Obriši");
		JButton btnPolaganje = new JButton("Polaganje");
		btnPanel.add(Box.createHorizontalStrut(screenWidth/50));
		btnPanel.add(btnDodaj);
		btnPanel.add(btnObrisi);
		btnPanel.add(btnPolaganje);
		add(btnPanel,BorderLayout.NORTH);
		
		tabelaNepolozenihPredmeta = new PredmetiJTable();
		JScrollPane scrollPane = new JScrollPane(tabelaNepolozenihPredmeta);
		scrollPane.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25, (3*screenHeight/8)-10));
		JPanel centralPanel=new JPanel();
		centralPanel.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25, (3*screenHeight/8)));
		centralPanel.add(scrollPane, BorderLayout.CENTER);
		add(centralPanel,BorderLayout.CENTER);
		
	}
	
	public void refreshPanel() {
		PredmetiController.getInstance().changeList(false); 
		AbstractTableModelPredmeti model= (AbstractTableModelPredmeti)tabelaNepolozenihPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
