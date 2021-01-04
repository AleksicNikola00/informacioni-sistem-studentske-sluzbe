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
	private JTabbedPane panEntities;
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
		panEntities.setTitleAt(0, MainFrame.getInstance().getResourceBundle().getString("informacije"));
        panEntities.setTitleAt(1, MainFrame.getInstance().getResourceBundle().getString("polozeni"));
        panEntities.setTitleAt(2, MainFrame.getInstance().getResourceBundle().getString("nepolozeni"));
        setTitle(MainFrame.getInstance().getResourceBundle().getString("izmeniStudenta"));
        //
		firstPan.refreshJTxtFields();
		secondPan.refreshPanel();
		thirdPan.refreshPanel();
	}
	public StudentPanel getStudentPanel() {
		return firstPan;
	}
	public void refreshPolozeniPanel() {
		secondPan.refreshPanel();
	}
	
	
	public void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel=new JPanel();
		add(panel);
		
		firstPan=new StudentPanel(false);
		secondPan =PolozeniPredmetiPanel.getInstance();
		thirdPan = NepolozeniPredmetiPanel.getInstance();

		
		panEntities = new JTabbedPane();
		panEntities.add("Informacije",firstPan);
		panEntities.add("Položeni", secondPan);
		panEntities.add("Nepoloženi", thirdPan);
		
		add(panEntities,BorderLayout.CENTER);
	}
}
