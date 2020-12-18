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

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new BorderLayout());
		
		JPanel toolbarLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Kreiraj");
		btnOpen.setIcon(new ImageIcon("images/kreiraj_22x22.png"));
		toolbarLeft.add(btnOpen);
		
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmeni");
		btnEdit.setIcon(new ImageIcon("images/izmeni_22x22.png"));
		toolbarLeft.add(btnEdit);
		
		
		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Obriši");
		btnDelete.setIcon(new ImageIcon("images/obrisi_22x22.png"));
		toolbarLeft.add(btnDelete);
		
		add(toolbarLeft, BorderLayout.WEST);
		
		JPanel toolbarRight = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		Dimension dim = new Dimension(200, 30);
		JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(dim);
        searchBox.setToolTipText("Unesi tekst");
		
        JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Traži");
		btnSearch.setIcon(new ImageIcon("images/pretrazi_22x22.png"));
		
		toolbarRight.add(searchBox);
		toolbarRight.add(btnSearch);
		
		add(toolbarRight, BorderLayout.EAST);
		
		btnOpen.addActionListener(new AddActionListener());
	}

}
