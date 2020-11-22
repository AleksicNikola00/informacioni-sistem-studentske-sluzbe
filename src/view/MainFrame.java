package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MyMenuBar myMenuBar=new MyMenuBar();
		this.setJMenuBar(myMenuBar);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		
		Dimension dim = new Dimension(200, 30);
		
		JPanel panSearch = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(dim);
        searchBox.setToolTipText("Unesi tekst");
		
        JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Traži");
		btnSearch.setIcon(new ImageIcon("images/pretrazi_22x22.png"));
		
		panSearch.add(searchBox);
		panSearch.add(btnSearch);
		panCenter.add(panSearch, BorderLayout.NORTH);
		
		JPanel firstPan = new JPanel();
		JPanel secondPan = new JPanel();
		JPanel thirdPan = new JPanel();
		JLabel todoLbl1 = new JLabel("TODO: Prikaz studenata");
		JLabel todoLbl2 = new JLabel("TODO: Prikaz profesora");
		JLabel todoLbl3 = new JLabel("TODO: Prikaz predmeta");
		firstPan.add(todoLbl1);
		secondPan.add(todoLbl2);
		thirdPan.add(todoLbl3);
		JTabbedPane panEntities = new JTabbedPane();
		panEntities.add("Studenti", firstPan);
		panEntities.add("Profesori", secondPan);
		panEntities.add("Predmet", thirdPan);
		
	    panCenter.add(panEntities, BorderLayout.CENTER);
		add(panCenter, BorderLayout.CENTER);

		MyStatusBar myStatusBar= new MyStatusBar();
		this.add(myStatusBar,BorderLayout.SOUTH);
	}
	
}
