package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MyStatusBar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labela2=new JLabel();
	
	MyStatusBar(){
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(0,30));
		clock();
		
		
		JLabel labela1=new JLabel("Studentska služba");
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new BorderLayout());
		add(labela1,BorderLayout.WEST);
		add(Box.createHorizontalGlue());
		add(labela2,BorderLayout.EAST);
	}
	
	public void clock() {
		
		Thread clock=new Thread() {
			public void run() {
				try {
					while(true) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd    HH:mm:ss");  
						LocalDateTime now = LocalDateTime.now(); 
						labela2.setText(dtf.format(now));
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
}
