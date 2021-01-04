package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class ProfesoriIzmenaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 519270021078642646L;

	private static ProfesoriIzmenaDialog instance=null;
	private static ProfesorPanel firstPan;
	private static PredmetePredajeProfesorPanel secondPan;
	private JTabbedPane panEntities;
	
	public static ProfesoriIzmenaDialog getInstance() {
		if(instance==null)
			instance=new ProfesoriIzmenaDialog();
		
		return instance;
	}
	
	public ProfesorPanel getFirstPan() {
		return firstPan;
	}

	private ProfesoriIzmenaDialog() {
		super(MainFrame.getInstance(),"Izmeni profesora",true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 4 - screenHeight / 30);
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	public void refreshProfesorPanel() {
		panEntities.setTitleAt(0, MainFrame.getInstance().getResourceBundle().getString("info"));
		panEntities.setTitleAt(1, MainFrame.getInstance().getResourceBundle().getString("predmeti"));
		setTitle(MainFrame.getInstance().getResourceBundle().getString("izmeniProfesora"));
		firstPan.refreshProfesorFirstPanel();
		secondPan.refreshPanel();
	}
	
	public void inicijalizacija(int screenWidth, int screenHeight) {
		firstPan = new ProfesorPanel(false);
		secondPan = PredmetePredajeProfesorPanel.getInstance();
		
		panEntities = new JTabbedPane();
		panEntities.add("Info", firstPan);
		panEntities.add("Predmeti", secondPan);
		
		add(panEntities, BorderLayout.CENTER);
	}
	
}
