package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class IzmenaStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static IzmenaStudentaDialog instance=null;
	
	public static IzmenaStudentaDialog getInstance() {
		if(instance==null)
			instance=new IzmenaStudentaDialog();
		
		return instance;
	}
	
	private IzmenaStudentaDialog() {
		super(MainFrame.getInstance(),"Izmeni studenta",true);
		//
		//
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((3*screenWidth/7) , 3 * screenHeight / 5 );
		setLocationRelativeTo(MainFrame.getInstance());
			
		inicijalizacija(screenWidth, screenHeight);
	}
	
	private void inicijalizacija(int screenWidth, int screenHeight) {
		JPanel panel = new JPanel();
		add(panel);
		//Dimension dim = new Dimension((int)(screenWidth / 7), (int)(screenHeight / 25));

		StudentPanel firstPan=new StudentPanel(false);
		JPanel secondPan = new JPanel();
		JPanel thirdPan = new JPanel();

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
