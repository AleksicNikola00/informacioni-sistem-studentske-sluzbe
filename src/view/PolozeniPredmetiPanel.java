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






public class PolozeniPredmetiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static PolozeniPredmetiPanel instance=null;
	
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
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		//panel na vrhu
	//	Dimension dim = new Dimension((int)(screenWidth / 7), (int)(screenHeight / 25));
		JPanel btnPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnPanel.setPreferredSize(new Dimension((3*screenWidth/7),75));
		JButton btnPonistiOcenu = new JButton("Poništi ocenu");
		btnPanel.add(Box.createHorizontalStrut(screenWidth/50));
		btnPanel.add(btnPonistiOcenu);
		//btnPanel.setBackground(Color.GREEN);
		add(btnPanel,BorderLayout.NORTH);
		//validate();
		
		//centralniPanel
		JTable tabelaPolozenihPredmeta=new OceneJTable();
		JScrollPane scrollPane1=new JScrollPane(tabelaPolozenihPredmeta);
		scrollPane1.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25,(3*screenHeight/8)-10));
		//
		JPanel centralPanel=new JPanel();
		//centralPanel.setBackground(Color.PINK);
		centralPanel.setPreferredSize(new Dimension((3*screenWidth/7)-screenWidth/25,(3*screenHeight/8)));
		centralPanel.add(scrollPane1,BorderLayout.CENTER);
		add(centralPanel,BorderLayout.CENTER);
		
		
		//donjiPanel
		JPanel labelPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		labelPanel.setPreferredSize(new Dimension((3*screenWidth/7)-50,100));
		//labelPanel.setBackground(Color.GREEN);
		JLabel lblProsecnaOcena = new JLabel("Prosečna ocena: 0");
		JLabel lblESPB=new JLabel("Ukupno EPSB: 0");
		Box box=Box.createVerticalBox();
		box.add(lblProsecnaOcena);
		box.add(lblESPB);

		labelPanel.add(box);
		add(labelPanel,BorderLayout.SOUTH);
		
	}
}
