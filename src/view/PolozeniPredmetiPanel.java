package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.OceneController;
import controller.StudentiController;
import listeners.PonistiOcenu;
import model.Student;






public class PolozeniPredmetiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static PolozeniPredmetiPanel instance=null;
	private JTable tabelaPolozenihPredmeta;
	private JLabel lblProsecnaOcena;
	private JLabel lblESPB;
	private JButton btnPonistiOcenu;
	private Student student;
	
	public JButton getBtnPonistiOcenu() {
		return btnPonistiOcenu;
	}

	public static PolozeniPredmetiPanel getInstance() {
		if(instance==null)
			instance=new PolozeniPredmetiPanel();
		
		return instance;
	}
	
	private PolozeniPredmetiPanel() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		inicijalizacija(screenWidth, screenHeight);
	}
	
	public Student getStudent() {
		return student;
	}
	
	public JTable getTabelaPolozenihPredmeta() {
		return tabelaPolozenihPredmeta;
	}
	
	public void refreshPanel() {
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		student=StudentiController.getInstance().getStudent(selectedIndex);
		//postavlja ocene trenutnog studenta
		OceneController.getInstance().refreshOcene(student.getSpisakPolozenihIspita());
		//
		btnPonistiOcenu.setText(MainFrame.getInstance().getResourceBundle().getString("btnPonistiOcenu"));
		lblProsecnaOcena.setText(MainFrame.getInstance().getResourceBundle().getString("lblProsecnaOcena") + " " +student.getProsecnaOcena());
        lblESPB.setText(MainFrame.getInstance().getResourceBundle().getString("lblESPB") + " " + student.getBrojESPB());
		//
		AbstractTableModelOcene model= (AbstractTableModelOcene)tabelaPolozenihPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
		//
	}
	private void inicijalizacija(int screenWidth, int screenHeight) {
		//
		
		int selectedIndex=StudentiJTable.getInstance().getSelectedRow();
		student=StudentiController.getInstance().getStudent(selectedIndex);
		//panel na vrhu
		JPanel btnPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnPanel.setPreferredSize(new Dimension((3*screenWidth/7),75));
		btnPonistiOcenu = new JButton("Poništi ocenu");
		btnPonistiOcenu.addActionListener(new PonistiOcenu());
		btnPanel.add(Box.createHorizontalStrut(screenWidth/50));
		btnPanel.add(btnPonistiOcenu);
		add(btnPanel,BorderLayout.NORTH);
		//validate();
		
		//centralniPanel
		//BazaOcena.getInstance().setOcene(student.getSpisakPolozenihIspita());
		OceneController.getInstance().refreshOcene(student.getSpisakPolozenihIspita());
		tabelaPolozenihPredmeta=OceneJTable.getInstance();
		JScrollPane scrollPane1=new JScrollPane(tabelaPolozenihPredmeta);
		scrollPane1.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25,(3*screenHeight/8)-10));
		//
		JPanel centralPanel=new JPanel();
		centralPanel.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25,(3*screenHeight/8)));
		centralPanel.add(scrollPane1,BorderLayout.CENTER);
		add(centralPanel,BorderLayout.CENTER);
		
		
		//donjiPanel
		JPanel labelPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		labelPanel.setPreferredSize(new Dimension((3*screenWidth/7)-50,100));
		lblProsecnaOcena = new JLabel("Prosečna ocena: "+student.getProsecnaOcena());
		lblESPB=new JLabel("Ukupno EPSB: "+student.getBrojESPB());
		Box box=Box.createVerticalBox();
		box.add(lblProsecnaOcena);
		box.add(lblESPB);

		labelPanel.add(box);
		add(labelPanel,BorderLayout.SOUTH);
		
	}

}
