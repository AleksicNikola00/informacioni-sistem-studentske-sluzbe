package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class ProfesoriDodajDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8463065586503738400L;

	private static ProfesoriDodajDialog instance=null;
	private static ProfesorPanel panelDodaj;
	
	public static ProfesoriDodajDialog getInstance() {
		if(instance==null)
			instance=new ProfesoriDodajDialog();
		
		return instance;
	}

	public ProfesorPanel getPanelDodaj() {
		return panelDodaj;
	}

	private ProfesoriDodajDialog() {
		super(MainFrame.getInstance(), "Dodaj profesora", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 4 - screenHeight / 30);
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		panelDodaj = new ProfesorPanel(true);
		add(panelDodaj);
	}
	
	public void profesoriDodajDialogChangeLanguage() {
		setTitle(MainFrame.getInstance().getResourceBundle().getString("dodajProfesora"));
		panelDodaj.profesorPanelChangeLanguage();
	}
}
