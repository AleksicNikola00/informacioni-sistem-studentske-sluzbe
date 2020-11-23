package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Kreiraj");
		btnOpen.setIcon(new ImageIcon("images/kreiraj_22x22.png"));
	
		add(btnOpen);
		
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmeni");
		btnEdit.setIcon(new ImageIcon("images/izmeni_22x22.png"));
		add(btnEdit);
		
		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Obriši");
		btnDelete.setIcon(new ImageIcon("images/obrisi_22x22.png"));
		add(btnDelete);
	}
	
}
