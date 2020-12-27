package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class StudentiIzmenaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentiIzmenaDialog instance=null;
	private static StudentPanel firstPan;
	private static PolozeniPredmetiPanel secondPan;
	private static NepolozeniPredmetiPanel thirdPan;
	//private StudentPanel firstPan;
	
	public static StudentiIzmenaDialog getInstance() {
		if(instance==null)
			instance=new StudentiIzmenaDialog();
		
		return instance;
	}
	
	private StudentiIzmenaDialog() {
		super(MainFrame.getInstance(),"Izmeni studenta",true);
		//
		//
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 4 - screenHeight / 30);
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	public void refreshStudentPanel() {
		firstPan.refreshJTxtFields();
	}
	public StudentPanel getStudentPanel() {
		return firstPan;
	}

	
	public void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel=new JPanel();
		add(panel);
		
		firstPan=new StudentPanel(false);
		secondPan =PolozeniPredmetiPanel.getInstance();
		thirdPan = NepolozeniPredmetiPanel.getInstance();

		//secondPan.setLayout(new BorderLayout());
		//firstPan.setLayout(new BorderLayout());
		//thirdPan.setLayout(new BorderLayout());
		
		JTabbedPane panEntities = new JTabbedPane();
		panEntities.add("Informacije",firstPan);
		panEntities.add("Položeni", secondPan);
		panEntities.add("Nepoloženi", thirdPan);
		
		add(panEntities,BorderLayout.CENTER);
	}
}
