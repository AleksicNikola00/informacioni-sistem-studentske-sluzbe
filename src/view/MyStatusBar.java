package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MyStatusBar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labela1;
	private JLabel labela2=new JLabel();
	
	MyStatusBar(){
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(0,30));
		clock();
		
		
		labela1=new JLabel("Studentska služba");
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
						DateFormat df1 = DateFormat.getDateInstance();
                        DateFormat df2 = DateFormat.getTimeInstance();
                        String datum = df1.format(new Date());
                        String vreme = df2.format(new Date());
                        labela2.setText(datum + "    " + vreme);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	public void statusbarChangeLanguage() {
        labela1.setText(MainFrame.getInstance().getResourceBundle().getString("naslov"));
    }
	
}
