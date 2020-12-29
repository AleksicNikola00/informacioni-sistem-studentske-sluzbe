package view;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.PredmetiController;
import listeners.MyWindowListener;
 
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
	private JTable tabelaStudenata;
	private JTable tabelaPredmeta;
	private int selectedIndex;
	
	private MainFrame() {
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
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
	
	public JTable getTabelaStudenata() {
		return tabelaStudenata;
	}
	
	public JTable getTabelaPredmeta() {
		return tabelaPredmeta;
	}

	public void azurirajPrikaz() {
		AbstractTableModelProfesori modelProfesor = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		modelProfesor.fireTableDataChanged();
		
		AbstractTableModelStudenti modelStudent=(AbstractTableModelStudenti) tabelaStudenata.getModel();
		modelStudent.fireTableDataChanged();
		
		AbstractTableModelPredmeti modelPredmet = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		modelPredmet.fireTableDataChanged();
		
		validate();
	}
	
	private void inicijalizacija() {
		MyMenuBar myMenuBar=new MyMenuBar();
		this.setJMenuBar(myMenuBar);
		
		Toolbar toolbar = Toolbar.getInstance();
		add(toolbar, BorderLayout.NORTH);
		
		JPanel firstPan = new JPanel();
		//JLabel todoLbl3 = new JLabel("TODO: Prikaz predmeta");
		//firstPan.add(todoLbl3);
		JPanel secondPan = new JPanel();
		JPanel thirdPan = new JPanel();
		secondPan.setLayout(new BorderLayout());
		firstPan.setLayout(new BorderLayout());
		thirdPan.setLayout(new BorderLayout());
		JTabbedPane panEntities = new JTabbedPane();
		panEntities.add("Studenti", firstPan);
		panEntities.add("Profesori", secondPan);
		panEntities.add("Predmeti", thirdPan);
		
		add(panEntities, BorderLayout.CENTER);
		
		panEntities.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		        selectedIndex = tabbedPane.getSelectedIndex();
		        if(selectedIndex == 2)
		        {
		        	//BazaPredmeta.getInstance().setPredmeti(true);
		        	PredmetiController.getInstance().changeList(true);
		        }
			
			}
		});
		
		addWindowListener(MyWindowListener.getInstance());
		MyStatusBar myStatusBar= new MyStatusBar();
		this.add(myStatusBar,BorderLayout.SOUTH);
		
		tabelaProfesora = ProfesoriJTable.getInstance();
		tabelaStudenata= StudentiJTable.getInstance();//new StudentiJTable();
		tabelaPredmeta = new PredmetiJTable();
		
		tabelaStudenata.setAutoCreateRowSorter(true);
		JScrollPane scrollPane1 = new JScrollPane(tabelaProfesora);
		secondPan.add(scrollPane1, BorderLayout.CENTER);
		
		JScrollPane scrollPane2 = new JScrollPane(tabelaStudenata);
		firstPan.add(scrollPane2, BorderLayout.CENTER);
		
		JScrollPane scrollPane3 = new JScrollPane(tabelaPredmeta);
		thirdPan.add(scrollPane3, BorderLayout.CENTER);
		
		
		this.azurirajPrikaz();
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

}
