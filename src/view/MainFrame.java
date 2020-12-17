package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private JTable tabelaProfesora;
	
	private MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		inicijalizacija();
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	private void inicijalizacija() {
		MyMenuBar myMenuBar=new MyMenuBar();
		this.setJMenuBar(myMenuBar);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		JPanel firstPan = new JPanel();
		JPanel secondPan = new JPanel();
		secondPan.setLayout(new BorderLayout());
		JPanel thirdPan = new JPanel();
		JLabel todoLbl1 = new JLabel("TODO: Prikaz studenata");
		JLabel todoLbl3 = new JLabel("TODO: Prikaz predmeta");
		firstPan.add(todoLbl1);	
		thirdPan.add(todoLbl3);
		JTabbedPane panEntities = new JTabbedPane();
		panEntities.add("Studenti", firstPan);
		panEntities.add("Profesori", secondPan);
		panEntities.add("Predmet", thirdPan);
		
		add(panEntities, BorderLayout.CENTER);

		MyStatusBar myStatusBar= new MyStatusBar();
		this.add(myStatusBar,BorderLayout.SOUTH);
		
		tabelaProfesora = new ProfesoriJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
		secondPan.add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz();
	}
	
}
