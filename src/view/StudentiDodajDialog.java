package view;

import java.awt.Dimension;
import java.awt.Toolkit;



import javax.swing.JDialog;







public class StudentiDodajDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StudentPanel panelDodaj;
	
	private static StudentiDodajDialog instance=null;
	public static StudentiDodajDialog getInstance() {
		if(instance==null)
			instance=new StudentiDodajDialog();
		
		return instance;
	}
	
	public StudentPanel getStudentPanelDodaj(){
		return panelDodaj;
	}

	private StudentiDodajDialog() {
		super(MainFrame.getInstance(),"Dodaj studenta",true);
		//
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 4 - screenHeight / 30);
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		 panelDodaj=new StudentPanel(true);	//true-otvaramo u mod-u dodavanja
		add(panelDodaj);
	}
	
	public void studentiDodajDialogChangeLanguage() {
        setTitle(MainFrame.getInstance().getResourceBundle().getString("dodajStudenta"));
        panelDodaj.studentPanelChangeLanguage();
    }
	
}
