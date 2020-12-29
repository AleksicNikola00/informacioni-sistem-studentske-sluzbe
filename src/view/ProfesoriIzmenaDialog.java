package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ProfesoriIzmenaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 519270021078642646L;

	private static ProfesoriIzmenaDialog instance=null;
	private static ProfesorPanel firstPan;
	//private static PolozeniPredmetiPanel secondPan;
	private static JPanel secondPan;
	
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
		firstPan.refreshProfesorFirstPanel();
		//secondPan.refreshPanel();
	}
	
	public void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel=new JPanel();
		add(panel);
		
		firstPan = new ProfesorPanel(false);
		//secondPan =PolozeniPredmetiPanel.getInstance();
		secondPan = new JPanel();
		
		JTabbedPane panEntities = new JTabbedPane();
		panEntities.add("Info", firstPan);
		panEntities.add("Predmeti", secondPan);
		
		add(panEntities, BorderLayout.CENTER);
	}
}
