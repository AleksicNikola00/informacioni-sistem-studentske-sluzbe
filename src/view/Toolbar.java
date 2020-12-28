package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import listeners.AddActionListener;
import listeners.DeleteActionListener;
import listeners.EditActionListener;
import listeners.SearchActionListener;

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static Toolbar instance = null;

	public static Toolbar getInstance() {
		if (instance == null) {
			instance = new Toolbar();
		}
		return instance;
	}
	
	
	private JTextField searchBox;
	
	public JTextField getSearchBox() {
		return searchBox;
	}

	public void setSearchBox(JTextField searchBox) {
		this.searchBox = searchBox;
	}

	private Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new BorderLayout());
		
		JPanel toolbarLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Kreiraj");
		btnOpen.setIcon(new ImageIcon("images/kreiraj.jpg"));
		btnOpen.addActionListener(new AddActionListener());
		toolbarLeft.add(btnOpen);
		
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmeni");
		btnEdit.setIcon(new ImageIcon("images/izmeni.jpg"));
		btnEdit.addActionListener(new EditActionListener());
		toolbarLeft.add(btnEdit);
		
		
		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Obriši");
		btnDelete.setIcon(new ImageIcon("images/obrisi.jpg"));
		btnDelete.addActionListener(new DeleteActionListener());
		toolbarLeft.add(btnDelete);
		
		add(toolbarLeft, BorderLayout.WEST);
		
		JPanel toolbarRight = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		Dimension dim = new Dimension(200, 30);
		 searchBox = new JTextField();
        searchBox.setPreferredSize(dim);
        searchBox.setToolTipText("Unesi tekst");
		
        JButton btnSearch = new JButton();
        btnSearch.addActionListener(new SearchActionListener());
		btnSearch.setToolTipText("Traži");
		btnSearch.setIcon(new ImageIcon("images/pretrazi.jpg"));
		
		toolbarRight.add(searchBox);
		toolbarRight.add(btnSearch);
		
		add(toolbarRight, BorderLayout.EAST);
		
	}

}
