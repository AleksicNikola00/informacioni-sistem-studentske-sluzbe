package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MyMenuBar() {
		JMenu file= new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem fNew= new JMenuItem("New",KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		fNew.setIcon(new ImageIcon("images/Screenshot_1.jpg"));
		JMenuItem fClose= new JMenuItem("Close",KeyEvent.VK_C);
		fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		fClose.setIcon(new ImageIcon("images/Screenshot_2.jpg"));
		file.add(fNew);
		file.add(fClose);
		
		JMenu edit= new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem eEdit=new JMenuItem("Edit",KeyEvent.VK_E);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		eEdit.setIcon(new ImageIcon("images/edit.jpg"));
		JMenuItem eDelete=new JMenuItem("Delete",KeyEvent.VK_D);
		eDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));;
		eDelete.setIcon(new ImageIcon("images/delete.jpg"));
		edit.add(eEdit);
		edit.add(eDelete);
		
		JMenu help= new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem hHelp=new JMenuItem("Help",KeyEvent.VK_H);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		hHelp.setIcon(new ImageIcon("images/help.jpg"));
		JMenuItem hAbout=new JMenuItem("About",KeyEvent.VK_A);
		hAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		hAbout.setIcon(new ImageIcon("images/about.jpg"));
		help.add(hHelp);
		help.add(hAbout);
		
		add(file);
		add(edit);
		add(help);
	}
}
